package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.Service.Interface.IPlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist-songs")
public class PlaylistSongController {

    @Autowired
    private IPlaylistSongService playlistSongService;


    @PostMapping("/add")
    public ResponseEntity<String> addSongToPlaylist(@RequestParam int playlistId, @RequestParam int songId) {
        try {
            playlistSongService.addSongToPlaylist(playlistId, songId);
            return ResponseEntity.ok("Canción agregada correctamente a la lista de reproducción.");
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Error al agregar la canción: " + e.getMessage());
        }
    }

    @GetMapping("/playlist/{playlistId}")
    public ResponseEntity<List<Integer>> getSongsByPlaylistId(@PathVariable int playlistId) {
        List<Integer> songIds = playlistSongService.getSongsByPlaylistId(playlistId);
        return songIds.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(songIds);
    }

    @GetMapping("/song/{songId}")
    public ResponseEntity<List<Integer>> getPlaylistsBySongId(@PathVariable int songId) {
        List<Integer> playlistIds = playlistSongService.getPlaylistsBySongId(songId);
        return playlistIds.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(playlistIds);
    }
}
