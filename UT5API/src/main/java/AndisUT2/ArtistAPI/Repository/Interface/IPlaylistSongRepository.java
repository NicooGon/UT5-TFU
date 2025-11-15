package AndisUT2.ArtistAPI.Repository.Interface;

import java.util.List;

public interface IPlaylistSongRepository {
    void addSongToPlaylist(int playlistId, int songId);
    List<Integer> getSongsByPlaylistId(int playlistId);
    List<Integer> getPlaylistsBySongId(int songId);
}
