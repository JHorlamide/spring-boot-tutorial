package jhorlamide.store;

import jhorlamide.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

  public static void main(String[] args) {
    ApplicationContext appContext = SpringApplication.run(StoreApplication.class, args);
    UserRepository repository = appContext.getBean(UserRepository.class);

    repository.deleteById(1L);
  }

}