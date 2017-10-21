package com.novalfakhri.android.jogjapedia;

import android.media.Image;
import android.support.annotation.Nullable;

/**
 * Created by Toshiba on 8/11/2017.
 */

public class Pariwisata {
    private String nama, alamat, detail, gambar;

    public Pariwisata(){

    }

    public Pariwisata(String nama, String alamat, String detail, String gambar) {
        this.nama = nama;
        this.alamat = alamat;
        this.detail = detail;
        this.gambar = gambar;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
