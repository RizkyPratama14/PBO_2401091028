/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RizkyTama180325;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author LENOVO
 */
public class Tugas772BufferedReader {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nomor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Masukkan nomor ke-" + (i + 1) + ": ");
            nomor[i] = Integer.parseInt(reader.readLine());
        }
        int max = nomor[0];
        for (int i = 1; i < 10; i++) {
            if (nomor[i] > max) {
                max = nomor[i];
            }
        }
        System.out.println("Input terbesar adalah: " + max);
    }
}
