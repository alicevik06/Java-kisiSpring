package com.example.kisispring;

import com.example.kisispring.dto.KullaniciDTO;
import com.example.kisispring.service.IKullaniciService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class KisiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KisiSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(IKullaniciService kullaniciService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<KullaniciDTO>> ref = new TypeReference<List<KullaniciDTO>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/Kullanici.json");
            try {
                List<KullaniciDTO> kullanicilar = mapper.readValue(inputStream, ref);
                KullaniciDTO kullanici = kullanicilar.get(0);

                if (kullaniciService.findByKullaniciAdi(kullanici.getKullaniciAdi()) == null) {
                    kullaniciService.kullaniciKaydet(kullanici);

                }

            } catch (IOException e) {
                System.out.println("Unable to save Kullanici Kişi" + e.getMessage());
            }
        };
    }
}
