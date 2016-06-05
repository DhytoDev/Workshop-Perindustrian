package com.dhytodev.datakemiskinan.model;

import com.orm.SugarRecord;

/**
 * Created by TRIPOD STUDIO on 6/4/2016.
 */
public class Warga extends SugarRecord {
    private Long id ;
    private String nik, nama, alamat, jumlah_anak, penghasilan, tagihan, kategori ;

    public Warga() {
    }

    public Warga(Long id, String nik, String nama, String alamat, String jumlah_anak, String penghasilan, String tagihan, String kategori) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.jumlah_anak = jumlah_anak;
        this.penghasilan = penghasilan;
        this.tagihan = tagihan;
        this.kategori = kategori ;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJumlah_anak() {
        return jumlah_anak;
    }

    public void setJumlah_anak(String jumlah_anak) {
        this.jumlah_anak = jumlah_anak;
    }

    public String getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(String penghasilan) {
        this.penghasilan = penghasilan;
    }

    public String getTagihan() {
        return tagihan;
    }

    public void setTagihan(String tagihan) {
        this.tagihan = tagihan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
