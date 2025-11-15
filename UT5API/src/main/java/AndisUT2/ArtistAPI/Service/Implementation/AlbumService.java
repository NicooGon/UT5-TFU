package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.DTO.AlbumDTO;
import AndisUT2.ArtistAPI.Mapper.AlbumMapper;
import AndisUT2.ArtistAPI.Model.Album;
import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Repository.AlbumRepository;
import AndisUT2.ArtistAPI.Service.Interface.IAlbumService;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlbumService implements IAlbumService {

    private final AlbumRepository albumRepository;
    private final IArtistService artistService;

    private static final AlbumMapper albumMapper = AlbumMapper.INSTANCE;

    public AlbumService(AlbumRepository albumRepository, IArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    @Override
    public AlbumDTO getAlbumByName(String name){
        Album album = albumRepository.getAlbumByName(name);

        if (album == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontró Album con nombre: " + name);
        }
        return albumMapper.albumToAlbumDTO(album);
    }

    @Override
    public AlbumDTO getAlbumById(int id){
        Album album = albumRepository.getAlbumById(id);

        if (album == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontró Album con id: " + id);
        }
        return albumMapper.albumToAlbumDTO(album);
    }

    @Override
    public List<AlbumDTO> getAllAlbums(){
        return albumRepository.getAllAlbums()
                .stream()
                .map(albumMapper::albumToAlbumDTO).toList();
    }

    @Override
    public List<AlbumDTO> getAlbumsByArtistId(int artistId){
        List<Album> albums = albumRepository.getAlbumsByArtistId(artistId);

        if (albums.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No hay álbumes para el artista con id: " + artistId);
        }

        return albums.stream()
                .map(albumMapper::albumToAlbumDTO).toList();
    }

    @Override
    public AlbumDTO saveAlbum(String name, String artistName){
        Artist artist = artistService.getArtistByName(artistName);

        Album album = new Album(name, artist.getArtistId());
        albumRepository.saveAlbum(album);

        return albumMapper.albumToAlbumDTO(album);
    }

    @Override
    public AlbumDTO updateAlbum(int albumId, String newName){
        Album album = albumRepository.getAlbumById(albumId);

        if (album == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Album con ID " + albumId + " no encontrado para actualizar.");
        }

        album.setAlbumName(newName);
        albumRepository.updateAlbum(album);

        return albumMapper.albumToAlbumDTO(album);
    }
}

