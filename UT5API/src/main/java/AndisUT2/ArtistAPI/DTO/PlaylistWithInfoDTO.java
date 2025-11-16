package AndisUT2.ArtistAPI.DTO;

import java.util.List;

public class PlaylistWithInfoDTO {

    private int playlistId;
    private String playlistName;
    private int userId;
    private String username;
    private List<SongWithInfoDTO> songs;

    public PlaylistWithInfoDTO(int playlistId, String playlistName, String username,
                               int userId, List<SongWithInfoDTO> songs) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.userId = userId;
        this.username = username;
        this.songs = songs;
    }

    public PlaylistWithInfoDTO() {}

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getUserId() {return this.userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public List<SongWithInfoDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongWithInfoDTO> songs) {
        this.songs = songs;
    }

}
