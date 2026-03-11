package com.example.ktp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ktp")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomor_ktp", nullable = false, unique = true)
    private String nomorKtp;

    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @Column(name = "jenis_kelamin", nullable = false)
    private String jenisKelamin;

}
