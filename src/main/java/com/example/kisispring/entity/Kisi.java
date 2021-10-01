package com.example.kisispring.entity;

import com.example.kisispring.entity.Abstract.BaseEntity;
import com.example.kisispring.enums.EnumDepartman;
import com.example.kisispring.enums.EnumStatu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "tcKimlikNo")})
public class Kisi extends BaseEntity {

    String adi;
    String soyadi;
    String cepTel;
    @NotNull
    String tcKimlikNo;
    String mail;
    @Enumerated
    EnumDepartman departman;
    EnumStatu statu;





}
