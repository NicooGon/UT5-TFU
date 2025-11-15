package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.DTO.AlbumDTO;
import AndisUT2.ArtistAPI.Model.Album;
import AndisUT2.ArtistAPI.Service.Interface.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    @GetMapping("/all")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums(){
        List<AlbumDTO> albums = albumService.getAllAlbums();
        return albums.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(albums);
    }

    @GetMapping("/by-name")
    public ResponseEntity<AlbumDTO> getAlbumByName(@RequestParam String name){
        AlbumDTO album = albumService.getAlbumByName(name);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/by-id")
    public ResponseEntity<AlbumDTO> getAlbumById(@RequestParam int id){
        AlbumDTO album = albumService.getAlbumById(id);
        return ResponseEntity.ok(album);
    }

    @GetMapping("/by-artist-id")
    public ResponseEntity<List<AlbumDTO>> getAlbumByArtistId(@RequestParam int id){
        List<AlbumDTO> albums = albumService.getAlbumsByArtistId(id);
        return albums.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(albums);
    }

    @PostMapping("/save")
    public ResponseEntity<AlbumDTO> saveAlbum(@RequestParam String albumName, @RequestParam String artistName){
        AlbumDTO album = albumService.saveAlbum(albumName, artistName);
        return ResponseEntity.ok(album);
    }

    @PatchMapping("/update-by-id")
    public ResponseEntity<AlbumDTO> updateAlbumById(@RequestParam int id, @RequestParam String newName){
        AlbumDTO album = albumService.updateAlbum(id, newName);
        return ResponseEntity.ok(album);
    }
}
