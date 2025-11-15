package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.UserDTO;
import AndisUT2.ArtistAPI.Model.User;

import java.util.List;

public interface IUserService {

    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(int id);
    public UserDTO getUserByUsername(String username);
    public UserDTO saveUser(String name, String email, String username);
}
