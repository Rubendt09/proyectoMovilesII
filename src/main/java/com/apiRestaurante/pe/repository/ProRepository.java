package com.apiRestaurante.pe.repository;

import com.apiRestaurante.pe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepository extends JpaRepository<Product, Long> {
}
