package com.example.produktopg.controller;

import com.example.produktopg.model.Produkt;
import com.example.produktopg.service.ProduktService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "product")
public class ProduktController {
    private ProduktService produktService;

    public ProduktController() {
        this.produktService = new ProduktService();
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Produkt>> getProducts() {
        ArrayList produktList = produktService.getAttraction();
        return new ResponseEntity<ArrayList<Produkt>>(produktList, HttpStatus.OK);
    }

    @GetMapping(path = "/create")
    public ResponseEntity<Produkt> createProduct(@RequestParam int id,
                                                 @RequestParam String name,
                                                 @RequestParam int price) {
        Produkt returnProdukt = produktService.addProduct(id, name, price);
        return new ResponseEntity<>(returnProdukt, HttpStatus.OK);
    }

    @PostMapping(path = "/products/create")
    public ResponseEntity<Produkt> createProduct(@RequestBody Produkt product) {
        Produkt createdProduct = produktService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping(path = "products/{id}/update")
    public ResponseEntity<Produkt> updateProduct(@RequestParam int id,
                                                 @RequestParam String name,
                                                 @RequestParam int price) {
        Produkt updatedProduct = produktService.updateProduct(id, name, price);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @PostMapping(path = "products/update")
    public ResponseEntity<Produkt> postUpdate(@RequestParam int id, @RequestParam Produkt updateProduct) {
        Produkt postUpdate = produktService.postUpdate(id, updateProduct);
        return new ResponseEntity<>(postUpdate, HttpStatus.OK);
    }

    @GetMapping(path = "/products/{id}/delete")
    public ResponseEntity<Produkt> deleteProduct(@PathVariable int id) {
        boolean deleteProduct = produktService.deleteProduct(id);
        if (deleteProduct) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}