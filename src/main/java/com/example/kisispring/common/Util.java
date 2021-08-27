package com.example.kisispring.common;

import com.example.kisispring.dto.BaseResponse;
import com.example.kisispring.enums.EnumSonucTipi;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static <E> List<E> iterableToList(Iterable<E> iterable) {
        List<E> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }


    public static BaseResponse islemSonucGetir(Object o) {
        BaseResponse r = new BaseResponse();
        if (o == null) {//Sadece silme işleminde
            r.setData("Silme işlemi başarılı");
            r.setIslemSonucu(EnumSonucTipi.Basarili);
        } else if (o instanceof AuthenticationException) {
            r.setIslemSonucu(EnumSonucTipi.Basarisiz);
            r.setHata(exceptionToString((Exception) o));
        } else {
            r.setIslemSonucu(EnumSonucTipi.Basarili);
            r.setData(o);

        }
        return r;
    }

    public static String exceptionToString(Exception ex) {
        if (ex == null) {
            return "Bilinmeyen bir hata oluştu. Bu hatayı aldığınız senaryoyu lütfen program yöneticisine bildiriniz.";
        } else {
            return ex.getMessage();
        }
    }


}