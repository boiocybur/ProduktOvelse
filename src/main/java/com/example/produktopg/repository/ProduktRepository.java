package com.example.produktopg.repository;

import com.example.produktopg.model.Produkt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class ProduktRepository {
    private ArrayList<Produkt> produktliste;

    public ProduktRepository() {
        this.produktliste = new ArrayList<>();
        produktliste.add(new Produkt(1, "mælk", 10));
        produktliste.add(new Produkt(2, "sukker", 12));
        produktliste.add(new Produkt(3, "æg", 4));
    }

    public ArrayList<Produkt> getProduktliste(){
        return produktliste;
    }

    public Produkt addProduct(int id, String name, int price) {
            Produkt newProduct = new Produkt(id, name, price);
            produktliste.add(newProduct);
            return newProduct;
        }
    }
