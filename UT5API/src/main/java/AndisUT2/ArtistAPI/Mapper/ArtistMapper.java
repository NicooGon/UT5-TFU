package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.ArtistDTO;
import AndisUT2.ArtistAPI.Model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    @Mapping(source = "artistId", target = "artistId")
    @Mapping(source = "name", target = "name")
    ArtistDTO artistToArtistDTO(Artist artist);

    @Mapping(source = "artistId", target = "artistId")
    @Mapping(source = "name", target = "name")
    Artist artistDTOtoArtist(ArtistDTO artistDTO);
}
