package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.AlbumDTO;
import AndisUT2.ArtistAPI.Model.Album;

import java.util.List;

public interface IAlbumService {

    AlbumDTO getAlbumByName(String name);
    AlbumDTO getAlbumById(int id);
    List<AlbumDTO> getAllAlbums();
    List<AlbumDTO> getAlbumsByArtistId(int artistId);
    AlbumDTO saveAlbum(String name, String artistName);
    AlbumDTO updateAlbum(int albumId, String newName);
}
