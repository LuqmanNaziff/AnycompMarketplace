package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
// This interface extends JpaRepository, which provides CRUD operations for the Seller entity.
// The Long type parameter indicates that the ID of the Seller entity is of type Long.


