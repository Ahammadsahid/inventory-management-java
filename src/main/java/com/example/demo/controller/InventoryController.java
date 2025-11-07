package com.example.demo.controller;

import com.example.demo.model.Purchase;
import com.example.demo.model.Sale;
import com.example.demo.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin
public class InventoryController {
    private final InventoryService service;
    public InventoryController(InventoryService service){ this.service = service; }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody Purchase p){
        try { return ResponseEntity.status(201).body(service.recordPurchase(p)); }
        catch (IllegalArgumentException ex){ return ResponseEntity.badRequest().body(ex.getMessage()); }
    }

    @PostMapping("/sale")
    public ResponseEntity<?> sale(@RequestBody Sale s){
        try { return ResponseEntity.status(201).body(service.recordSale(s)); }
        catch (IllegalArgumentException ex){ return ResponseEntity.badRequest().body(ex.getMessage()); }
    }
}
