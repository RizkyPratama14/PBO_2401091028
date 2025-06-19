/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanUTS;
public class Latihan {
    String nama;
    double gapok;
    double tjabatan;
    double tkesehatan;
    double ppajak;

    public void Latihan()
    {
    }
    
    public double totalgaji()
    {
        return gapok + tjabatan + tkesehatan;
    }
    public double ppajak()
    {
        return totalgaji() * 0.05;
    }
    public double gajibersih()
    {
        return totalgaji() - ppajak();
    }
    
    public void cetakgaji()
    {
        System.out.println("Nama = " + nama);
        System.out.println("Gaji Pokok =" + gapok);
        System.out.println("Tunjangan Jabatan: Rp " + tjabatan);
        System.out.println("Tunjangan Kesehatan: Rp " + tkesehatan);
        System.out.println("Total Gaji: Rp " + totalgaji());
        System.out.println("Potongan Pajak: Rp " + ppajak());
        System.out.println("Gaji Bersih: Rp " + gajibersih());

    }
}
