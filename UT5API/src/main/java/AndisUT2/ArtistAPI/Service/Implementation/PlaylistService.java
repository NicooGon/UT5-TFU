package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.DTO.PlaylistDTO;
import AndisUT2.ArtistAPI.Mapper.PlaylistMapper;
import AndisUT2.ArtistAPI.Model.Playlist;
import AndisUT2.ArtistAPI.Repository.PlaylistRepository;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {

    private final PlaylistRepository playlistRepository;
    private static final PlaylistMapper playlistMapper = PlaylistMapper.INSTANCE;


    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepository.getAllPlaylists().stream()
                .map(playlistMapper::playlistToPlaylistDTO).toList();
    }

    @Override
    public PlaylistDTO getPlaylistById(int playlistId) {
        Playlist playlist = playlistRepository.getPlaylistById(playlistId);
        return playlistMapper.playlistToPlaylistDTO(playlist);
    }

    @Override
    public List<PlaylistDTO> getPlaylistsByUserId(int userId) {
        return playlistRepository.getPlaylistsByUserId(userId).stream()
                .map(playlistMapper::playlistToPlaylistDTO).toList();
    }

    @Override
    public PlaylistDTO savePlaylist(String name, int userId) {
        Playlist playlist = new Playlist(name, userId);
        playlistRepository.save(playlist);
        return playlistMapper.playlistToPlaylistDTO(playlist);
    }
}
