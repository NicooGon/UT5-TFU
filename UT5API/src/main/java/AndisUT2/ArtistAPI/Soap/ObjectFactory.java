package AndisUT2.ArtistAPI.Soap;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public User createUser() {
        return new User();
    }

    public GetUserByIdRequest createGetUserByIdRequest() {
        return new GetUserByIdRequest();
    }

    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }
}