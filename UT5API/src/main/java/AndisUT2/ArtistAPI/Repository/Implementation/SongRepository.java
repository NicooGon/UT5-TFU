package AndisUT2.ArtistAPI.Repository.Implementation;

import AndisUT2.ArtistAPI.Model.Song;
import AndisUT2.ArtistAPI.Repository.Interface.ISongRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {

    private final JdbcTemplate jdbcTemplate;

    public SongRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    private  static final RowMapper<Song> songMapper = (rs, rowNum) -> {
        Song song = new Song();
        song.setSongId(rs.getInt("song_id"));
        song.setSongName(rs.getString("song_name"));
        song.setArtistId(rs.getInt("artist_id"));
        song.setAlbumId(rs.getInt("album_id"));
        return song;
    };

    @Override
    public Song getSongByID(int songId) {
        String sql = "select * from song where song_id=?";
        return jdbcTemplate.queryForObject(sql, songMapper, songId);
    };

    @Override
    public Song getSongByName(String songName) {
        String sql = "select * from song where song_name=?";
        return jdbcTemplate.queryForObject(sql, songMapper, songName);
    }

    @Override
    public List<Song> getAllSongs() {
        String sql = "select * from song";
        return jdbcTemplate.query(sql, songMapper);
    }

    @Override
    public List<Song> getSongsByArtistID(int artistID) {
        String sql = "select * from song where artist_id=?";
        return jdbcTemplate.query(sql, songMapper, artistID);
    }

    @Override
    public List<Song> getSongsByAlbumID(int albumID) {
        String sql = "select * from song where album_id=?";
        return jdbcTemplate.query(sql, songMapper, albumID);
    }

    @Override
    public Song saveSong(Song song) {
        String sql = "INSERT INTO song (song_name, artist_id, album_id) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, song.getSongName());
            ps.setInt(2, song.getArtistId());
            ps.setInt(3, song.getAlbumId());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            song.setSongId(key.intValue());
        } else {
            throw new RuntimeException("No se pudo obtener el ID generado de la canción");
        }

        return song;
    }

    @Override
    public Song updateSong(Song song) {
        String sql = "UPDATE song SET song_name = ?, artist_id = ?, album_id = ? WHERE song_id=?";
        int rows = jdbcTemplate.update(sql, song.getSongName(), song.getArtistId(), song.getAlbumId(), song.getSongId());

        if (rows > 0) {
            return getSongByID(song.getSongId());
        }
        else {
            throw new RuntimeException("No se pudo actualizar la canción con ID " + song.getSongId());
        }
    }
}

