/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rizkytama130325;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class Tugas651JOptionPane {
    public static void main(String[] args) {
        String nilai1Str = JOptionPane.showInputDialog("Masukkan nilai ujian 1: ");
        double nilai1 = Double.parseDouble(nilai1Str);

        String nilai2Str = JOptionPane.showInputDialog("Masukkan nilai ujian 2: ");
        double nilai2 = Double.parseDouble(nilai2Str);

        String nilai3Str = JOptionPane.showInputDialog("Masukkan nilai ujian 3: ");
        double nilai3 = Double.parseDouble(nilai3Str);

        double rataRata = (nilai1 + nilai2 + nilai3) / 3;

        String output = "Nilai rata-rata: " + rataRata;
        if (rataRata >= 60) {
            output += "\n:) ";
        } else {
            output += "\n:-( ";
        }

        JOptionPane.showMessageDialog(null, output);
    }
}
