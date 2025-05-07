package com.anycomp.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anycomp.marketplace.model.Buyer;
import com.anycomp.marketplace.repository.BuyerRepository;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> findAll() {
         return buyerRepository.findAll(); 
        }

    public Optional<Buyer> findById(Long id) {
         return buyerRepository.findById(id); 
        }

    public Buyer save(Buyer buyer) {
         return buyerRepository.save(buyer); 
        }

    public void deleteById(Long id) {
         buyerRepository.deleteById(id); 
        }
}


// @Service
// public class BuyerService {
    
//     private final BuyerRepository buyerRepository; 

//     @Autowired 
//     public BuyerService(BuyerRepository buyerRepository) {
//         this.buyerRepository = buyerRepository;
//     }

//     public List<Buyer> getAllBuyers() {
//         return buyerRepository.findAll();
//     }

//     public Optional<Buyer> getBuyerById(Long id) {
//         return buyerRepository.findById(id);
//     }

//     public Buyer createBuyer(Buyer buyer) {
//         return buyerRepository.save(buyer);
//     }
//     // This method saves a new Buyer entity to the database.
//     // The save method will insert a new record if the ID is null or update an existing record if the ID is not null.
//     // The Buyer entity is passed as a parameter and the saved entity is returned.
    
//     public Buyer updateBuyer(Long id, Buyer buyerDetails) {
//         return buyerRepository.findById(id).map(buyer -> {
//             buyer.setName(buyerDetails.getName());
//             buyer.setSellers(buyerDetails.getSellers());
//             return buyerRepository.save(buyer);
//         }).orElseThrow(() -> new RuntimeException("Buyer not found"));
//     }

//     public void deleteBuyer(Long id) {
//         buyerRepository.deleteById(id);
//     }

// }









