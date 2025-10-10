package jhorlamide.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Value("${payment-gateway}")
  private String paymentGateway;

  @Bean
  public PaymentService stripe() {
    return new StripePaymentService();
  }

  @Bean
  public PaymentService paypal() {
    return new PayPalPaymentService();
  }

  @Bean
  public OrderService orderService() {
    PaymentService paymentService = "stripe".equals(paymentGateway) ? stripe() : paypal();
    return new OrderService(paymentService);
  }
}
