package com.anycomp.marketplace.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anycomp.marketplace.dto.PurchaseRequest;
import com.anycomp.marketplace.model.Purchase;
import com.anycomp.marketplace.service.PurchaseService;



@RestController
@RequestMapping("/api/purchases") 
public class PurchaseController {

    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody PurchaseRequest request) {
        Purchase created = service.createPurchase(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        List<Purchase> purchases = service.getAllPurchases();
        return ResponseEntity.ok(purchases);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
    //     Purchase purchase = service.getPurchaseById(id);
    //     return ResponseEntity.ok(service.getPurchaseById(id));  
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPurchaseById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable Long id, @RequestBody PurchaseRequest request) {
        Purchase updated = service.updatePurchase(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        service.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
    
}
