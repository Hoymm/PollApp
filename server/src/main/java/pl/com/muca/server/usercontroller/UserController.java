package pl.com.muca.server.usercontroller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pollApp")
public class UserController {

  @Resource
  UserService userService;

  // TODO (Damian Muca): 5/30/20 change API endpoint name to listUsers.
  @GetMapping(value = "/usersList")
  public List<User> getUsers() {
    logAction();
    return userService.findAll();
  }

  // TODO (Damian Muca): 5/30/20 change API endpoint name to registerUser.
  @PostMapping(value = "/createUser")
  public void createUser(@RequestBody User user) {
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
  public boolean login(@RequestBody User user) {
    logAction(user.toString());
    return userService.login(user);
  }

  @GetMapping(value = "/user")
  public Principal user(HttpServletRequest request) {
    logAction(request.toString());
    String authToken = request.getHeader("Authorization")
        .substring("Basic".length()).trim();
    return () -> new String(Base64.getDecoder()
        .decode(authToken)).split(":")[0];
  }

  // TODO (Damian Muca): 5/18/20 log4j to log all action invoked on REST API.
  private void logAction() {
    String methodName = Thread.currentThread().getStackTrace()[2]
        .getMethodName();
    logAction("", methodName);
  }

  private void logAction(String info) {
    String methodName = Thread.currentThread().getStackTrace()[2]
        .getMethodName();
    logAction(info, methodName);
  }

  private void logAction(String info, String methodName) {
    System.out.printf("%s %s\n", methodName, info);
  }
}
