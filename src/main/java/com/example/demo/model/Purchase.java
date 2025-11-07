package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal costPerUnit;
    private LocalDateTime purchasedAt;
    public Purchase(){ this.purchasedAt = LocalDateTime.now(); }
    // getters & setters (generate via IDE)
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getProductId(){return productId;} public void setProductId(Long productId){this.productId=productId;}
    public Integer getQuantity(){return quantity;} public void setQuantity(Integer quantity){this.quantity=quantity;}
    public BigDecimal getCostPerUnit(){return costPerUnit;} public void setCostPerUnit(BigDecimal costPerUnit){this.costPerUnit=costPerUnit;}
    public LocalDateTime getPurchasedAt(){return purchasedAt;} public void setPurchasedAt(LocalDateTime purchasedAt){this.purchasedAt=purchasedAt;}
}
