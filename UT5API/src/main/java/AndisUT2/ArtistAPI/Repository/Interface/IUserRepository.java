package AndisUT2.ArtistAPI.Repository.Interface;

import AndisUT2.ArtistAPI.Model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUsers();
    User getUserById(int userId);
    User getUserByUsername(String username);
    User save(User user);
}
