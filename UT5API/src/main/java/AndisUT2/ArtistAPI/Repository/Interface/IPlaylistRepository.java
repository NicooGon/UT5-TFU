package AndisUT2.ArtistAPI.Repository.Interface;

import AndisUT2.ArtistAPI.Model.Playlist;

import java.util.List;

public interface IPlaylistRepository {
    List<Playlist> getAllPlaylists();
    Playlist getPlaylistById(int playlistId);
    List<Playlist> getPlaylistsByUserId(int userId);
    Playlist save(Playlist playlist);
}
