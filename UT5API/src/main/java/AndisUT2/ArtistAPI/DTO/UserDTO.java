package AndisUT2.ArtistAPI.DTO;

public class UserDTO {

    private int userId;
    private String name;
    private String email;
    private String username;

    public UserDTO(int userId, String name, String email, String username) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public UserDTO(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public UserDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
