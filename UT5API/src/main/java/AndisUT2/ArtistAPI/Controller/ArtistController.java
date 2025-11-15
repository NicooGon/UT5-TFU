package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.DTO.ArtistDTO;
import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @GetMapping("/all")
    public ResponseEntity<List<ArtistDTO>> getAllArtists() {
        List<ArtistDTO> artists = artistService.getAllArtists();
        return artists.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(artists);
    }

    @GetMapping("/by-name")
    public ResponseEntity<ArtistDTO> getArtistByName(@RequestParam String name) {
        ArtistDTO artist = artistService.getArtistByName(name);
        return ResponseEntity.ok(artist);
    }

    @GetMapping("/by-id")
    public ResponseEntity<ArtistDTO> getArtistByid(@RequestParam int id) {
        ArtistDTO artist = artistService.getArtistById(id);
        return ResponseEntity.ok(artist);
    }

    @PostMapping("/save")
    public ResponseEntity<ArtistDTO> saveArtist(@RequestParam String name) {
        ArtistDTO artist = artistService.saveArtist(name);
        return ResponseEntity.ok(artist);
    }

    @PatchMapping("/update-by-id")
    public ResponseEntity<ArtistDTO> updateArtist(@RequestParam int id, @RequestParam String newName) {
        ArtistDTO artist = artistService.updateArtist(id, newName);
        return ResponseEntity.ok(artist);
    }
}
