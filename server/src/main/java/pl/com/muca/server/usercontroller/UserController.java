package pl.com.muca.server.usercontroller;

import java.util.List;
import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.muca.server.entity.User;
import pl.com.muca.server.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/pollApp")
public class UserController {

  @Resource UserService userService;

  @GetMapping(value = "/listUsers")
  public List<User> getUsers() {
    logAction();
    return userService.findAll();
  }

  @PostMapping(value = "/registerUser")
  public void registerUser(@RequestBody User user) {
    logAction(user.toString());
    userService.insertUser(user);
  }

  @PutMapping(value = "/updateUser")
  public void updateUser(@RequestBody User user) {
    logAction(user.toString());
    userService.updateUser(user);
  }

  @PutMapping(value = "/executeUpdateUser")
  public void executeUpdateUser(@RequestBody User user) {
    logAction(user.toString());
    userService.executeUpdateUser(user);
  }

  @DeleteMapping(value = "/deleteUser")
  public void deleteUser(@RequestBody User user) {
    logAction(user.toString());
    userService.deleteUser(user);
  }

  @PostMapping(value = "/login")
  public User login(@RequestBody User user) throws LoginException {
    logAction(user.toString());
    return userService.login(user);
  }

  // TODO (Damian Muca): 5/18/20 log4j to log all action invoked on REST API.
  private void logAction() {
    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
    logAction("", methodName);
  }

  private void logAction(String info) {
    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
    logAction(info, methodName);
  }

  private void logAction(String info, String methodName) {
    System.out.printf("%s %s\n", methodName, info);
  }
}
