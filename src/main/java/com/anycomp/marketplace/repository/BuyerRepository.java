package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
// This interface extends JpaRepository, which provides CRUD operations for the Buyer entity.
// The Long type parameter indicates that the ID of the Buyer entity is of type Long.


