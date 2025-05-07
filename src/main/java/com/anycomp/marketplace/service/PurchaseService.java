package com.anycomp.marketplace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anycomp.marketplace.dto.PurchaseRequest;
import com.anycomp.marketplace.model.Buyer;
import com.anycomp.marketplace.model.Item;
import com.anycomp.marketplace.model.Purchase;
import com.anycomp.marketplace.repository.BuyerRepository;
import com.anycomp.marketplace.repository.ItemRepository;
import com.anycomp.marketplace.repository.PurchaseRepository;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final BuyerRepository buyerRepository;
    private final ItemRepository itemRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, BuyerRepository buyerRepository, ItemRepository itemRepository) {
        this.purchaseRepository = purchaseRepository;
        this.buyerRepository = buyerRepository;
        this.itemRepository = itemRepository;
    }
    public Purchase createPurchase(PurchaseRequest request) {
        Buyer buyer = buyerRepository.findById(request.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(request.getQuantity());
        purchase.setPurchaseDate(request.getPurchaseDate());

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    public Purchase updatePurchase(Long id, PurchaseRequest request) {
        Purchase purchase = getPurchaseById(id);

        Buyer buyer = buyerRepository.findById(request.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(request.getQuantity());
        purchase.setPurchaseDate(request.getPurchaseDate());

        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id) {
        /*Purchase purchase = getPurchaseById(id);*/
        purchaseRepository.deleteById(id);
    }
}
