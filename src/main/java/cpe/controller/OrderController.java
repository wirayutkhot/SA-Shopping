package cpe.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cpe.entity.Order;
import cpe.repository.CustomerRepository;
import cpe.repository.ItemRepository;
import cpe.repository.ListItemRepository;
import cpe.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {
    @Autowired private final OrderRepository orderRepository;
    @Autowired private ListItemRepository listItemRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private CustomerRepository customerRepository;

    public OrderController(OrderRepository orderRepository,ListItemRepository listItemRepository,ItemRepository itemRepository,CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.listItemRepository = listItemRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Order-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Order orderList(@PathVariable("id") Long id) {
        return orderRepository.findByOrderID(id);
    }

    @GetMapping("/Order-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Order> order() {
        return orderRepository.findAll().stream()
        .collect(Collectors.toList());
    }

}

