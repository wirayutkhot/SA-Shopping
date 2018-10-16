package cpe;
import cpe.repository.*;
import cpe.entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    private OrderRepository orderRepository;
    private ListItemRepository listItemRepository;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;
 
    @Autowired
    public DataLoader(OrderRepository orderRepository, ListItemRepository listItemRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.listItemRepository = listItemRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
       
    }



    @Override
    public void run(ApplicationArguments args) throws Exception {


     
    }
    
}
