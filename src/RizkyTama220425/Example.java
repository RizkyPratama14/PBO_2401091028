/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RizkyTama220425;

/**
 *
 * @author LENOVO
 */
public class Example {
     public static void main(String[] args) {
        Pegawai pegawai1 = new Pegawai("123456", "John Doe", "1A");
        pegawai1.tampilkanData();

        System.out.println();

        Pegawai pegawai2 = new Pegawai("789012", "Jane Doe", "2A");
        pegawai2.tampilkanData();

        System.out.println();

        Pegawai pegawai3 = new Pegawai("345678", "Bob Smith", "3A");
        pegawai3.tampilkanData();
    }
}

