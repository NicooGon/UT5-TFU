package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Model.Album;
import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Repository.AlbumRepository;
import AndisUT2.ArtistAPI.Service.Interface.IAlbumService;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlbumService implements IAlbumService {

    private final AlbumRepository albumRepository;

    private final IArtistService artistService;

    public AlbumService(AlbumRepository albumRepository, IArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    @Override
    public Album getAlbumByName(String name){
        Album album = albumRepository.getAlbumByName(name);
        if(album == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontro Album con nombre: " + name);
        }
        return album;
    }

    @Override
    public Album getAlbumById(int id){
        Album album = albumRepository.getAlbumById(id);

        if(album == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No se encontro Album con id: " + id);
        }
        return album;
    }

    @Override
    public List<Album> getAllAlbums(){
        return albumRepository.getAllAlbums();
    }

    @Override
    public List<Album> getAlbumsByArtistId(int artistId){
        return albumRepository.getAlbumsByArtistId(artistId);
    }

    @Override
    public Album saveAlbum(String name, String artistName){
        Artist artist = artistService.getArtistByName(artistName);

        Album album = new Album(name, artist.getArtistId());
        albumRepository.saveAlbum(album);
        return album;
    }

    @Override
    public Album updateAlbum(int albumId, String newName){
        Album album = albumRepository.getAlbumById(albumId);
        if (album == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Album con ID " + albumId + " no encontrado para actualizar.");
        }
        album.setAlbumName(newName);
        albumRepository.updateAlbum(album);

        return album;
    }

}
