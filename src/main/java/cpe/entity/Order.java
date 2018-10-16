package cpe.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Entity;
import cpe.entity.Customer;
import cpe.entity.ListItem;
import java.time.LocalDate;
import java.util.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name="Order") 
public class Order {
    @Id
    @NotNull 
    @SequenceGenerator(name="order_seq",sequenceName="order_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_seq")
    private @NonNull Long orderId;
  

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "customerId", nullable = true)
    private Customer customer;
    

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "listItemId", nullable = true)
    private Collection<ListItem> listItem;
    
	@NotNull
	private LocalDate  date;
  private Order(){}
    
    public Order(Customer customer,Collection<ListItem> listItem){
      this.customer = customer;
      this.listItem = listItem;
      this.date = LocalDate.now();
    }
	
}

