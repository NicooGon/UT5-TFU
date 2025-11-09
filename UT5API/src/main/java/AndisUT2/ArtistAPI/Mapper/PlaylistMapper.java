package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.PlaylistDTO;
import AndisUT2.ArtistAPI.Model.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaylistMapper {

    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    @Mapping(source = "playlistId", target = "playlistId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "userId", target = "userId")
    PlaylistDTO playlistToPlaylistDTO(Playlist playlist);

    @Mapping(source = "playlistId", target = "playlistId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "userId", target = "userId")
    Playlist playlistDTOtoPlaylist(PlaylistDTO playlistDTO);
}
