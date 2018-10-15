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
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "ListItem")
public class ListItem {
    @Id
    @GeneratedValue
    private @NonNull Long listItemID;
    private @NonNull String name;

    @ManyToOne 
    private Order order;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "itemID", nullable = true)
	  private Collection<Item> item;

}
