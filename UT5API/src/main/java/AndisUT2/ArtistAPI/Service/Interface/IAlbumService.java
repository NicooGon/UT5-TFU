package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.Model.Album;

import java.util.List;

public interface IAlbumService {

    public Album getAlbumByName(String name);
    public Album getAlbumById(int id);
    public List<Album> getAllAlbums();
    public List<Album> getAlbumsByArtistId(int artistId);
    public Album saveAlbum(String name, String artistName);
    public Album updateAlbum(int albumId, String newName);

}
