package AndisUT2.ArtistAPI.DTO;

public class PlaylistDTO {

    private int playlistId;
    private String name;
    private int userId;

    public PlaylistDTO(int playlistId, String name, int userId) {
        this.playlistId = playlistId;
        this.name = name;
        this.userId = userId;
    }

    public PlaylistDTO(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public PlaylistDTO() {
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
