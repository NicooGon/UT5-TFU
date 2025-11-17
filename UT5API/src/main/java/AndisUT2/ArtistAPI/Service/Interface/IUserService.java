package AndisUT2.ArtistAPI.Service.Interface;

import AndisUT2.ArtistAPI.DTO.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(int id);
    UserDTO getUserByUsername(String username);
    UserDTO saveUser(String name, String email, String username);
}
