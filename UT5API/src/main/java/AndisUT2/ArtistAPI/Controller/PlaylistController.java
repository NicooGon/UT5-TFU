package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.Model.Playlist;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistService;
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
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        return playlists.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(playlists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable int id) {
        Playlist playlist = playlistService.getPlaylistById(id);
        return ResponseEntity.ok(playlist);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByUserId(@PathVariable int userId) {
        List<Playlist> playlists = playlistService.getPlaylistsByUserId(userId);
        return playlists.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(playlists);
    }

    @PostMapping("/save")
    public ResponseEntity<Playlist> savePlaylist(@RequestParam String name, @RequestParam int userId) {
        Playlist playlist = playlistService.savePlaylist(name, userId);
        return ResponseEntity.ok(playlist);
    }
}
