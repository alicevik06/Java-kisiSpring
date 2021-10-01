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

@Service(value = "kisiService")
public class KisiServiceImpl implements IKisiService {

    private IKisiRepo kisiRepo;
    private ModelMapper modelMapper;

   @Autowired
    public KisiServiceImpl(IKisiRepo kisiRepo, ModelMapper modelMapper) {
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
    public KisiDTO kisiKaydet(KisiDTO kisi) throws Exception {

        if (kisi.getId() != null)
            throw new Exception("Id dolu olamaz");
        Kisi k=new Kisi();
//        k.setAdi(kisi.getAdi());
//        k.setSoyadi(kisi.getSoyadi());
//        k.setMail(kisi.getMail());
//        k.setTcKimlikNo(kisi.getTcKimlikNo());


        Kisi kk = modelMapper.map(kisi, Kisi.class);
        return modelMapper.map(kisiRepo.save(kk), KisiDTO.class);

    }

    @Override
    public KisiDTO kisiGuncelle(KisiDTO kisi) throws Exception {
        if(kisi.getId() == null)
            throw new Exception("Id Bos Olamaz");
        Kisi kg = kisiRepo.getOne(kisi.getId());
        if (kg == null)
            throw new Exception("Kisi Bulunamadı");
        kg.setAdi(kg.getAdi());
        kg.setSoyadi(kg.getSoyadi());
        kg.setCepTel(kg.getCepTel());
        kg.setTcKimlikNo(kg.getTcKimlikNo());
        kg.setMail(kg.getMail());
        kg.setStatu(kg.getStatu());
        kg.setDepartman(kg.getDepartman());


        return modelMapper.map(kisiRepo.save(kg), KisiDTO.class);
    }

    @Override
    public void kisiSil(Long id) {
        kisiRepo.deleteById(id);
    }

    @Override
    public List<KisiDTO> tumunuGetir() {
        return modelMapper.map(kisiRepo.findAll(),new TypeToken<List<KisiDTO>>(){}.getType());
    }



}