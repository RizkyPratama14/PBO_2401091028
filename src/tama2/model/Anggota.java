/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tama2.model;

/**
 *
 * @author labor p1
 */
public class Anggota {
    private String alamat;
    private String kode;
    private String nama;
    private String jekel;

    public Anggota() {
    }

    public Anggota(String kode, String nama, String alamat, String jekel, String jenis) {
        this.alamat = alamat;
        this.kode = kode;
        this.nama = nama;
        this.jekel = jekel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }
}
