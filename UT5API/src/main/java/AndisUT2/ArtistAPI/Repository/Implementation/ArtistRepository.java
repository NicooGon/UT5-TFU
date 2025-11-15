package AndisUT2.ArtistAPI.Repository.Implementation;

import AndisUT2.ArtistAPI.Model.Artist;
import AndisUT2.ArtistAPI.Repository.Interface.IArtistRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ArtistRepository implements IArtistRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Artist> artistRowMapper = (rs, rowNum) -> {
        Artist artist = new Artist();
        artist.setArtistId(rs.getInt("artist_id"));
        artist.setName(rs.getString("name"));
        return artist;
    };

    public ArtistRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Artist getArtistByName(String name) {
        String sql = "select * from artist where name = ?";
        return jdbcTemplate.queryForObject(sql, artistRowMapper, name);
    }

    @Override
    public Artist getArtistById(int artistID) {
        String sql = "select * from artist where artist_id = ?";
        return jdbcTemplate.queryForObject(sql, artistRowMapper, artistID);
    }

    @Override
    public List<Artist> getAllArtists() {
        String sql = "select * from artist";
        return jdbcTemplate.query(sql, artistRowMapper);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        String sql = "INSERT INTO artist (name) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, artist.getName());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            artist.setArtistId(key.intValue());
        } else {
            throw new RuntimeException("No se pudo obtener el ID generado del artista");
        }

        return artist;
    }

    @Override
    public Artist updateArtist(Artist artist) {
        String sql = "UPDATE artist SET name = ? WHERE artist_id = ?";
        int rows = jdbcTemplate.update(sql, artist.getName(), artist.getArtistId());

        if (rows > 0) {
            return getArtistById(artist.getArtistId());
        } else {
            throw new RuntimeException("No se pudo actualizar el artista con ID " + artist.getArtistId());
        }
    }
}