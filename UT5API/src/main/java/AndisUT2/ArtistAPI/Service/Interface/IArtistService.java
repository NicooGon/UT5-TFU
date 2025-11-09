package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.Model.Artist;

import java.util.List;

public interface IArtistService {
    public Artist getArtistByName(String name);
    public Artist getArtistById(int id);
    public Artist saveArtist(String name);
    public Artist updateArtist(int artistId, String newName);
    public List<Artist> getAllArtists();
}
