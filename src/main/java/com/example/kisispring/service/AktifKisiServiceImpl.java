package com.example.kisispring.service;

import com.example.kisispring.dto.KisiDTO;
import com.example.kisispring.entity.Kisi;
import com.example.kisispring.repo.IKisiRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "aktifKisiService")

public class AktifKisiServiceImpl implements IAktifKisiService {
    private IKisiRepo kisiRepo;
    private ModelMapper modelMapper;

    @Autowired
    public AktifKisiServiceImpl(IKisiRepo kisiRepo, ModelMapper modelMapper) {
        this.kisiRepo = kisiRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public KisiDTO idyeGoreGetir(Long id) {
        return modelMapper.map(kisiRepo.getById(id), KisiDTO.class);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public KisiDTO aktifKisiKaydet(KisiDTO kisi) throws Exception {

        Kisi kk =new Kisi();
        kk.setAdi(kisi.getAdi());
        kk.setSoyadi(kisi.getSoyadi());
        kk.setTcKimlikNo(kisi.getTcKimlikNo());
        kk.setCepTel(kisi.getCepTel());
        kk.setEMail(kisi.getEMail());
        kk.setStatu(kisi.getStatu());
        kk.setDepartman(kisi.getDepartman());


        return modelMapper.map(kisiRepo.save(kk), KisiDTO.class);
    }

    @Override
    public KisiDTO aktifKisiGuncelle(KisiDTO kisi) throws Exception {

        Kisi kg = kisiRepo.getOne(kisi.getId());
        if (kg == null)
            throw new Exception("Kisi Bulunamadı");

        kg.setAdi(kisi.getAdi());
        kg.setSoyadi(kisi.getSoyadi());
        kg.setTcKimlikNo(kisi.getTcKimlikNo());
        kg.setCepTel(kisi.getCepTel());
        kg.setEMail(kisi.getEMail());
        kg.setStatu(kisi.getStatu());
        kg.setDepartman(kisi.getDepartman());

        return modelMapper.map(kisiRepo.save(kg), KisiDTO.class);
    }

    @Override
    public void aktifKisiSil(Long id) {
        kisiRepo.deleteById(id);
    }

    @Override
    public List<KisiDTO> tumunuGetir() {
        return modelMapper.map(kisiRepo.findAll(),new TypeToken<List<KisiDTO>>(){}.getType());
    }


}