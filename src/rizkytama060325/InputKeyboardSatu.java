/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rizkytama060325;
import java.io.*;
/**
 *
 * @author LENOVO
 */
public class InputKeyboardSatu {
    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new  InputStreamReader( System.in));
        String nama =""; 
        try{ 
        nama = dataIn.readLine(); 
          }catch( IOException e ){ 
        System.out.println("Error In getting input!"); 
          } 
        System.out.println("Hello " + nama); 
 } 
}

