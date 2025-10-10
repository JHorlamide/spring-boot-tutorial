package jhorlamide.store;

import jhorlamide.store.exercise2.User;
import jhorlamide.store.exercise2.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

  public static void main(String[] args) {
    ApplicationContext appContext = SpringApplication.run(StoreApplication.class, args);
  }

}