package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.DTO.PlaylistDTO;
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
    public ResponseEntity<PlaylistDTO> getPlaylistById(@PathVariable int id) {
        PlaylistDTO playlist = playlistService.getPlaylistById(id);
        return ResponseEntity.ok(playlist);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaylistDTO>> getPlaylistsByUserId(@PathVariable int userId) {
        List<PlaylistDTO> playlists = playlistService.getPlaylistsByUserId(userId);
        return playlists.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(playlists);
    }

    @PostMapping("/save")
    public ResponseEntity<PlaylistDTO> savePlaylist(@RequestParam String name, @RequestParam int userId) {
        PlaylistDTO playlist = playlistService.savePlaylist(name, userId);
        return ResponseEntity.ok(playlist);
    }
}
