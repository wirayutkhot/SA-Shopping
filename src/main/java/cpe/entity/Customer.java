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
@Table(name = "Customer")
public class Customer {
	@Id
	@NotNull
	@SequenceGenerator(name="customerId_seq",sequenceName="customerId_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customerId_seq")


	private @NonNull Long customerId;
	private @NonNull String customerName;
	
	
	private @NonNull String addr;
	private @NonNull Integer phone;

	public Customer(String  customerName,String addr,Integer phone) {  //constructor 
			this.customerName = customerName;
			this.addr = addr;
			this.phone = phone;
		}
}
