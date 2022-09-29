package com.marcelocastro.springmongopoc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoPocApplication {

  public static void main(String[] args) {
    SpringApplication.run(MongoPocApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(CustomerMongoRepository customerMongoRepository) {
    return args -> {
      String email = "some@email.com";
      customerMongoRepository.findCustomerByEmail(email)
          .ifPresentOrElse(
              customer -> System.out.println("Email already used"),
              () ->
                customerMongoRepository.insert(
                    Customer.builder()
                        .id("6334ce61db5cec1e1f97ee6f")
                        .firstName("John")
                        .lastName("Doe")
                        .email(email)
                        .gender(Gender.MALE)
                        .favoritesSubjects(List.of("Study", "Music", "Movies"))
                        .totalSpent(BigDecimal.TEN)
                        .createdAt(LocalDateTime.now())
                        .build())
          );
    };
  }
}
