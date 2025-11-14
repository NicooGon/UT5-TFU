package AndisUT2.ArtistAPI.Soap;

import AndisUT2.ArtistAPI.Service.Interface.IUserService;
import com.artistapi.soap.GetUserByIdRequest;
import com.artistapi.soap.GetUserByIdResponse;
import com.artistapi.soap.User;
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

        var u = userService.getUserById(request.getUserId());

        User soapUser = new User();
        soapUser.setUserId(u.getUserId());
        soapUser.setName(u.getName());
        soapUser.setEmail(u.getEmail());
        soapUser.setUsername(u.getUsername());

        GetUserByIdResponse response = new GetUserByIdResponse();
        response.setUser(soapUser);

        return response;
    }
}
