package AndisUT2.ArtistAPI.DTO;

import java.util.List;

public class PlaylistWithInfoDTO {

    private int playlistId;
    private String playlistName;
    private List<SongWithInfoDTO> songs;

    public PlaylistWithInfoDTO(int playlistId, String playlistName, List<SongWithInfoDTO> songs) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
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

    public List<SongWithInfoDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongWithInfoDTO> songs) {
        this.songs = songs;
    }

}
