/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rizkytama130325;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Tugas654DoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        double angka = scanner.nextDouble();

        System.out.print("Masukkan pangkat: ");
        int pangkat = scanner.nextInt();

        double hasil = 1;
        int i = 1;
        do {
            hasil *= angka;
            i++;
        } while (i <= pangkat);

        System.out.println(angka + " pangkat " + pangkat + " = " + hasil);
    }
}
