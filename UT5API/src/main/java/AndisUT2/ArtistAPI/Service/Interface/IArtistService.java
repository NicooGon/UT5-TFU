package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.ArtistDTO;
import AndisUT2.ArtistAPI.Model.Artist;

import java.util.List;

public interface IArtistService {
    ArtistDTO getArtistByName(String name);
    ArtistDTO getArtistById(int id);
    ArtistDTO saveArtist(String name);
    ArtistDTO updateArtist(int artistId, String newName);
    List<ArtistDTO> getAllArtists();
}
