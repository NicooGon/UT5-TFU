package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.AlbumDTO;
import AndisUT2.ArtistAPI.Model.Album;

import java.util.List;

public interface IAlbumService {

    public AlbumDTO getAlbumByName(String name);
    public AlbumDTO getAlbumById(int id);
    public List<AlbumDTO> getAllAlbums();
    public List<AlbumDTO> getAlbumsByArtistId(int artistId);
    public AlbumDTO saveAlbum(String name, String artistName);
    public AlbumDTO updateAlbum(int albumId, String newName);
}
