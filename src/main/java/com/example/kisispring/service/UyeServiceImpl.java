package com.example.kisispring.service;

import com.example.kisispring.dto.UyeDTO;
import com.example.kisispring.entity.Uye;
import com.example.kisispring.repo.IUyeRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "uyeService")
public class UyeServiceImpl implements IUyeService {

    private IUyeRepo uyeRepo;
    private ModelMapper modelMapper;

    @Autowired
    public UyeServiceImpl(IUyeRepo uyeRepo, ModelMapper modelMapper) {
        this.uyeRepo = uyeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public UyeDTO idyeGoreGetir(Long id) {
        return modelMapper.map(uyeRepo.getById(id), UyeDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UyeDTO uyeKaydet(UyeDTO uye) throws Exception {
        if (uye.getId() != null)
            throw new Exception("Id dolu olamaz");
        Uye u=new Uye();
        u.setAdi(uye.getAdi());
        u.setSoyadi(uye.getSoyadi());
        u.setMail(uye.getMail());
        u.setTcKimlikNo(uye.getTcKimlikNo());

        return modelMapper.map(uyeRepo.save(u), UyeDTO.class);
    }

    @Override
    public UyeDTO uyeGuncelle(UyeDTO uye) throws Exception {
        if(uye.getId() == null)
            throw new Exception("Id Bos Olamaz");
        Uye ug = uyeRepo.getOne(uye.getId());
        if (ug == null)
            throw new Exception("Uye Bulunamadı");
        ug.setAdi(ug.getAdi());
        ug.setSoyadi(ug.getSoyadi());
        ug.setMail(ug.getMail());
        ug.setTcKimlikNo(ug.getTcKimlikNo());


        return modelMapper.map(uyeRepo.save(ug), UyeDTO.class);
    }

    @Override
    public void uyeSil(Long id) {
        uyeRepo.deleteById(id);
    }

    @Override
    public List<UyeDTO> tumunuGetir() {
        return modelMapper.map(uyeRepo.findAll(),new TypeToken<List<UyeDTO>>(){}.getType());
    }
    @Override
    public UyeDTO girisControl(UyeDTO uye) throws Exception {

        Uye ucont = uyeRepo.findByTcKimlikNoAndSifre(uye.getTcKimlikNo(), uye.getSifre());
        if (ucont == null) {
            throw new Exception("Üye bulunamadı");
        }
        return modelMapper.map(ucont, UyeDTO.class);


    }


}



