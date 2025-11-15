package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.DTO.SongDTO;
import AndisUT2.ArtistAPI.Model.Song;
import AndisUT2.ArtistAPI.Service.Interface.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/all")
    public ResponseEntity<List<SongDTO>> getAllSongs() {
        List<SongDTO> songs = songService.getAllSongs();
        return songs.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(songs);
    }

    @GetMapping("/by-id")
    public ResponseEntity<SongDTO> getSongById(@RequestParam int id) {
        SongDTO song = songService.getSongById(id);
        return ResponseEntity.ok(song);
    }

    @GetMapping("/by-name")
    public ResponseEntity<SongDTO> getSongByName(@RequestParam String name) {
        SongDTO song = songService.getSongByName(name);
        return ResponseEntity.ok(song);
    }

    @GetMapping("/by-artist-id")
    public ResponseEntity <List<SongDTO>> getSongByArtistId(@RequestParam int artistId) {
        List<SongDTO> songs = songService.getSongsByArtistId(artistId);
        return songs.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(songs);
    }

    @GetMapping("/by-album-id")
    public ResponseEntity <List<SongDTO>> getSongByAlbumId(@RequestParam int albumId) {
        List<SongDTO> songs = songService.getSongsByAlbumId(albumId);
        return songs.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(songs);
    }

    @PostMapping("/save")
    public ResponseEntity<SongDTO> saveSong(@RequestParam String name, @RequestParam int artistId, @RequestParam int albumId) {
        SongDTO song =songService.saveSong(name,artistId,albumId);
        return ResponseEntity.ok(song);
    }

    @PatchMapping("/update-title")
    public ResponseEntity<SongDTO> updateSongTitle(@RequestParam String name, @RequestParam int songId) {
        SongDTO song = songService.updateSong(name, songId);
        return ResponseEntity.ok(song);
    }

}
