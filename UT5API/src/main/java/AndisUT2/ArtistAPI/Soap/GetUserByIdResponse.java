package AndisUT2.ArtistAPI.Soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserByIdResponse", propOrder = {"user"})
@XmlRootElement(name = "getUserByIdResponse", namespace = "http://artistapi.com/users")
public class GetUserByIdResponse {

    @XmlElement(required = true)
    private User user;

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}