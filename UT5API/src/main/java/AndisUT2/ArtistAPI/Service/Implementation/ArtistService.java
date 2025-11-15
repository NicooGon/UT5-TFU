package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.DTO.ArtistDTO;
import AndisUT2.ArtistAPI.Mapper.ArtistMapper;
import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Repository.Interface.IArtistRepository;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArtistService implements IArtistService {

    private final IArtistRepository artistRepository;
    private static final ArtistMapper artistMapper = ArtistMapper.INSTANCE;

    public ArtistService(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public ArtistDTO getArtistByName(String name){
        Artist artist = artistRepository.getArtistByName(name);

        if (artist == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Artista no encontrado con nombre: " + name
            );
        }

        return artistMapper.artistToArtistDTO(artist);
    }

    @Override
    public List<ArtistDTO> getAllArtists(){
        return artistRepository.getAllArtists()
                .stream()
                .map(artistMapper::artistToArtistDTO).toList();
    }

    @Override
    public ArtistDTO getArtistById(int id){
        Artist artist = artistRepository.getArtistById(id);

        if (artist == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Artista no encontrado con ID: " + id
            );
        }

        return artistMapper.artistToArtistDTO(artist);
    }

    @Override
    public ArtistDTO saveArtist(String name){
        Artist artist = new Artist(name);
        artistRepository.saveArtist(artist);

        return artistMapper.artistToArtistDTO(artist);
    }

    @Override
    public ArtistDTO updateArtist(int artistId, String newName){
        Artist artist = artistRepository.getArtistById(artistId);

        if (artist == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Artista no encontrado con ID: " + artistId
            );
        }

        artist.setName(newName);
        artistRepository.updateArtist(artist);

        return artistMapper.artistToArtistDTO(artist);
    }
}

