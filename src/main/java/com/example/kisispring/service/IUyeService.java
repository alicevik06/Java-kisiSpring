package com.example.kisispring.service;

import com.example.kisispring.dto.UyeDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUyeService {
    @Transactional(readOnly = true)
    UyeDTO idyeGoreGetir(Long id);

    @Transactional(rollbackFor = Exception.class)
    UyeDTO uyeKaydet(UyeDTO uye) throws Exception;

    UyeDTO uyeGuncelle(UyeDTO uye) throws Exception;

    void uyeSil(Long id);

    List<UyeDTO> tumunuGetir();

    UyeDTO girisControl(UyeDTO uye) throws Exception;
}
