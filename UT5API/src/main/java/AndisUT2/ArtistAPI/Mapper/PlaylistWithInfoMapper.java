package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.*;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaylistWithInfoMapper {

    @Mapping(source = "playlist.playlistId",   target = "playlistId")
    @Mapping(source = "playlist.name", target = "playlistName")
    @Mapping(source = "user.userId",           target = "userId")
    @Mapping(source = "user.username",         target = "username")
    @Mapping(source = "songs",                 target = "songs")
    PlaylistWithInfoDTO toPlaylistWithInfoDTO(
            PlaylistDTO playlist,
            UserDTO user,
            List<SongWithInfoDTO> songs
    );
}
