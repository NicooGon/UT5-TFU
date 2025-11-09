package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Model.Album;
import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Model.Song;
import AndisUT2.ArtistAPI.Repository.SongRepository;
import AndisUT2.ArtistAPI.Service.Interface.ISongService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SongService implements ISongService {


    private SongRepository songRepository;
    private ArtistService artistService;
    private AlbumService albumService;

    public SongService(SongRepository songRepository, ArtistService artistService, AlbumService albumService) {
        this.songRepository = songRepository;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @Override
    public Song getSongById(int id) {
        Song song = songRepository.getSongByID(id);

        if(song == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Canción no encontrado con ID: " + id);
        }
        return song;
    }

    @Override
    public Song getSongByName(String name) {
        Song song = songRepository.getSongByName(name);

        if(song == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Canción no encontrado con nombre: " + name);
        }
        return song;
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @Override
    public List<Song> getSongsByArtistId(int artistId) {
        return songRepository.getSongsByArtistID(artistId);
    }

    @Override
    public List<Song> getSongsByAlbumId(int albumId) {
        return songRepository.getSongsByAlbumID(albumId);
    }

    @Override
    public Song saveSong(String name, int artistId, int albumId) {
        Artist artist;
        Album album;

        try {
            artist = artistService.getArtistById(artistId);
            album = albumService.getAlbumById(albumId);
        } catch (RuntimeException e) {
            throw new RuntimeException("No se puede crear la canción: " + e.getMessage());
        }

        Song song = new Song(name, artistId, albumId);
        songRepository.saveSong(song);

        return song;
    }

    @Override
    public Song updateSong(String name, int songID) {
        Song song;

        try {
            song = getSongById(songID);
        } catch (RuntimeException e) {
            throw new RuntimeException("No se puede actualizar  la canción: " + e.getMessage());
        }

        song.setSongName(name);
        songRepository.updateSong(song);

        return song;
    }
}
