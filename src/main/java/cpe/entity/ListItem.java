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
@Table( name = "ListItem")
public class ListItem {

  @Id  
  @NotNull
  @SequenceGenerator(name="listItemId_seq",sequenceName="listItemId_seq")               
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="listItemId_seq")     
  private @NonNull Long listItemId;




    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId", nullable = true)
    
    private Collection<Item> item;

      public ListItem(Collection<Item> item ){
       this.item = item;
      }

}
