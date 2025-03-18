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
public class InputTugas4111 {
    public static void main(String[] args) {
        BufferedReader dataIn = new BufferedReader(new  InputStreamReader( System.in));
        int number = 0;
        char letter ='a';
        Boolean result = true;
        String str ="",t="";
        try{ 
        System.out.print("Enter number =");
        number =Integer.parseInt (dataIn.readLine());
        
        System.out.println("Enter letter =");
        t = dataIn.readLine();
        letter = t.charAt(0);
        
        System.out.print("Enter str =");
        str = dataIn.readLine();
          }catch( IOException e ){ 
        System.out.println("Error In getting input!"); 
          } 
        System.out.println("number ="+ number); 
        System.out.println("letter ="+ letter); 
        System.out.println("number ="+ result);
        System.out.println("number ="+ str); 
 } 
}
