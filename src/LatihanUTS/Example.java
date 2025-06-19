/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanUTS;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Example {
   public static void main(String[] args)
    {
        Latihan latihan = new Latihan();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Nama Pegawai: ");
        String nama = scanner.nextLine();
        System.out.println("Masukan Gaji Pokok :");
        double gapok = scanner.nextDouble();
        latihan.cetakgaji();
    }
}
