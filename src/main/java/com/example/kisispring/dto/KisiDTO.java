package com.example.kisispring.dto;

import com.example.kisispring.enums.EnumDepartman;
import com.example.kisispring.enums.EnumStatu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public  class KisiDTO extends BaseDTO{
    private String adi;
    private String soyadi;
    private String cepTel;
    private String tcKimlikNo;
    private String eMail;
    private EnumDepartman departman;
    private EnumStatu statu;
    private String sifre;


}
