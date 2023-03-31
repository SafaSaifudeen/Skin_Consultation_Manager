package com.oopcw;



public  class Person  {
    private String name;
    private String surname;
    private String dateofbirth;
    private String MobileNumber;

    public Person(String name, String surname, String dateofbirth, String mobileNumber) {
        this.name = name;
        this.surname = surname;
        this.dateofbirth = dateofbirth;
        this.MobileNumber = mobileNumber;
    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", MobileNumber=" + MobileNumber +
                '}';
    }
}


