package com.satusehat.task.satusehat.repository;
import com.satusehat.task.satusehat.model.HealthcareProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface HealthcareProductRepository extends JpaRepository<HealthcareProduct, Long>{
  Optional<HealthcareProduct> findBySku(String sku);
}
