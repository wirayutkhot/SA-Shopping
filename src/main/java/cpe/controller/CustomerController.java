package cpe.controller;
import cpe.entity.Customer;
import cpe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Customer-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Customer> customerList() {
        return customerRepository.findAll().stream()
        .collect(Collectors.toList());
    }


   /*@GetMapping("/Customer-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Customer customerFind(@PathVariable("id") Long id) {

        return customerRepository.findByCustomerId(id);
    }
*/
}
