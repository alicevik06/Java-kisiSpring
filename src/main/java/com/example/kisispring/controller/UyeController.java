package com.example.kisispring.controller;

import com.example.kisispring.common.Util;
import com.example.kisispring.dto.BaseResponse;
import com.example.kisispring.dto.UyeDTO;
import com.example.kisispring.service.IUyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/uye")
@RestController
public class UyeController {

    private IUyeService uyeService;

    @Autowired
    public UyeController(IUyeService uyeService)
    {
        this.uyeService = uyeService;
    }

    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(uyeService.idyeGoreGetir(id));
    }

    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody UyeDTO y) {

        try {
            return Util.islemSonucGetir(uyeService.uyeKaydet(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "girisControl", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse girisControl(@RequestBody UyeDTO y){
        try {
            return Util.islemSonucGetir(uyeService.uyeGuncelle(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }

    }

    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody UyeDTO y) {

        try {
            return Util.islemSonucGetir(uyeService.uyeGuncelle(y));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        uyeService.uyeSil(id);
        return Util.islemSonucGetir(null);
    }

}
