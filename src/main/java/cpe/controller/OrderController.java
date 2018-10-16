package cpe.controller;
import cpe.entity.Order;
import cpe.repository.CustomerRepository;
import cpe.repository.ItemRepository;
import cpe.repository.ListItemRepository;
import cpe.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class OrderController {
     private  OrderRepository orderRepository;
     private ListItemRepository listItemRepository;
     private ItemRepository itemRepository;
     private CustomerRepository customerRepository;

    public OrderController(OrderRepository orderRepository,ListItemRepository listItemRepository,ItemRepository itemRepository,CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.listItemRepository = listItemRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Order-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Order orderList(@PathVariable("id") Long id) {
        return orderRepository.findByOrderId(id);
    }

    @GetMapping("/Order-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Order> orderList() {
        return orderRepository.findAll().stream()
        .collect(Collectors.toList());
    }

}

