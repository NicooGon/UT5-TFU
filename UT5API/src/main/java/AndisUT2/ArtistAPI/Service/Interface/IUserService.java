package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.Model.User;

import java.util.List;

public interface IUserService {

    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
    public User saveUser(String name, String email, String username);
}
