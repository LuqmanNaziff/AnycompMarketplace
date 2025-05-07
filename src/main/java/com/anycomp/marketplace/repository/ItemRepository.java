package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findBySellerId(Long sellerId);
}
// This interface extends JpaRepository, which provides CRUD operations for the Item entity.
// The Long type parameter indicates that the ID of the Item entity is of type Long.

// ItemRepository.java