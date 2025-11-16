package AndisUT2.ArtistAPI.Soap;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserByIdRequest", propOrder = {"userId"})
@XmlRootElement(name = "getUserByIdRequest", namespace = "http://artistapi.com/users")
public class GetUserByIdRequest {

    @XmlElement(required = true)
    private int userId;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}