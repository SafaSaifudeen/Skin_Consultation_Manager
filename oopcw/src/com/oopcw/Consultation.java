package com.oopcw;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Consultation {
    private Patient patient;
    private Doctor doctor;
    private final Date DateOfConsultation;

    private int cost;
    private int consultNo;
    private String notes;
    private File userFile;
    public static ArrayList<Consultation> ConsultationList = new ArrayList<>();
    public Consultation(Patient patient, Doctor doctor, int cost, String notes, int consultNo){
        this.patient = patient;
        this.doctor = doctor;
        this.cost = cost;
        this.notes = notes;
        this.consultNo = consultNo;
        this.DateOfConsultation = new Date();
    }
    public Consultation(Patient patient, Doctor doctor, int cost, String notes, int consultNo, File userFile ){
        this.patient = patient;
        this.doctor = doctor;
        this.cost = cost;
        this.notes = notes;
        this.consultNo = consultNo;
        this.DateOfConsultation = new Date();
        this.userFile = userFile;

    }

    public void setConsultNo(int consultNo) {
        this.consultNo = consultNo;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getConsultationNo() {
        return consultNo;
    }

    public int getConsultationAmount() {
        return cost;
    }

    public Date getConsultationDate() {
        return DateOfConsultation;
    }

    public String getNotes() {
        return notes;
    }



}
