/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rizkytama060325;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class InputKeyboardDua {
    public static void main( String[] args ){
    String nama = "";
    nama = JOptionPane.showInputDialog("Please enter your name"); 
    String msg = "Hello " + nama + "!"; 
    JOptionPane.showMessageDialog(null, msg); 
 } 
}