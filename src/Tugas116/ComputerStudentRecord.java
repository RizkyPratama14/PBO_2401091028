/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas116;

/**
 *
 * @author LENOVO
 */
public class ComputerStudentRecord extends StudentRecord {
    private String pengetahuanKomputer;

    public ComputerStudentRecord(String nama, int nilai, String pengetahuanKomputer) {
        super(nama, nilai);
        this.pengetahuanKomputer = pengetahuanKomputer;
    }

    @Override
    public void printRecord() {
        super.printRecord();
        System.out.println("Pengetahuan Komputer: " + pengetahuanKomputer);
    }

    public String getPengetahuanKomputer() {
        return pengetahuanKomputer;
    }
}

