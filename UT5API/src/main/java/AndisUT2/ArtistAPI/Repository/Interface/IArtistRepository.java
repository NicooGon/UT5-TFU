package AndisUT2.ArtistAPI.Repository.Interface;

import AndisUT2.ArtistAPI.Model.Artist;

import java.util.List;

public interface IArtistRepository {
    Artist getArtistByName(String name);
    Artist getArtistById(int id);
    List<Artist> getAllArtists();
    Artist saveArtist(Artist artist);
    Artist updateArtist(Artist artist);
}
