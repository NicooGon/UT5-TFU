package AndisUT2.ArtistAPI.Repository.Interface;

import AndisUT2.ArtistAPI.Model.Album;

import java.util.List;

public interface IAlbumRepository {
    Album getAlbumByName(String name);
    Album getAlbumById(int id);
    List<Album> getAllAlbums();
    List<Album> getAlbumsByArtistId(int artistId);
    Album saveAlbum(Album album);
    Album updateAlbum(Album album);
}
