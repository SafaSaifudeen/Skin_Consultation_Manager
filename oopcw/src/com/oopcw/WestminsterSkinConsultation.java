package com.oopcw;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public int DocCount=0;




    static ArrayList<Doctor> DocList = new ArrayList<Doctor>(10);





    @Override
    public void printmenu() {
        System.out.println("----------Menu----------");
        System.out.println("Add doctor: A ");
        System.out.println("Delete a Doctor: D");
        System.out.println("Print list of doctors: P");
        System.out.println("Save in a file: S");
        System.out.println("Graphical user interface: G");
        System.out.println("Quit :Q");
        System.out.println("-----------------------");

    }

    @Override
    public void addnewdoctor() {
          Scanner s = new Scanner(System.in);

            System.out.println("Enter  Name: ");
            String name = s.nextLine();

            System.out.println("Enter  SurName: ");
            String surname = s.nextLine();

            System.out.println("Enter  Specialization: ");
            String specialization = s.nextLine();


            System.out.println("Enter MobileNo: ");
            String doctorMobileNo = s.nextLine();

            System.out.println("Enter Licence No: ");
            String MeddoctorLicenceNo = s.nextLine();
            System.out.println("Enter date of birth in mm-dd-yyyy format: ");
            String date = s.next();
            Doctor doctor = new Doctor(name,surname,date,doctorMobileNo,MeddoctorLicenceNo,specialization);

            if (DocList.size() < 10){
                DocList.add(doctor);
                System.out.println("Doctor Added sucessfully");
                DocCount++;
            }
            else {
                System.out.println("Maximum number of doctors are 10");
            }
        }




    @Override
    public void deleteDoctor() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a medical license to delete");
        printdoclist();
        String delete= s.next();
        for (Doctor d1 : DocList) {
            if (d1.getMedicalLicenseNumber().equals(delete)) {
                DocList.remove(d1);
                System.out.print("Name;"+d1.getName()+" ");
                System.out.println(d1.getSurname());
                System.out.println("Medical License No:"+d1.getMedicalLicenseNumber());
                System.out.println("Speciallisation:"+d1.getSpecialisation());
                System.out.println("DOB:"+d1.getDateofbirth());
                System.out.println("was deleted");
                DocCount--;
                System.out.println("no.of doctors;"+DocCount);
                return;
            }


        }




    }

    @Override
    public void PrintListofDoc() {
        Collections.sort(DocList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        for (int i = 0; i < DocList.size(); i++) {
            System.out.println(" Name:" + DocList.get(i).getName() +" Surname:"+DocList.get(i).getSurname()+ " MedicalLicence No:" + DocList.get(i).getMedicalLicenseNumber()+" Specialisation:"+DocList.get(i).getSpecialisation()+" Mobile Number"+DocList.get(i).getMobileNumber());
        }
    }






    @Override
    public  void SaveinFile(){
        readFile();
        try(BufferedReader reader = new BufferedReader(new FileReader("Doctors Information"))) {
            String newline;
            while ((newline = reader.readLine()) != null) {
                System.out.println(newline);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void readFile(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Doctors Information"))){

            for (int i = 0; i < DocList.size(); i++) {
                bw.write(DocList.get(i).getName());
                bw.newLine();
                bw.write(DocList.get(i).getSurname());
                bw.newLine();
                bw.write(DocList.get(i).getSpecialisation());
                bw.newLine();
                bw.write(DocList.get(i).getDateofbirth()+"\n");
                bw.newLine();
                bw.write(DocList.get(i).getMobileNumber());
                bw.newLine();
                bw.write(DocList.get(i).getMedicalLicenseNumber());
                bw.newLine();
                bw.write("-----------------------------NEW DOCTOR---------------------");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void gui() throws IOException {




 menu t= new menu();

    }




    public void printdoclist(){

        for (int i = 0; i < DocList.size(); i++) {
            System.out.println(i + 1 + "Name:" + DocList.get(i).getName() +" MedicalLicense No: " + DocList.get(i).getMedicalLicenseNumber());
        }
    }




}


