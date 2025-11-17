package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.AlbumWithInfoDTO;
import AndisUT2.ArtistAPI.DTO.PlaylistCreateRequestDTO;
import AndisUT2.ArtistAPI.DTO.PlaylistWithInfoDTO;
import AndisUT2.ArtistAPI.DTO.SongWithInfoDTO;

public interface IApplicationService {

    SongWithInfoDTO getSongWithInfo(int songId);
    AlbumWithInfoDTO getAlbumWithInfo(int albumId);
    PlaylistWithInfoDTO getPlaylistWithInfo(int playlistId);
    PlaylistWithInfoDTO optimizedGetPlaylistWithInfo(int playlistId);
    PlaylistWithInfoDTO optimizedSavePlaylistWithInfo(PlaylistCreateRequestDTO requestDTO);
    PlaylistWithInfoDTO savePlaylistWithInfo(PlaylistCreateRequestDTO requestDTO);
}
