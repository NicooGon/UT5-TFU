package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.Model.Song;

import java.util.List;

public interface ISongService {

    public Song getSongById(int id);
    public Song getSongByName(String name);
    public List<Song> getAllSongs();
    public List<Song> getSongsByArtistId(int artistId);
    public List<Song> getSongsByAlbumId(int albumId);
    public Song updateSong(String name, int songId);
    public Song saveSong(String name, int artistId, int albumId);


}
