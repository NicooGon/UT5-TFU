package AndisUT2.ArtistAPI.Controller;

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
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(users);
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/ByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam String username) {
        User user = userService.saveUser(name, email, username);
        return ResponseEntity.ok(user);
    }
}
