package AndisUT2.ArtistAPI.Repository.Interface;

import AndisUT2.ArtistAPI.Model.Song;

import java.util.List;

public interface ISongRepository {
    Song getSongByID(int songId);
    Song getSongByName(String songName);
    List<Song> getAllSongs();
    List<Song> getSongsByArtistID(int artistID);
    List<Song> getSongsByAlbumID(int albumID);
    Song saveSong(Song song);
    Song updateSong(Song song);
}
