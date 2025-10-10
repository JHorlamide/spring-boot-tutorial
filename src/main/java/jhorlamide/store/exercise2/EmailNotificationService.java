package jhorlamide.store.exercise2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
  @Value("${email.port}")
  private String port;

  @Value("${email.host}")
  private String host;

  @Override
  public void send(String recipientEmail, String message) {
    System.out.println("Email Host: " + host);
    System.out.println("Email Port: " + port);
    System.out.println("Email sent to " + recipientEmail + " message: " + message);
  }
}
