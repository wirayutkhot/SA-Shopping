package cpe.controller;
import cpe.entity.Item;
import cpe.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemReepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/Item-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Item>  itemList() {
        return itemRepository.findAll().stream()
        .collect(Collectors.toList());
    }
    
   /* @GetMapping("/Item-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Item  itemList(@PathVariable("id") Long id) {
        return itemRepository.findByItemId(id);
    }
*/
}
