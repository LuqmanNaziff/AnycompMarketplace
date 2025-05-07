package com.anycomp.marketplace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;


    public Buyer() {}

    public Buyer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}




// package com.anycomp.marketplace.model;

// import java.util.HashSet;
// import java.util.Set;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;

// @Entity
// public class Buyer {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id; 
//     private String name;
//     private String email;  

//     @ManyToMany 
//     @JoinTable(
//         name = "buyer_seller",
//         joinColumns = @JoinColumn(name = "buyer_id"),
//         inverseJoinColumns = @JoinColumn(name = "seller_id")
//     )
//     private Set<Seller> sellers = new HashSet<>();

//     // Constructors
//     public Buyer() {}

//     public Buyer(String name) {
//         this.name = name;
//     }

//     // Getters and Setters
    
//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     } 

//     public void setName(String name) {
//         this.name = name;
//     } 

//     public Set<Seller> getSellers() {
//         return sellers;
//     } 

//     public void setSellers(Set<Seller> sellers) {
//         this.sellers = sellers;
//     } 
// }
