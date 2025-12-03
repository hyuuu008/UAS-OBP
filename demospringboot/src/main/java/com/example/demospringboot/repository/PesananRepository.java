
package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Pesanan;
import org.springframework.stereotype.Repository;

@Repository
public class PesananRepository {

    private Pesanan pesanan = new Pesanan();  

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void resetPesanan() {
        pesanan = new Pesanan();
    }
}
