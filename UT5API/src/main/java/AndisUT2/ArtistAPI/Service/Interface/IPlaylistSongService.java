package AndisUT2.ArtistAPI.Service.Interface;

import java.util.List;

public interface IPlaylistSongService {

    void addSongToPlaylist(int playlistId, int songId);
    List<Integer> getSongsByPlaylistId(int playlistId);
    List<Integer> getPlaylistsBySongId(int songId);
    void addSongsToPlaylist(int playlistId, List<Integer> songIds);
}
