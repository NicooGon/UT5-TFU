package AndisUT2.ArtistAPI.DTO;

import java.util.List;

public class PlaylistCreateRequestDTO {

    private String name;
    private int userId;
    private List<Integer> songIds;

    public PlaylistCreateRequestDTO() {}

    public PlaylistCreateRequestDTO(String name, int userId, List<Integer> songIds) {
        this.name = name;
        this.userId = userId;
        this.songIds = songIds;
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

    public List<Integer> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<Integer> songIds) {
        this.songIds = songIds;
    }
}
