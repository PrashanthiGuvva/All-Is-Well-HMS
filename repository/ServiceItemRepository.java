package com.alliswell.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliswell.hms.model.ServiceItem;

import java.util.List;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
    // Find service by name
    List<ServiceItem> findByServiceNameContainingIgnoreCase(String keyword);

    // Find services cheaper than price
    List<ServiceItem> findByPriceLessThan(double price);

    // Find services more expensive than price
    List<ServiceItem> findByPriceGreaterThanEqual(double price);
}
