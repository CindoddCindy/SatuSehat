package com.satusehat.task.satusehat.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "healthcare_products", uniqueConstraints = @UniqueConstraint(columnNames = "sku"))

public class HealthcareProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String sku;

  private String imageUrl;

  private Double price;

  @Column(length = 2000)
  private String description;

  private String category;
}
