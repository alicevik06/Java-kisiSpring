package com.example.kisispring.service;

import com.example.kisispring.dto.YetkiliDTO;
import com.example.kisispring.entity.Yetkili;
import com.example.kisispring.repo.IYetkiliRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "yetkiliService")
public class YetkiliServiceImpl implements IYetkiliService {
    private IYetkiliRepo yetkiliRepo;
    private ModelMapper modelMapper;

    @Autowired
    public YetkiliServiceImpl(IYetkiliRepo yetkiliRepo, ModelMapper modelMapper) {
        this.yetkiliRepo = yetkiliRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public YetkiliDTO idyeGoreGetir(Long id) {
        return modelMapper.map(yetkiliRepo.getById(id), YetkiliDTO.class);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public YetkiliDTO yetkiliKaydet(YetkiliDTO yetkili) throws Exception {

        if (yetkili.getId() != null)
            throw new Exception("Id dolu olamaz");

        Yetkili k = modelMapper.map(yetkili, Yetkili.class);
        return modelMapper.map(yetkiliRepo.save(k), YetkiliDTO.class);
    }

    @Override
    public YetkiliDTO yetkiliGuncelle(YetkiliDTO yetkili) throws Exception {
        if (yetkili.getId() == null)
            throw new Exception("Id Bos Olamaz");
        Yetkili yg = yetkiliRepo.getOne(yetkili.getId());
        if (yg == null)
            throw new Exception("Yetkili Bulunamadı");

        Yetkili y = modelMapper.map(yetkili, Yetkili.class);
        return modelMapper.map(yetkiliRepo.save(y), YetkiliDTO.class);
    }

    @Override
    public void yetkiliSil(Long id) {
        yetkiliRepo.deleteById(id);
    }

    @Override
    public List<YetkiliDTO> tumunuGetir() {
        return modelMapper.map(yetkiliRepo.findAll(), new TypeToken<List<YetkiliDTO>>() {
        }.getType());
    }

    @Override
    public YetkiliDTO girisControl(YetkiliDTO yetkili) throws Exception {
        if (yetkili.getKullaniciAdi() == null && yetkili.getParola() == null) {
            throw new Exception("Lütfen Kullanıcı adı ve Şifre giriniz!");
        }
        Yetkili ycont = yetkiliRepo.findByKullaniciAdiAndParola(yetkili.getKullaniciAdi(), yetkili.getParola());
        if (ycont == null) {
            throw new Exception("Yetkili bulunamadı");
        }
        return modelMapper.map(ycont, YetkiliDTO.class);


    }

    @Override
    public Yetkili findByKullaniciAdi(String kullaniciAdi) throws Exception {

        Yetkili ycont = yetkiliRepo.findByKullaniciAdi(kullaniciAdi);
        if (ycont != null) {
            return modelMapper.map(ycont, Yetkili.class);

        }
        return null;


    }

}
