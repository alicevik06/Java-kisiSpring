package com.example.kisispring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class KullaniciDTO extends BaseDTO{
   private String adi;
   private String soyadi;
   private String kullaniciAdi;
   private String parola;
}
