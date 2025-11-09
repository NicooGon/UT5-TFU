package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Model.Album;
import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Model.Song;
import AndisUT2.ArtistAPI.Repository.SongRepository;
import AndisUT2.ArtistAPI.Service.Interface.IAlbumService;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import AndisUT2.ArtistAPI.Service.Interface.ISongService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SongService implements ISongService {


    private SongRepository songRepository;
    private IArtistService artistService;
    private IAlbumService albumService;

    public SongService(SongRepository songRepository, IArtistService artistService, IAlbumService albumService) {
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
        Artist artist = artistService.getArtistById(artistId);
        if (artist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista no encontrado con ID: " + artistId);
        }

        Album album = albumService.getAlbumById(albumId);
        if (album == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum no encontrado con ID: " + albumId);
        }

        Song song = new Song(name, artistId, albumId);
        songRepository.saveSong(song);

        return song;
    }

    @Override
    public Song updateSong(String name, int songID) {
        Song song = songRepository.getSongByID(songID);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Canción no encontrada con ID: " + songID);
        }

        song.setSongName(name);
        songRepository.updateSong(song);

        return song;
    }
}
