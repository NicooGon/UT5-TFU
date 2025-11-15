package AndisUT2.ArtistAPI.Repository.Implementation;

import AndisUT2.ArtistAPI.Repository.Interface.IPlaylistSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistSongRepository implements IPlaylistSongRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addSongToPlaylist(int playlistId, int songId) {
        String sql = "INSERT INTO playlist_song (playlist_id, song_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, playlistId, songId);
    }

    @Override
    public List<Integer> getSongsByPlaylistId(int playlistId) {
        String sql = "SELECT song_id FROM playlist_song WHERE playlist_id = ?";
        return jdbcTemplate.queryForList(sql, Integer.class, playlistId);
    }

    @Override
    public List<Integer> getPlaylistsBySongId(int songId) {
        String sql = "SELECT playlist_id FROM playlist_song WHERE song_id = ?";
        return jdbcTemplate.queryForList(sql, Integer.class, songId);
    }
}
