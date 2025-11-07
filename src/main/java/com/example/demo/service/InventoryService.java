package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Purchase;
import com.example.demo.model.Sale;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SaleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class InventoryService {
    private final ProductRepository productRepo;
    private final PurchaseRepository purchaseRepo;
    private final SaleRepository saleRepo;

    public InventoryService(ProductRepository productRepo, PurchaseRepository purchaseRepo, SaleRepository saleRepo){
        this.productRepo = productRepo;
        this.purchaseRepo = purchaseRepo;
        this.saleRepo = saleRepo;
    }

    @Transactional
    public Purchase recordPurchase(Purchase purchase){
        Optional<Product> op = productRepo.findById(purchase.getProductId());
        if (op.isEmpty()) throw new IllegalArgumentException("Product not found: " + purchase.getProductId());
        Product p = op.get();
        int cur = p.getQuantity() == null ? 0 : p.getQuantity();
        int add = purchase.getQuantity() == null ? 0 : purchase.getQuantity();
        p.setQuantity(cur + add);
        productRepo.save(p);
        return purchaseRepo.save(purchase);
    }

    @Transactional
    public Sale recordSale(Sale sale){
        Optional<Product> op = productRepo.findById(sale.getProductId());
        if (op.isEmpty()) throw new IllegalArgumentException("Product not found: " + sale.getProductId());
        Product p = op.get();
        int cur = p.getQuantity() == null ? 0 : p.getQuantity();
        int qty = sale.getQuantity() == null ? 0 : sale.getQuantity();
        if (qty > cur) throw new IllegalArgumentException("Not enough stock. Available: " + cur);
        p.setQuantity(cur - qty);
        productRepo.save(p);
        return saleRepo.save(sale);
    }
}
