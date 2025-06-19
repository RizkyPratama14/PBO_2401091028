/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ervan100425;

/**
 *
 * @author labor p1
 */
public class Student extends Person {

    public Student() {
//        super("Ani","Bukittinggi");
        super.name = "Ani";
        super.address = "Budi";
        System.out.println("Inside Student:Constructor");
    }

    @Override
    public String getName() {
        System.out.println("Student: getName");
        return name;
    }
}
