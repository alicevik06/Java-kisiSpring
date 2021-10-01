package com.example.kisispring.entity;

import com.example.kisispring.entity.Abstract.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "kullaniciAdi")})
public class Kullanici extends BaseEntity {
    String adi;
    String soyadi;
    @NotNull
    String kullaniciAdi;
    @NotNull
    String parola;

}
