package com.anycomp.marketplace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonBackReference
    private Seller seller;


    public Item() {}

    public Item(String name, double price, Seller seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
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
    public double getPrice() {
         return price; 
        }
    public void setPrice(double price) {
         this.price = price; 
        }
    public Seller getSeller() {
         return seller; 
        }
    public void setSeller(Seller seller) {
         this.seller = seller; 
        }
        
}


// package com.anycomp.marketplace.model;

// import jakarta.persistence.*;

// @Entity
// public class Item {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;
//     private Double price;

//     @ManyToOne
//     @JoinColumn(name = "seller_id", nullable = false)
//     private Seller seller;

//     // Constructors
//     public Item() {}

//     public Item(String name, Double price, Seller seller) {
//         this.name = name;
//         this.price = price;
//         this.seller = seller;
//     }

//     public Item(Long id, String name, Double price, Seller seller) {
//         this.id = id;
//         this.name = name;
//         this.price = price;
//         this.seller = seller;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Double getPrice() {
//         return price;
//     }

//     public void setPrice(Double price) {
//         this.price = price;
//     }

//     public Seller getSeller() {
//         return seller;
//     }

//     public void setSeller(Seller seller) {
//         this.seller = seller;
//     }

//     @Override
//     public String toString() {
//         return "Item{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", sellerId=" + (seller != null ? seller.getId() : null) +
//                '}';
//     }
// }
