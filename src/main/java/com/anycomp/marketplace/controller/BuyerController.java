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

import com.anycomp.marketplace.model.Buyer;
import com.anycomp.marketplace.service.BuyerService;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {
    
    private final BuyerService service;

    public BuyerController(BuyerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Buyer> getAllBuyers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Buyer getBuyer(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return service.save(buyer);
    }

    @PutMapping("/{id}")
    public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer updatedBuyer) {
        Buyer buyer = service.findById(id).orElseThrow();
        buyer.setName(updatedBuyer.getName());
        buyer.setEmail(updatedBuyer.getEmail());
        return service.save(buyer);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        service.deleteById(id);
    }
}


// package com.anycomp.marketplace.controller;

// import com.anycomp.marketplace.model.Buyer;
// import com.anycomp.marketplace.repository.BuyerRepository;
// import com.anycomp.marketplace.repository.SellerRepository;
// import com.anycomp.marketplace.model.Seller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;
// import java.util.Set;

// @RestController
// @RequestMapping("/api/buyers")
// public class BuyerController {

//     @Autowired
//     private BuyerRepository buyerRepository;

//     @Autowired
//     private SellerRepository sellerRepository;

//     @GetMapping
//     public List<Buyer> getAllBuyers() {
//         return buyerRepository.findAll();
//     }

//     @PostMapping
//     public Buyer createBuyer(@RequestBody Buyer buyer) {
//         // Reattach existing sellers to prevent detached entity exception
//         Set<Seller> sellers = buyer.getSellers();
//         if (sellers != null) {
//             for (Seller seller : sellers) {
//                 sellerRepository.findById(seller.getId()).ifPresent(existingSeller -> {
//                     seller.setId(existingSeller.getId());
//                     seller.setName(existingSeller.getName());
//                     seller.setEmail(existingSeller.getEmail());
//                     seller.setItems(existingSeller.getItems());
//                 });
//             }
//         }
//         return buyerRepository.save(buyer);
//     }

//     // @PostMapping
//     // public Buyer createBuyer(@RequestBody Buyer buyer) { return buyerRepository.save(buyer); }

//     @GetMapping("/{id}")
//     public Buyer getBuyerById(@PathVariable Long id) {
//         return buyerRepository.findById(id).orElse(null);
//     }

//     @PutMapping("/{id}")
//     public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer updatedBuyer) {
//         return buyerRepository.findById(id).map(buyer -> {
//             buyer.setName(updatedBuyer.getName());
//             buyer.setEmail(updatedBuyer.getEmail());
//             buyer.setSellers(updatedBuyer.getSellers());
//             return buyerRepository.save(buyer);
//         }).orElse(null);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteBuyer(@PathVariable Long id) {
//         buyerRepository.deleteById(id);
//     }
// }


// package com.anycomp.marketplace.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.anycomp.marketplace.model.Buyer;
// import com.anycomp.marketplace.service.BuyerService;

// @CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
// @RestController
// @RequestMapping("/api/buyers")

// public class BuyerController {
    
//     private final BuyerService buyerService;

//     @Autowired
//     public BuyerController(BuyerService buyerService) {
//         this.buyerService = buyerService;
//     }

//     @GetMapping
//     public List<Buyer> getAllBuyers() {
//         return buyerService.getAllBuyers();
//     }
//     // This method retrieves all buyers from the database and returns them as a list.
//     // It uses the BuyerService to fetch the data from the repository.

//     @GetMapping("/{id}")
//     public Buyer getBuyerById(@PathVariable Long id) {
//         return buyerService.getBuyerById(id)
//                 .orElseThrow(() -> new RuntimeException("Buyer not found"));
//     }

//     @PostMapping
//     public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer buyer) {
//         return buyerService.updateBuyer(id, buyer);
//     }
//     // This method updates an existing buyer in the database. It takes the buyer ID and a Buyer object with updated details as parameters.
//     // If the buyer is found, it updates the details and returns the updated buyer. If not found, it throws an exception.

//     @DeleteMapping("/{id}")
//     public void deleteBuyer(@PathVariable Long id) {
//         buyerService.deleteBuyer(id);
//     }
// }
