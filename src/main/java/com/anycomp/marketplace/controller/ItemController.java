package com.anycomp.marketplace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anycomp.marketplace.model.Item;
import com.anycomp.marketplace.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Item> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @GetMapping("/seller/{sellerId}")
    public List<Item> getBySeller(@PathVariable Long sellerId) {
        return service.findBySellerId(sellerId);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item updated) {
        Item item = service.findById(id).orElseThrow();
        item.setName(updated.getName());
        item.setPrice(updated.getPrice());
        item.setSeller(updated.getSeller());
        return service.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}


// package com.anycomp.marketplace.controller;

// import com.anycomp.marketplace.model.Item;
// import com.anycomp.marketplace.model.Seller;
// import com.anycomp.marketplace.repository.ItemRepository;
// import com.anycomp.marketplace.repository.SellerRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/items")
// public class ItemController {

//     @Autowired
//     private ItemRepository itemRepository;

//     @Autowired
//     private SellerRepository sellerRepository;

//     @GetMapping
//     public List<Item> getAllItems() {
//         return itemRepository.findAll();
//     }

//     @PostMapping
//     public Item createItem(@RequestBody Item item) {
//         // Validate and attach seller
//         if (item.getSeller() != null) {
//             Long sellerId = item.getSeller().getId();
//             Seller seller = sellerRepository.findById(sellerId).orElse(null);
//             if (seller != null) {
//                 item.setSeller(seller);
//                 return itemRepository.save(item);
//             }
//         }
//         return null; // or throw exception
//     }

//     @GetMapping("/{id}")
//     public Item getItemById(@PathVariable Long id) {
//         return itemRepository.findById(id).orElse(null);
//     }

//     @PutMapping("/{id}")
//     public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
//         return itemRepository.findById(id).map(item -> {
//             item.setName(updatedItem.getName());
//             item.setPrice(updatedItem.getPrice());
//             if (updatedItem.getSeller() != null) {
//                 Seller seller = sellerRepository.findById(updatedItem.getSeller().getId()).orElse(null);
//                 item.setSeller(seller);
//             }
//             return itemRepository.save(item);
//         }).orElse(null);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteItem(@PathVariable Long id) {
//         itemRepository.deleteById(id);
//     }
// }
