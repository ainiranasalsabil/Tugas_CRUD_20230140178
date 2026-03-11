package com.example.ktp.service;

import com.example.ktp.model.dto.KtpAddRequest;
import com.example.ktp.model.dto.KtpDto;

import java.util.List;

public interface KtpService {

    KtpDto addKtp(KtpAddRequest request);
    List<KtpDto> getAllKtp();
    KtpDto getKtpById(Integer id);
    KtpDto updateKtp(Integer id, KtpAddRequest request);
    void deleteKtp(Integer id);

}
