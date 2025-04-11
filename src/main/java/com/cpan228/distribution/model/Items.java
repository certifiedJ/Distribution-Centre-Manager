package com.cpan228.distribution.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt = LocalDateTime.now();
    private String name;
    private String brand;
    @Column(name = "product_year")
    private int year;
    private double price;

    public Items(Long id, String name, String brand, int year, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
}