package web.controlller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import web.hiber.model.User;
import web.hiber.service.UserService;
import web.hiber.service.UserServiceImpl;


import java.rmi.ServerException;
import java.util.List;

@RestController
@Component
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public HttpStatus save(@RequestBody User user) {
        userService.saveUser(user);
        return HttpStatus.OK;
    }

    @PostMapping("/update")
    public HttpStatus updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return HttpStatus.OK;
    }

    @GetMapping("/user/{lastname}")
    public User getUserByLastName(@PathVariable("lastname") String lastname) {
        return userService.getUserLastName(lastname);
    }

    @PostMapping("/userAge")
    public boolean setUserAge(@RequestParam(required = false) int age, Long id) {
        return userService.setUserAge(age, id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/remove")
    public HttpStatus remove(@RequestBody User user) {
        userService.removeUser(user);
        return HttpStatus.OK;
    }
}

