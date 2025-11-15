package AndisUT2.ArtistAPI.Soap;

import AndisUT2.ArtistAPI.Service.Interface.IUserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserSoapEndpoint {

    private static final String NAMESPACE = "http://artistapi.com/users";

    private final IUserService userService;

    public UserSoapEndpoint(IUserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request) {

        var entity = userService.getUserById(request.getUserId());

        // si no existe, devolvemos respuesta vacía (o podés tirar SOAP Fault)
        if (entity == null) {
            GetUserByIdResponse empty = new GetUserByIdResponse();
            empty.setUser(null);
            return empty;
        }

        // Mapeo a clase JAXB generada por XSD
        User user = new User();
        user.setUserId(entity.getUserId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setUsername(entity.getUsername());

        GetUserByIdResponse response = new GetUserByIdResponse();
        response.setUser(user);

        return response;
    }
}