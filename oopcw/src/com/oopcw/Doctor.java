package com.oopcw;


public class Doctor extends Person {
    String medicalLicenseNumber ;
    String specialisation;

    public Doctor(String name, String surname, String dateofbirth, String mobileNumber, String medicalLicenseNumber, String specialisation) {
        super(name,surname,dateofbirth,mobileNumber);

        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialisation = specialisation;
    }
    public Doctor(){


    }



    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "Doctor{" +super.toString()+
                "medicalLicenseNumber=" + medicalLicenseNumber +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}