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
@Table(name = "Item")
public class Item {
    @Id
    @NotNull
        @SequenceGenerator(name="itemID_seq",sequenceName="itemID_seq")               
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="itemID_seq")  
    private @NonNull Long itemID;
    private @NonNull String itemname;
    private @NonNull String detail;
    private @NonNull Integer price;
    private @NonNull Integer qty;

    @ManyToOne
    private ListItem listItem;

    protected Item(String itemname, String detail, Integer price, Integer qty) {
        this.itemname = itemname;
        this.detail = detail;
        this.price = price;
        this.qty = qty;
    }
}
