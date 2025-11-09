package AndisUT2.ArtistAPI.Model;

public class Playlist {

    private int playlistID;
    private String name;
    private int userID;

    public Playlist(int playlistID, String name, int userID) {
        this.playlistID = playlistID;
        this.name = name;
        this.userID = userID;
    }

    public Playlist(String name, int userID) {
        this.name = name;
        this.userID = userID;
    }

    public Playlist() {
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}