package com.anycomp.marketplace.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    // orphanRemoval = true
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Item> items = new HashSet<>();

    public Seller() {}

    public Seller(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
         return id; 
        }
    public String getName() {
         return name; 
        }
    public void setName(String name) {
         this.name = name; 
        }
    public Set<Item> getItems() {
         return items; 
        }
    public void setItems(Set<Item> items) {
         this.items = items; 
        }
}


// package com.anycomp.marketplace.model;

// import java.util.HashSet;
// import java.util.Set;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;

// @Entity 
// public class Seller {
    
//     @Id 
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @ManyToMany(mappedBy = "sellers")
//     private Set<Buyer> buyers = new HashSet<>(); // Set to avoid duplicates

//     // Constructors
//     public Seller() {}

//     public Seller(String name) {
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

//     public Set<Buyer> getBuyers() {
//         return buyers;
//     }

//     public void setBuyers(Set<Buyer> buyers) {
//         this.buyers = buyers;
//     }
// }
