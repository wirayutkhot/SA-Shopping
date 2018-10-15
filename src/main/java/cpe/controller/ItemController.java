package cpe.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cpe.entity.Item;
import cpe.repository.ItemRepository;

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

@RestController
class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemReepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/Item-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Item>  productList() {
        return itemRepository.findAll().stream()
        .collect(Collectors.toList());
    }
    
    @GetMapping("/Item-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Item  productList(@PathVariable("id") Long id) {
        return itemRepository.findByItemID(id);
    }

}
