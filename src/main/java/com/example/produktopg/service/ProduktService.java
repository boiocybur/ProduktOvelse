package com.example.produktopg.service;
import com.example.produktopg.model.Produkt;
import com.example.produktopg.repository.ProduktRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProduktService {
    private ProduktRepository produktRepository;

    public ProduktService() {
        this.produktRepository = new ProduktRepository();
    }

    public ArrayList<Produkt> getAttraction() {
        return produktRepository.getProduktliste();
    }

    public Produkt addProduct(int id, String name, int price) {
            return produktRepository.addProduct(id, name, price);
        }

    public Produkt createProduct(Produkt product) {
        return produktRepository.addProduct(product.getId(), product.getName(), product.getPrice());
    }

    public Produkt updateProduct(int id, String name, int price) {
        for (Produkt produkt : produktRepository.getProduktliste()) {
            if (produkt.getId() == id) {
                produkt.setName(name);
                produkt.setPrice(price);
                return produkt;
            }
        }
        return null;
    }

    public Produkt postUpdate(int id, Produkt updateProdukt){
        for(Produkt produkt : produktRepository.getProduktliste()){
            if(produkt.getId() == id){
                produkt.setName(updateProdukt.getName());
                produkt.setPrice(updateProdukt.getPrice());
                return produkt;
            }
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        return produktRepository.getProduktliste().removeIf(produkt -> produkt.getId() == id);
    }

}
