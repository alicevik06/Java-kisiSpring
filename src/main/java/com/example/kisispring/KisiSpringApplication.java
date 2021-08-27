package com.example.kisispring;

import com.example.kisispring.dto.YetkiliDTO;
import com.example.kisispring.entity.Yetkili;
import com.example.kisispring.service.IYetkiliService;
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
    CommandLineRunner runner(IYetkiliService yetkiliService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<YetkiliDTO>> ref = new TypeReference<List<YetkiliDTO>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/yetkiliKisi.json");
            try {
                List<YetkiliDTO> yetkililer = mapper.readValue(inputStream, ref);
                YetkiliDTO yetkili = yetkililer.get(0);

                if (yetkiliService.findByKullaniciAdi(yetkili.getKullaniciAdi()) == null) {
                    yetkiliService.yetkiliKaydet(yetkili);

                }

            } catch (IOException e) {
                System.out.println("Unable to save Yetkili Kişi" + e.getMessage());
            }
        };
    }
}
