package com.example.kisispring.service;

import com.example.kisispring.dto.YetkiliDTO;
import com.example.kisispring.entity.Yetkili;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IYetkiliService {

    @Transactional(readOnly = true)
    YetkiliDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    YetkiliDTO yetkiliKaydet(YetkiliDTO yetkili) throws Exception;

    YetkiliDTO yetkiliGuncelle(YetkiliDTO yetkili) throws Exception;

    void yetkiliSil(Long id);

    YetkiliDTO girisControl(YetkiliDTO yetkili) throws Exception;

    List<YetkiliDTO> tumunuGetir();

    Yetkili findByKullaniciAdi(String kullaniciAdi) throws Exception;

}
