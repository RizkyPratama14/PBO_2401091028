/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RizkyTama180325;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author LENOVO
 */
public class Tugas772JoptionPane {
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nomor = new int[10];

        for (int i = 0; i < 10; i++) {
            String input = JOptionPane.showInputDialog("Masukkan nomor ke-" + (i + 1));
            nomor[i] = Integer.parseInt(input);
        }

        int max = nomor[0];
        for (int i = 1; i < 10; i++) {
            if (nomor[i] > max) {
                max = nomor[i];
            }
        }

        JOptionPane.showMessageDialog(null, "Input terbesar adalah: " + max);
    }

 }
    

