package com.example.kisispring.repo;

import com.example.kisispring.entity.Uye;
import com.example.kisispring.repo.base.IBaseEntityRepo;

public interface IUyeRepo extends IBaseEntityRepo<Uye,Long> {
    Uye findByTcKimlikNoAndSifre(String tcKimlikNo, String sifre);
}
