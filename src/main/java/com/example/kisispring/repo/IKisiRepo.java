package com.example.kisispring.repo;

import com.example.kisispring.entity.Kisi;
import com.example.kisispring.entity.Yetkili;
import com.example.kisispring.repo.base.IBaseEntityRepo;

public interface IKisiRepo extends IBaseEntityRepo<Kisi,Long> {
    Kisi findByTcKimlikNoAndSifre(String tcKimlikNo, String sifre);
}
