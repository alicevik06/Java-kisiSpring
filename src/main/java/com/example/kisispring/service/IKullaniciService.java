package com.example.kisispring.service;

import com.example.kisispring.dto.KullaniciDTO;
import com.example.kisispring.entity.Kullanici;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IKullaniciService {

    @Transactional(readOnly = true)
    KullaniciDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    KullaniciDTO kullaniciKaydet(KullaniciDTO kullanici) throws Exception;

    KullaniciDTO kullaniciGuncelle(KullaniciDTO kullanici) throws Exception;

    void kullaniciSil(Long id);

    KullaniciDTO girisControl(KullaniciDTO kullanici) throws Exception;

    List<KullaniciDTO> tumunuGetir();

    Kullanici findByKullaniciAdi(String kullaniciAdi) throws Exception;

}
