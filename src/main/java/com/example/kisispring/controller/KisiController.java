package com.example.kisispring.controller;

import com.example.kisispring.common.Util;
import com.example.kisispring.dto.BaseResponse;
import com.example.kisispring.dto.KisiDTO;
import com.example.kisispring.service.IKisiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/kisi")
@RestController
public class KisiController {

    private IKisiService kisiService;

    @Autowired
    public KisiController(IKisiService kisiService) {
        this.kisiService = kisiService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(kisiService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody KisiDTO k) {

        try {
            return Util.islemSonucGetir(kisiService.kisiKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody KisiDTO k) {

        try {
            return Util.islemSonucGetir(kisiService.kisiGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        kisiService.kisiSil(id);
        return Util.islemSonucGetir(null);
    }
}