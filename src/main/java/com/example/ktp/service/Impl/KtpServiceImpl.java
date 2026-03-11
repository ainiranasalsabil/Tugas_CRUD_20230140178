package com.example.ktp.service.Impl;

import com.example.ktp.mapper.KtpMapper;
import com.example.ktp.model.dto.KtpAddRequest;
import com.example.ktp.model.dto.KtpDto;
import com.example.ktp.model.entity.Ktp;
import com.example.ktp.repository.KtpRepository;
import com.example.ktp.service.KtpService;
import com.example.ktp.util.ValidationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public KtpDto addKtp(KtpAddRequest request) {

        validationUtil.validate(request);

        Ktp saveKtp = Ktp.builder()
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        ktpRepository.save(saveKtp);

        KtpDto ktpDto = KtpMapper.MAPPER.toKtpDtoData(saveKtp);

        return ktpDto;
    }

    @Override
    public List<KtpDto> getAllKtp() {

        List<Ktp> ktps = ktpRepository.findAll();
        List<KtpDto> ktpDtos = new ArrayList<>();

        for (Ktp ktp : ktps) {
            ktpDtos.add(KtpMapper.MAPPER.toKtpDtoData(ktp));
        }

        return ktpDtos;
    }

    @Override
    public KtpDto getKtpById(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found"));

        return KtpMapper.MAPPER.toKtpDtoData(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpAddRequest request) {

        validationUtil.validate(request);

        Ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found"));

        Ktp ktp = Ktp.builder()
                .id(existingKtp.getId())
                .nomorKtp(request.getNomorKtp())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        ktpRepository.save(ktp);

        return KtpMapper.MAPPER.toKtpDtoData(ktp);
    }

    @Override
    public void deleteKtp(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KTP not found"));

        ktpRepository.delete(ktp);
    }
}
