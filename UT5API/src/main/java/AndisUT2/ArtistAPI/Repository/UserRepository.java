package AndisUT2.ArtistAPI.Repository;

import AndisUT2.ArtistAPI.Model.Song;
import AndisUT2.ArtistAPI.Model.User;
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
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        return user;
    };

    public UserRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    public User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, userRowMapper, userId);
        }
        catch (EmptyResultDataAccessException e)
        {
            throw new RuntimeException("No se  encontro Usuario con Id: " + userId);
        }
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, userRowMapper, username);
        }
        catch (EmptyResultDataAccessException e)
        {
            throw new RuntimeException("No se  encontro Usuario con username: " + username);
        }
    }

    public User save(User user) {
        String sql = "INSERT INTO users (name, email, username) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            user.setUserId(key.intValue());
        } else {
            throw new RuntimeException("No se pudo obtener el ID generado del usuario");
        }

        return user;
    }
}








