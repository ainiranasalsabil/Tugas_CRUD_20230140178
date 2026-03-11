package com.example.ktp.mapper;

import com.example.ktp.model.dto.KtpDto;
import com.example.ktp.model.entity.Ktp;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KtpMapper {

    KtpMapper MAPPER = Mappers.getMapper(KtpMapper.class);

    KtpDto toKtpDtoData(Ktp ktp);

}
