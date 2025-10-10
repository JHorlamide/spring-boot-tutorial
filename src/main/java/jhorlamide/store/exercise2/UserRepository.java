package jhorlamide.store.exercise2;

public interface UserRepository {
  void save(User user);
  User findByEmail(String email);
}
