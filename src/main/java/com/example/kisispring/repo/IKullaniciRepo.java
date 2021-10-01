package com.example.kisispring.repo;

import com.example.kisispring.entity.Kullanici;
import com.example.kisispring.repo.base.IBaseEntityRepo;

public interface IKullaniciRepo extends IBaseEntityRepo<Kullanici,Long> {
    Kullanici findByKullaniciAdiAndParola(String kullaniciAdi, String parola);
    Kullanici findByKullaniciAdi(String kullaniciAdi);
}

