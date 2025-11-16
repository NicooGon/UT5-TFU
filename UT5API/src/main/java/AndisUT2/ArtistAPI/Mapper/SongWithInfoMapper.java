package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SongWithInfoMapper {

    @Mapping(source = "song.songId",     target = "songId")
    @Mapping(source = "song.songName",   target = "songName")
    @Mapping(source = "song.artistId",   target = "artistId")
    @Mapping(source = "artist.name",     target = "artistName")
    @Mapping(source = "song.albumId",    target = "albumId")
    @Mapping(source = "album.albumName", target = "albumName")

    SongWithInfoDTO toSongWithInfoDTO(
            SongDTO song,
            ArtistDTO artist,
            AlbumDTO album
    );
}