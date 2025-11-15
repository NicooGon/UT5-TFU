package AndisUT2.ArtistAPI.Controller;

import AndisUT2.ArtistAPI.DTO.UserDTO;
import AndisUT2.ArtistAPI.Model.User;
import AndisUT2.ArtistAPI.Service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/ByUsername/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        UserDTO user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam String username) {
        UserDTO user = userService.saveUser(name, email, username);
        return ResponseEntity.ok(user);
    }
}
