package com.anycomp.marketplace.service;

import com.anycomp.marketplace.model.Item;
import com.anycomp.marketplace.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() { return itemRepository.findAll(); }

    public Optional<Item> findById(Long id) { return itemRepository.findById(id); }

    public List<Item> findBySellerId(Long sellerId) { return itemRepository.findBySellerId(sellerId); }

    public Item save(Item item) { return itemRepository.save(item); }

    public void deleteById(Long id) { itemRepository.deleteById(id); }
}


// package com.anycomp.marketplace.service;

// import com.anycomp.marketplace.model.Item;
// import com.anycomp.marketplace.repository.ItemRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class ItemService {

//     @Autowired
//     private ItemRepository itemRepository;

//     public List<Item> getAllItems() {
//         return itemRepository.findAll();
//     }

//     public Optional<Item> getItemById(Long id) {
//         return itemRepository.findById(id);
//     }

//     public Item saveItem(Item item) {
//         return itemRepository.save(item);
//     }

//     public void deleteItem(Long id) {
//         itemRepository.deleteById(id);
//     }
// }
