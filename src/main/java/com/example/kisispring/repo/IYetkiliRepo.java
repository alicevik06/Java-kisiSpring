package com.example.kisispring.repo;

import com.example.kisispring.entity.Yetkili;
import com.example.kisispring.repo.base.IBaseEntityRepo;

public interface IYetkiliRepo extends IBaseEntityRepo<Yetkili,Long> {
    Yetkili findByKullaniciAdiAndParola(String kullaniciAdi,String parola);
    Yetkili findByKullaniciAdi(String kullaniciAdi);
}

