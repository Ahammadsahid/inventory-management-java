package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal pricePerUnit;
    private LocalDateTime soldAt;
    public Sale(){ this.soldAt = LocalDateTime.now(); }
    // getters & setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getProductId(){return productId;} public void setProductId(Long productId){this.productId=productId;}
    public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
    public BigDecimal getPricePerUnit(){return pricePerUnit;} public void setPricePerUnit(BigDecimal pricePerUnit){this.pricePerUnit=pricePerUnit;}
    public LocalDateTime getSoldAt(){return soldAt;} public void setSoldAt(LocalDateTime soldAt){this.soldAt=soldAt;}
}
