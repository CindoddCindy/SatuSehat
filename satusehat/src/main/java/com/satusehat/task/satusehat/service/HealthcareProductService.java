package com.satusehat.task.satusehat.service;
import com.satusehat.task.satusehat.model.HealthcareProduct;
import com.satusehat.task.satusehat.repository.HealthcareProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HealthcareProductService {
  private final HealthcareProductRepository repository;

  public List<HealthcareProduct> getAll() {
    return repository.findAll();
  }

  public Optional<HealthcareProduct> getById(Long id) {
    return repository.findById(id);
  }

  public HealthcareProduct create(HealthcareProduct product) {
    return repository.save(product);
  }

  public Optional<HealthcareProduct> update(Long id, HealthcareProduct updated) {
    return repository.findById(id).map(p -> {
      p.setName(updated.getName());
      p.setSku(updated.getSku());
      p.setImageUrl(updated.getImageUrl());
      p.setPrice(updated.getPrice());
      p.setDescription(updated.getDescription());
      p.setCategory(updated.getCategory());
      return repository.save(p);
    });
  }

  public boolean delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
