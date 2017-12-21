package com.example.brianr.keuanganhimasif;

import java.util.ArrayList;

/**
 * Created by Brian R on 20/12/2017.
 */

public class mTambah {
    private int id;
    private String judul, tanggal, uang;


    public mTambah(int id, String judul, String tanggal, String uang) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.uang = uang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUang() {
        return uang;
    }

    public void setUang(String uang) {
        this.uang = uang;
    }
}
