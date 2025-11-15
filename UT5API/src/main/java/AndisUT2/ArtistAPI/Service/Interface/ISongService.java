package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.SongDTO;
import AndisUT2.ArtistAPI.Model.Song;

import java.util.List;

public interface ISongService {

    SongDTO getSongById(int id);
    SongDTO getSongByName(String name);
    List<SongDTO> getAllSongs();
    List<SongDTO> getSongsByArtistId(int artistId);
    List<SongDTO> getSongsByAlbumId(int albumId);
    SongDTO updateSong(String name, int songId);
    SongDTO saveSong(String name, int artistId, int albumId);


}
