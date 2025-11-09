package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Model.Playlist;
import AndisUT2.ArtistAPI.Repository.PlaylistRepository;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.getAllPlaylists();
    }

    @Override
    public Playlist getPlaylistById(int playlistID) {
        return playlistRepository.getPlaylistById(playlistID);
    }

    @Override
    public List<Playlist> getPlaylistsByUserId(int userId) {
        return playlistRepository.getPlaylistsByUserId(userId);
    }

    @Override
    public Playlist savePlaylist(String name, int userId) {
        Playlist playlist = new Playlist(name, userId );
        return playlistRepository.save(playlist);
    }
}
