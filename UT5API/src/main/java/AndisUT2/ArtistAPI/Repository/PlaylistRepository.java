package AndisUT2.ArtistAPI.Repository;

import AndisUT2.ArtistAPI.Model.Playlist;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PlaylistRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Playlist> playlistRowMapper = (rs, rowNum) -> {
        Playlist playlist = new Playlist();
        playlist.setPlaylistID(rs.getInt("playlist_id"));
        playlist.setName(rs.getString("name"));
        playlist.setUserID(rs.getInt("user_id"));
        return playlist;
    };

    public PlaylistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Playlist> getAllPlaylists() {
        String sql = "SELECT * FROM playlist";
        return jdbcTemplate.query(sql, playlistRowMapper);
    }

    public Playlist getPlaylistById(int playlistID) {
        String sql = "SELECT * FROM playlist WHERE playlist_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, playlistRowMapper, playlistID);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("No se encontró Playlist con Id: " + playlistID);
        }
    }

    public List<Playlist> getPlaylistsByUserId(int userId) {
        String sql = "SELECT * FROM playlist WHERE user_id = ?";
        List<Playlist> playlists = jdbcTemplate.query(sql, playlistRowMapper, userId);

        if (playlists.isEmpty()) {
            throw new RuntimeException("No tiene ninguna playlist este usuario");
        }
        return playlists;
    }

    public Playlist save(Playlist playlist) {
        String sql = "INSERT INTO playlist (name, user_id) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, playlist.getName());
            ps.setInt(2, playlist.getUserID());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            playlist.setPlaylistID(key.intValue());
        } else {
            throw new RuntimeException("No se pudo obtener el ID generado de la playlist");
        }

        return playlist;
    }
}
