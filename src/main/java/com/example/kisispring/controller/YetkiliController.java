package com.example.kisispring.controller;

import com.example.kisispring.common.Util;
import com.example.kisispring.dto.BaseResponse;
import com.example.kisispring.dto.YetkiliDTO;
import com.example.kisispring.service.IYetkiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class YetkiliController {

    private IYetkiliService yetkiliService;

    @Autowired
    public YetkiliController(IYetkiliService yetkiliService)
    {
        this.yetkiliService = yetkiliService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(yetkiliService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody YetkiliDTO y) {

        try {
            return Util.islemSonucGetir(yetkiliService.yetkiliKaydet(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "girisControl", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse girisControl(@RequestBody YetkiliDTO y){
        try {
            return Util.islemSonucGetir(yetkiliService.yetkiliGuncelle(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }

    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody YetkiliDTO y) {

        try {
            return Util.islemSonucGetir(yetkiliService.yetkiliGuncelle(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        yetkiliService.yetkiliSil(id);
        return Util.islemSonucGetir(null);
    }

}
