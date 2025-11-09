package AndisUT2.ArtistAPI.Model;

public class User {

    private int userID;
    private String name;
    private String email;
    private String username;

    public User(int userID, String name, String email, String username) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public User(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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