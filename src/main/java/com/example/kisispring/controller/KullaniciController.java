package com.example.kisispring.controller;

import com.example.kisispring.common.Util;
import com.example.kisispring.dto.BaseResponse;
import com.example.kisispring.dto.KullaniciDTO;
import com.example.kisispring.service.IKullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/kullanici")
@RestController
public class KullaniciController {

    private IKullaniciService kullaniciService;

    @Autowired
    public KullaniciController(IKullaniciService kullaniciService)
    {
        this.kullaniciService = kullaniciService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(kullaniciService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody KullaniciDTO y) {

        try {
            return Util.islemSonucGetir(kullaniciService.kullaniciKaydet(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "girisControl", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse girisControl(@RequestBody KullaniciDTO y){
        try {
            return Util.islemSonucGetir(kullaniciService.kullaniciGuncelle(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }

    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody KullaniciDTO y) {

        try {
            return Util.islemSonucGetir(kullaniciService.kullaniciGuncelle(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        kullaniciService.kullaniciSil(id);
        return Util.islemSonucGetir(null);
    }

}
