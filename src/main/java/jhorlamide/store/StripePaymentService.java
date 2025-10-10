package jhorlamide.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("strip")
//@Primary
public class StripePaymentService implements PaymentService {
  @Value("${stripe.apiUrl}")
  private String apiUrl;

  @Value("${stripe.apiKey}")
  private String apiKey;

  @Value("${stripe.enabled}")
  private boolean enabled;

  @Value("${stripe.supported-currencies}")
  private List<String> supportedCurrencies;


  @Override
  public void processPayment(double amount) {
    System.out.println("API URL: " + apiUrl);
    System.out.println("API KEY: " + apiKey);
    System.out.println("ENABLED: " + enabled);
    System.out.println("CURRENCIES: " + supportedCurrencies);


    System.out.println("STRIPE");
    System.out.println("Amount: " + amount);
  }
}
