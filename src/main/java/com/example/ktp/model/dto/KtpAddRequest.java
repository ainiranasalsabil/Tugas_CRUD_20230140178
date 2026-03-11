package com.example.ktp.model.dto;

import lombok.Data;
import java.util.Date;

@Data
public class KtpAddRequest {

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;

}
