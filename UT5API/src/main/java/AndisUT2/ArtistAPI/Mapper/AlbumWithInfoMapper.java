package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumWithInfoMapper {

    @Mapping(source = "album.albumId",   target = "albumId")
    @Mapping(source = "album.albumName", target = "albumName")
    @Mapping(source = "artist.artistId", target = "artistId")
    @Mapping(source = "artist.name",     target = "artistName")
    @Mapping(source = "songs",           target = "songNames")
    AlbumWithInfoDTO toAlbumWithInfoDTO(
            AlbumDTO album,
            ArtistDTO artist,
            List<SongDTO> songs
    );

    @Mapping(source = "songId",   target = "songId")
    @Mapping(source = "songName", target = "songName")
    SongInAlbumDTO toSongInAlbumDTO(SongDTO song);
}