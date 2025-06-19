/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ervan.model;

/**
 *
 * @author labor p1
 */
public class Anggota {
    private String kodeanggota;
    private String nama;
    private String alamat;
    private String jekel;

    public Anggota() {
    }

    public Anggota(String kodeanggota, String nama, String alamat, String jekel) {
        this.kodeanggota = kodeanggota;
        this.nama = nama;
        this.alamat = alamat;
        this.jekel = jekel;
    }

    public String getKodeanggota() {
        return kodeanggota;
    }

    public void setKodeanggota(String kodeanggota) {
        this.kodeanggota = kodeanggota;
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

    public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }
    
    
}
