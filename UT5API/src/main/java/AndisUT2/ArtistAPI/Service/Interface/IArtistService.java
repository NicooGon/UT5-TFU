package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.ArtistDTO;
import AndisUT2.ArtistAPI.Model.Artist;

import java.util.List;

public interface IArtistService {
    public ArtistDTO getArtistByName(String name);
    public ArtistDTO getArtistById(int id);
    public ArtistDTO saveArtist(String name);
    public ArtistDTO updateArtist(int artistId, String newName);
    public List<ArtistDTO> getAllArtists();
}
