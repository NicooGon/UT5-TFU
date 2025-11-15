package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.PlaylistDTO;
import AndisUT2.ArtistAPI.Model.Playlist;

import java.util.List;

public interface IPlaylistService {

    List<PlaylistDTO> getAllPlaylists();
    PlaylistDTO getPlaylistById(int playlistID);
    List<PlaylistDTO> getPlaylistsByUserId(int userId);
    PlaylistDTO savePlaylist(String name, int userId);
}
