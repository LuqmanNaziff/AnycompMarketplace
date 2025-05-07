package com.anycomp.marketplace.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    // @JoinColumn(name = "buyer_id", nullable = false)
    @JsonBackReference
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    
    private int quantity;
    private LocalDate purchaseDate;

    public Purchase() {}

    public Purchase(Buyer buyer, Item item, int quantity, LocalDate purchaseDate) {
        this.buyer = buyer;
        this.item = item;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;    
    }

    // Getters and Setters
    public Long getId() {
         return id; 
        }
    public void setId(Long id) {
         this.id = id; 
        }

    public Buyer getBuyer() {
         return buyer; 
        }
    public void setBuyer(Buyer buyer) {
         this.buyer = buyer; 
        }
    
    public Item getItem() {
         return item; 
        }
    public void setItem(Item item) {
         this.item = item; 
        }

    public int getQuantity() {
         return quantity; 
        }
    public void setQuantity(int quantity) {
         this.quantity = quantity; 
        }
    
    public LocalDate getPurchaseDate() {
         return purchaseDate; 
        }
    public void setPurchaseDate(LocalDate purchaseDate) {
         this.purchaseDate = purchaseDate;
        }

}
