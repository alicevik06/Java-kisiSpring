package com.example.kisispring.service;

import com.example.kisispring.dto.KullaniciDTO;
import com.example.kisispring.entity.Kullanici;
import com.example.kisispring.repo.IKullaniciRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "kullaniciService")
public class KullaniciServiceImpl implements IKullaniciService {
    private IKullaniciRepo kullaniciRepo;
    private ModelMapper modelMapper;

    @Autowired
    public KullaniciServiceImpl(IKullaniciRepo kullaniciRepo, ModelMapper modelMapper) {
        this.kullaniciRepo = kullaniciRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public KullaniciDTO idyeGoreGetir(Long id) {
        return modelMapper.map(kullaniciRepo.getById(id), KullaniciDTO.class);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public KullaniciDTO kullaniciKaydet(KullaniciDTO kullanici) throws Exception {

        if (kullanici.getId() != null)
            throw new Exception("Id dolu olamaz");

        Kullanici k = modelMapper.map(kullanici, Kullanici.class);
        return modelMapper.map(kullaniciRepo.save(k), KullaniciDTO.class);
    }

    @Override
    public KullaniciDTO kullaniciGuncelle(KullaniciDTO kullanici) throws Exception {
        if (kullanici.getId() == null)
            throw new Exception("Id Bos Olamaz");
        Kullanici yg = kullaniciRepo.getOne(kullanici.getId());
        if (yg == null)
            throw new Exception("Kullanici Bulunamadı");

        Kullanici y = modelMapper.map(kullanici, Kullanici.class);
        return modelMapper.map(kullaniciRepo.save(y), KullaniciDTO.class);
    }

    @Override
    public void kullaniciSil(Long id) {
        kullaniciRepo.deleteById(id);
    }

    @Override
    public List<KullaniciDTO> tumunuGetir() {
        return modelMapper.map(kullaniciRepo.findAll(), new TypeToken<List<KullaniciDTO>>() {
        }.getType());
    }

    @Override
    public KullaniciDTO girisControl(KullaniciDTO kullanici) throws Exception {
        if (kullanici.getKullaniciAdi() == null && kullanici.getParola() == null) {
            throw new Exception("Lütfen Kullanıcı adı ve Şifre giriniz!");
        }
        Kullanici ycont = kullaniciRepo.findByKullaniciAdiAndParola(kullanici.getKullaniciAdi(), kullanici.getParola());
        if (ycont == null) {
            throw new Exception("Kullanici bulunamadı");
        }
        return modelMapper.map(ycont, KullaniciDTO.class);


    }

    @Override
    public Kullanici findByKullaniciAdi(String kullaniciAdi) throws Exception {

        Kullanici ycont = kullaniciRepo.findByKullaniciAdi(kullaniciAdi);
        if (ycont != null) {
            return modelMapper.map(ycont, Kullanici.class);

        }
        return null;


    }

}
