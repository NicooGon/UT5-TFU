package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.DTO.UserDTO;
import AndisUT2.ArtistAPI.Mapper.UserMapper;
import AndisUT2.ArtistAPI.Model.User;
import AndisUT2.ArtistAPI.Repository.Interface.IUserRepository;
import AndisUT2.ArtistAPI.Service.Interface.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private static final UserMapper userMapper = UserMapper.INSTANCE;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers(){
        return userRepository.getAllUsers()
                .stream()
                .map(userMapper::userToUserDTO).toList();
    }

    @Override
    public UserDTO getUserById(int id){
        User user = userRepository.getUserById(id);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username){
        User user = userRepository.getUserByUsername(username);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO saveUser(String name, String email, String username ) {
        User user = new User(name, email, username);
        userRepository.save(user);
        return userMapper.userToUserDTO(user);
    }
}

