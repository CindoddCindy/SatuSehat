package com.satusehat.task.satusehat.controller;
import com.satusehat.task.satusehat.model.HealthcareProduct;
import com.satusehat.task.satusehat.service.HealthcareProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class HealthcareProductController {
  private final HealthcareProductService service;

  @GetMapping
  public List<HealthcareProduct> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<HealthcareProduct> getById(@PathVariable Long id) {
    return service.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public HealthcareProduct create(@RequestBody HealthcareProduct product) {
    return service.create(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<HealthcareProduct> update(@PathVariable Long id, @RequestBody HealthcareProduct product) {
    return service.update(id, product)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }
}
