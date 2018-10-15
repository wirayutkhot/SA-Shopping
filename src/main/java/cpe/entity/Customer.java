package cpe.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name = "Customer")
public class Customer {
	@Id
	@NotNull
	@SequenceGenerator(name="customerID_seq",sequenceName="customerID_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customerID_seq")
	//@column(name="CUSTOMER_ID",unique = true, nullable = true)
	private @NonNull Long customerID;
	private @NonNull String customerName;
	
	//@column(name="ADDRESS")
	private @NonNull String addr;
	private @NonNull Integer phone;
	

	@OneToMany(
		mappedBy = "customer",
		cascade = CascadeType.ALL,
		orphanRemoval = true //delete Cascade
	)
	private List<Order> order = new ArrayList<>();
	
	protected Customer() {}

	public Customer(String  customerName,String addr,Integer phone) {  //constructor 
			this.customerName = customerName;
			this.addr = addr;
			this.phone = phone;
		}
}
