package org.dilan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthApplication {
  //kısa yol psvm ile çağırabilirsin
  //java da uygulamanın başlayabilmesi için statik bir metodun tetiklenmesi lazım
  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class);
  }
}
