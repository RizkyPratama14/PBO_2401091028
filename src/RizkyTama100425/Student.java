/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RizkyTama100425;

/**
 *
 * @author LENOVO
 */
public class Student extends Person{
    public Student()
    {
        
        System.out.println("Inside Student:Constructor");
    }
    public String getName(){ 
        System.out.println("Parent: getName");  
        return name;  
    }
}
