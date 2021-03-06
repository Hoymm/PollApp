package pl.com.muca.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Responsible for starting the server.
 */
@SpringBootApplication
public class ServerApplication {

  /**
   * Starting place of the program
   * @param args startup parameters
   */
  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }
}
