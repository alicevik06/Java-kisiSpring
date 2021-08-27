package com.example.kisispring.dto;

import com.example.kisispring.enums.EnumSonucTipi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    EnumSonucTipi islemSonucu;
    String hata;
    Object data;
}
