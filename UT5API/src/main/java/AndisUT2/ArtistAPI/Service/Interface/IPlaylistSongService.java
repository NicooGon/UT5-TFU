package AndisUT2.ArtistAPI.Service.Interface;

import java.util.List;

public interface IPlaylistSongService {

    public void addSongToPlaylist(int playlistId, int songId);
    public List<Integer> getSongsByPlaylistId(int playlistId);
    public List<Integer> getPlaylistsBySongId(int songId);
}
