package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.AlbumDTO;
import AndisUT2.ArtistAPI.Model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);

    @Mapping(source = "albumId", target = "albumId")
    @Mapping(source = "albumName", target = "albumName")
    @Mapping(source = "artistId", target = "artistId")
    AlbumDTO albumToAlbumDTO(Album album);

    @Mapping(source = "albumId", target = "albumId")
    @Mapping(source = "albumName", target = "albumName")
    @Mapping(source = "artistId", target = "artistId")
    Album albumDTOtoAlbum(AlbumDTO albumDTO);
}
