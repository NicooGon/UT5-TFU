package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.SongDTO;
import AndisUT2.ArtistAPI.Model.Song;

import java.util.List;

public interface ISongService {

    public SongDTO getSongById(int id);
    public SongDTO getSongByName(String name);
    public List<SongDTO> getAllSongs();
    public List<SongDTO> getSongsByArtistId(int artistId);
    public List<SongDTO> getSongsByAlbumId(int albumId);
    public SongDTO updateSong(String name, int songId);
    public SongDTO saveSong(String name, int artistId, int albumId);


}
