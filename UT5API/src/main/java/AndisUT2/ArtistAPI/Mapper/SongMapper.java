package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.SongDTO;
import AndisUT2.ArtistAPI.Model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    @Mapping(source = "songId", target = "songId")
    @Mapping(source = "songName", target = "songName")
    @Mapping(source = "artistId", target = "artistId")
    @Mapping(source = "albumId", target = "albumId")
    SongDTO songToSongDTO(Song song);

    @Mapping(source = "songId", target = "songId")
    @Mapping(source = "songName", target = "songName")
    @Mapping(source = "artistId", target = "artistId")
    @Mapping(source = "albumId", target = "albumId")
    Song songDTOtoSong(SongDTO songDTO);
}
