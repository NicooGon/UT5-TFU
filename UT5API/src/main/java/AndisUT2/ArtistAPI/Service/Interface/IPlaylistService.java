package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.Model.Playlist;

import java.util.List;

public interface IPlaylistService {

    public List<Playlist> getAllPlaylists();
    public Playlist getPlaylistById(int playlistID);
    public List<Playlist> getPlaylistsByUserId(int userId);
    public Playlist savePlaylist(String name, int userId);
}
