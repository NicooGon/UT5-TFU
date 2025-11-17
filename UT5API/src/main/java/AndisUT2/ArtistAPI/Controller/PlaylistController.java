package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.DTO.PlaylistCreateRequestDTO;
import AndisUT2.ArtistAPI.DTO.PlaylistDTO;
import AndisUT2.ArtistAPI.DTO.PlaylistWithInfoDTO;
import AndisUT2.ArtistAPI.Service.Implementation.ApplicationService;
import AndisUT2.ArtistAPI.Service.Interface.IApplicationService;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;

    @Autowired
    private IApplicationService applicationService;

    @GetMapping("/all")
    public ResponseEntity<List<PlaylistDTO>> getAllPlaylists() {
        List<PlaylistDTO> playlists = playlistService.getAllPlaylists();
        return playlists.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(playlists);
    }

    @Timed(
            value = "playlist.getById-LayerArchitecture",
            description = "Tiempo de consulta para obtener una playlist en Layer Architecture",
            percentiles = {0.5, 0.95, 0.99}
    )
    @GetMapping("/{id}")
    public ResponseEntity<PlaylistWithInfoDTO> getPlaylistById(@PathVariable int id) {
        PlaylistWithInfoDTO playlist = applicationService.optimizedGetPlaylistWithInfo(id);
        return ResponseEntity.ok(playlist);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaylistDTO>> getPlaylistsByUserId(@PathVariable int userId) {
        List<PlaylistDTO> playlists = playlistService.getPlaylistsByUserId(userId);
        return playlists.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(playlists);
    }

    @Timed(
            value = "playlist.save-LayerArchitecture",
            description = "Tiempo de consulta para guardar una playlist en Layer Architecture",
            percentiles = {0.5, 0.95, 0.99}
    )
    @PostMapping("/save")
    public ResponseEntity<PlaylistWithInfoDTO> savePlaylist(@RequestBody PlaylistCreateRequestDTO requestDTO) {
        PlaylistWithInfoDTO playlist =  applicationService.savePlaylistWithInfo(requestDTO);
        return ResponseEntity.ok(playlist);
    }

    @Timed(
            value = "playlist.save-LayerArchitecture",
            description = "Tiempo de consulta para guardar una playlist en Layer Architecture optimizada",
            percentiles = {0.5, 0.95, 0.99}
    )
    @PostMapping("/save-optimized")
    public ResponseEntity<PlaylistWithInfoDTO> saveOptimizedPlaylist(@RequestBody PlaylistCreateRequestDTO requestDTO) {
        PlaylistWithInfoDTO playlist =  applicationService.optimizedSavePlaylistWithInfo(requestDTO);
        return ResponseEntity.ok(playlist);
    }
}
