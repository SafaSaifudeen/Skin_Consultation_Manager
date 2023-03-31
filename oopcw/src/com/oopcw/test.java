package com.oopcw;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner s = new Scanner(System.in);
        String input;
        WestminsterSkinConsultationManager management = new WestminsterSkinConsultationManager();
        do {
            management.printmenu();
            input = s.next().toUpperCase();
            switch (input) {
                case ("A") -> management.addnewdoctor();
                case ("D") -> management.deleteDoctor();
                case ("P") -> management.PrintListofDoc();

                case ("S") -> management.SaveinFile();
                case ("G") -> management.gui();
            }

        }while (!input.equals("Q"));
    }}

