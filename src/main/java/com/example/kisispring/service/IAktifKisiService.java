package com.example.kisispring.service;

import com.example.kisispring.dto.KisiDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAktifKisiService {

    @Transactional(readOnly = true)
    KisiDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    KisiDTO aktifKisiKaydet(KisiDTO kisi) throws Exception;

    KisiDTO aktifKisiGuncelle(KisiDTO kisi) throws Exception;

    void aktifKisiSil(Long id);

    List<KisiDTO> tumunuGetir();
}
