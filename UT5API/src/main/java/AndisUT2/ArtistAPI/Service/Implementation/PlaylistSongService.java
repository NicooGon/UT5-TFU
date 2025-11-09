package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Repository.PlaylistSongRepository;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistSongService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlaylistSongService implements IPlaylistSongService {

    private final PlaylistSongRepository playlistSongRepository;

    public PlaylistSongService(PlaylistSongRepository playlistSongRepository) {
        this.playlistSongRepository = playlistSongRepository;
    }

    @Override
    public void addSongToPlaylist(int playlistId, int songId) {
        try {
            playlistSongRepository.addSongToPlaylist(playlistId, songId);
        }
        catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al agregar la canción a la lista de reproducción: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> getSongsByPlaylistId(int playlistId) {
        return playlistSongRepository.getSongsByPlaylistId(playlistId);
    }

    @Override
    public List<Integer> getPlaylistsBySongId(int songId) {
        return playlistSongRepository.getPlaylistsBySongId(songId);
    }
}
