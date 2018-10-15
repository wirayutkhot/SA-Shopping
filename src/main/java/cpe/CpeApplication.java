package cpe;

import cpe.entity.*;
import cpe.repository.*;
import cpe.controller.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class CpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args);
    }

   /*ean
    ApplicationRunner init(CustomerRepository customerRepository)
        {
            return args -> {
                Customer customer1 = new Customer();
                Customer1.setCustomerName("Wirayut Khotsuk");
                customerRepository.save(customer1);

                Customer customer2 = new Customer();
                Customer1.setCustomerName("Bancha Nonpala");
                customerRepository.save(customer2);
            };
        }*/
}