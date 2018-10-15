package cpe.controller;

import cpe.entity.ListItem;
import cpe.repository.ListItemRepository;

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
class ListItemController {
    private ListItemRepository listItemRepository;

    public ListItemController(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @GetMapping("/ListItem-list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<ListItem> listItem() {
        return listItemRepository.findAll().stream()
        .collect(Collectors.toList());
    }

    @GetMapping("/ListItem-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ListItem  listItemList(@PathVariable("id") Long id) {
        return listItemRepository.findByListItemID(id);
    }

}
