package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.PlaylistSongDTO;
import AndisUT2.ArtistAPI.Model.PlaylistSong;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaylistSongMapper {

    PlaylistSongMapper INSTANCE = Mappers.getMapper(PlaylistSongMapper.class);

    @Mapping(source = "playlistId", target = "playlistId")
    @Mapping(source = "songId", target = "songId")
    PlaylistSongDTO playlistToPlaylistDTO(PlaylistSong playlistSong);

    @Mapping(source = "playlistId", target = "playlistId")
    @Mapping(source = "songId", target = "songId")
    PlaylistSong playlistSongDTOtoPlaylistSong(PlaylistSongDTO playlistSongDTO);
}
