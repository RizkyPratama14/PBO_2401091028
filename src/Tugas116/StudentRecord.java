/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas116;

/**
 *
 * @author LENOVO
 */
public class StudentRecord {
    private String nama;
    private int nilai;

    public StudentRecord(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void printRecord() {
        System.out.println("Nama: " + nama);
        System.out.println("Nilai: " + nilai);
    }
}
