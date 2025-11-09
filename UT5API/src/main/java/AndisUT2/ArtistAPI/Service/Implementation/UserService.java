package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Model.User;
import AndisUT2.ArtistAPI.Repository.UserRepository;
import AndisUT2.ArtistAPI.Service.Interface.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    @Override
    public User saveUser(String name, String email, String username ) {
        User user = new User(name, email, username);
        return userRepository.save(user);
    }
}
