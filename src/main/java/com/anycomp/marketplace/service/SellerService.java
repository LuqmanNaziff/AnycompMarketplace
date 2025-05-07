package com.anycomp.marketplace.service;

import com.anycomp.marketplace.model.Seller;
import com.anycomp.marketplace.repository.SellerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}


// package com.anycomp.marketplace.service;

// import com.anycomp.marketplace.model.Seller;
// import com.anycomp.marketplace.repository.SellerRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class SellerService {

//     private final SellerRepository sellerRepository;

//     public SellerService(SellerRepository sellerRepository) {
//         this.sellerRepository = sellerRepository;
//     }

//     public List<Seller> findAll() {
//          return sellerRepository.findAll(); 
//         }

//     public Optional<Seller> findById(Long id) {
//          return sellerRepository.findById(id); 
//         }

//     public Seller save(Seller seller) { 
//         return sellerRepository.save(seller); 
//     }

//     public void deleteById(Long id) {
//          sellerRepository.deleteById(id); 
//         }
//     }

// package com.anycomp.marketplace.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.anycomp.marketplace.model.Seller;
// import com.anycomp.marketplace.repository.SellerRepository;

// @Service
// public class SellerService {

//     private final SellerRepository sellerRepository; 
           
//     @Autowired 
//     public SellerService(SellerRepository sellerRepository) {
//         this.sellerRepository = sellerRepository;
//     }
//     // This method retrieves all sellers from the database.  

//     public List<Seller> getAllSellers() {
//         return sellerRepository.findAll();
//     }
//     // This method retrieves a seller by its ID. If the seller is not found, it returns an empty Optional. 
      
//     public Optional<Seller> getSellerById(Long id) {
//         return sellerRepository.findById(id);
//     }
//     // This method creates a new seller in the database. It takes a Seller object as a parameter and returns the saved seller.
        
//     public Seller createSeller(Seller seller) {
//         return sellerRepository.save(seller);
//     }
//     // This method updates an existing seller in the database. It takes the seller ID and a Seller object with updated details as parameters.
//     // If the seller is found, it updates the details and returns the updated seller. If not found, it throws an exception. 

//     public Seller updateSeller(Long id, Seller sellerDetails) {
//         return sellerRepository.findById(id).map(seller -> {
//             seller.setName(sellerDetails.getName());
//             return sellerRepository.save(seller);
//         }).orElseThrow(() -> new RuntimeException("Seller not found"));
//     }

//     public void deleteSeller(Long id) {
//         sellerRepository.deleteById(id);
//     }
    
// }
