package com.anycomp.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anycomp.marketplace.model.Seller;
import com.anycomp.marketplace.service.SellerService;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }
}

// package com.anycomp.marketplace.controller;

// import com.anycomp.marketplace.model.Seller;
// import com.anycomp.marketplace.service.SellerService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/sellers")
// public class SellerController {
//     private final SellerService service;

//     public SellerController(SellerService service) {
//         this.service = service;
//     }

//     @GetMapping
//     public List<Seller> getAll() { return service.findAll(); }

//     @GetMapping("/{id}")
//     public Seller getById(@PathVariable Long id) {
//         return service.findById(id).orElseThrow();
//     }

//     @PostMapping
//     public Seller create(@RequestBody Seller seller) {
//         return service.save(seller);
//     }

//     @PutMapping("/{id}")
//     public Seller update(@PathVariable Long id, @RequestBody Seller updated) {
//         Seller seller = service.findById(id).orElseThrow();
//         seller.setName(updated.getName());
//         return service.save(seller);
//     }

//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {
//         service.deleteById(id);
//     }
// }

// package com.anycomp.marketplace.controller;

// import com.anycomp.marketplace.model.Seller;
// import com.anycomp.marketplace.repository.SellerRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/sellers")
// public class SellerController {

//     @Autowired
//     private SellerRepository sellerRepository;

//     @GetMapping
//     public List<Seller> getAllSellers() {
//         return sellerRepository.findAll();
//     }

//     @PostMapping
//     public Seller createSeller(@RequestBody Seller seller) {
//         return sellerRepository.save(seller);
//     }

//     @GetMapping("/{id}")
//     public Seller getSellerById(@PathVariable Long id) {
//         return sellerRepository.findById(id).orElse(null);
//     }

//     @PutMapping("/{id}")
//     public Seller updateSeller(@PathVariable Long id, @RequestBody Seller updatedSeller) {
//         return sellerRepository.findById(id).map(seller -> {
//             seller.setName(updatedSeller.getName());
//             return sellerRepository.save(seller);
//         }).orElse(null);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteSeller(@PathVariable Long id) {
//         sellerRepository.deleteById(id);
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
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.anycomp.marketplace.model.Seller;
// import com.anycomp.marketplace.service.SellerService;

// @CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
// @RestController
// @RequestMapping("/api/sellers")

// public class SellerController {

//     private final SellerService sellerService;

//     @Autowired
//     public SellerController(SellerService sellerService) {
//         this.sellerService = sellerService;
//     }

//     @GetMapping
//     public List<Seller> getAllSellers() {
//         return sellerService.getAllSellers();
//     }

//     @GetMapping("/{id}")
//     public Seller getSellerById(@PathVariable Long id) {
//         return sellerService.getSellerById(id)
//                 .orElseThrow(() -> new RuntimeException("Seller not found"));
//     }

//     @PostMapping
//     public Seller createSeller(@RequestBody Seller seller) {
//         return sellerService.createSeller(seller);
//     }

//     @PutMapping("/{id}")
//     public Seller updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
//         return sellerService.updateSeller(id, seller);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteSeller(@PathVariable Long id) {
//         sellerService.deleteSeller(id);
//     }
// }
