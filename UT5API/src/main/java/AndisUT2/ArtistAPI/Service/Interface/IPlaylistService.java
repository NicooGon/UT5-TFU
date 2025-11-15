package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.PlaylistDTO;
import AndisUT2.ArtistAPI.Model.Playlist;

import java.util.List;

public interface IPlaylistService {

    public List<PlaylistDTO> getAllPlaylists();
    public PlaylistDTO getPlaylistById(int playlistID);
    public List<PlaylistDTO> getPlaylistsByUserId(int userId);
    public PlaylistDTO savePlaylist(String name, int userId);
}
