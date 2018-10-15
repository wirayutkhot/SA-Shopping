package cpe.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Entity;

import java.time.LocalDate;
import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Data
@ToString 
@EqualsAndHashCode
@Table(name="Order")
public class Order {
    @Id
    @NotNull 
    @SequenceGenerator(name="order_seq",sequenceName="order_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_seq")
    private @NonNull Long orderID;
    private @NonNull Date date;

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "customerID", nullable = true)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "listItemID", nullable = true)
    private Collection<ListItem> listItem;
    
    private Order(){}
    
    public Order(Long id,Date date,Customer customer,Collection<ListItem> listItem){
      this.orderID = orderID;
      this.date = date;
      this.customer = customer;
      this.listItem = listItem;
    }
	
}

