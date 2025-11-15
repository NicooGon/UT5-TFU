package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.DTO.AlbumDTO;
import AndisUT2.ArtistAPI.DTO.ArtistDTO;
import AndisUT2.ArtistAPI.DTO.SongDTO;
import AndisUT2.ArtistAPI.Mapper.SongMapper;
import AndisUT2.ArtistAPI.Model.Song;
import AndisUT2.ArtistAPI.Repository.Interface.ISongRepository;
import AndisUT2.ArtistAPI.Service.Interface.IAlbumService;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import AndisUT2.ArtistAPI.Service.Interface.ISongService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SongService implements ISongService {

    private ISongRepository songRepository;
    private IArtistService artistService;
    private IAlbumService albumService;
    private static final SongMapper songMapper = SongMapper.INSTANCE;

    public SongService(ISongRepository songRepository, IArtistService artistService, IAlbumService albumService) {
        this.songRepository = songRepository;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @Override
    public SongDTO getSongById(int id) {
        Song song = songRepository.getSongByID(id);

        if(song == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Canción no encontrado con ID: " + id);
        }
        return songMapper.songToSongDTO(song);
    }

    @Override
    public SongDTO getSongByName(String name) {
        Song song = songRepository.getSongByName(name);

        if(song == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Canción no encontrado con nombre: " + name);
        }
        return songMapper.songToSongDTO(song);
    }

    @Override
    public List<SongDTO> getAllSongs() {
        return songRepository.getAllSongs()
                .stream()
                .map(songMapper::songToSongDTO).toList();
    }

    @Override
    public List<SongDTO> getSongsByArtistId(int artistId) {
        return songRepository.getSongsByArtistID(artistId)
                .stream()
                .map(songMapper::songToSongDTO).toList();
    }

    @Override
    public List<SongDTO> getSongsByAlbumId(int albumId) {
        return songRepository.getSongsByAlbumID(albumId)
                .stream()
                .map(songMapper::songToSongDTO).toList();
    }

    @Override
    public SongDTO saveSong(String name, int artistId, int albumId) {
        ArtistDTO artist = artistService.getArtistById(artistId);
        if (artist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista no encontrado con ID: " + artistId);
        }

        AlbumDTO album = albumService.getAlbumById(albumId);
        if (album == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Álbum no encontrado con ID: " + albumId);
        }

        Song song = new Song(name, artistId, albumId);
        songRepository.saveSong(song);

        return songMapper.songToSongDTO(song);
    }

    @Override
    public SongDTO updateSong(String name, int songID) {
        Song song = songRepository.getSongByID(songID);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Canción no encontrada con ID: " + songID);
        }

        song.setSongName(name);
        songRepository.updateSong(song);

        return songMapper.songToSongDTO(song);
    }
}
