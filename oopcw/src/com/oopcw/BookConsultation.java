package com.oopcw;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilCalendarModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BookConsultation extends JFrame implements ActionListener {


    String[] DoclistGui = new String[10];
    JList JListOfDoctors = new JList(DoclistGui);

    JTextField patient_Name = new JTextField(10);
    JTextField patient_SurName = new JTextField(10);
    JTextField patient_MobileNumber = new JTextField(10);
    JTextField patient_DOB = new JTextField(10);
    JTextField patient_NIC = new JTextField(10);
    JButton submit = new JButton("Book  Consultation");
    JButton Encrypt = new JButton("Encrypt");
    JTextArea notes = new JTextArea("Enter Notes ");
    JFileChooser FileChoose = new JFileChooser();
    JButton FilesOpen = new JButton("Open Files");

    File selectedFile;
    SpinnerNumberModel numberModel = new SpinnerNumberModel(0, 0, 4, 1);
    JSpinner noofhours = new JSpinner(numberModel);
    String docselected;
    int consultationNo = 0;

    //Getting the list of doctors for the JComboBox
    private void settingList() {
        for (int i = 0; i < WestminsterSkinConsultationManager.DocList.size(); i++) {
            DoclistGui[i] = WestminsterSkinConsultationManager.DocList.get(i).getName();
        }
    }

    BookConsultation() {
        settingList();
        JPanel textField = new JPanel(new GridLayout(10, 2, -10, 5));

        textField.add(new JLabel("Select Doctor:"));
        JComboBox comboBox = new JComboBox(DoclistGui);
        docselected = (String) comboBox.getSelectedItem();
        textField.add(comboBox);

        textField.add(new JLabel("Patient Name:"));
        textField.add(patient_Name);

        textField.add(new JLabel(" SurName:"));
        textField.add(patient_SurName);

        textField.add(new JLabel(" Mobile No:"));
        textField.add(patient_MobileNumber);

        textField.add(new JLabel(" Date Of Birth: "));
        textField.add(patient_DOB);
        ;

        textField.add(new JLabel(" Enter notes here:"));
        textField.add(notes);

        textField.add(new JLabel("  National Identity Card:"));
        textField.add(patient_NIC);

        //Setting Date and time GUI Component
        Properties pr = new Properties();
        pr.put("text.today", "Today");
        pr.put("text.month", "Month");
        pr.put("text.year", "Year");


        UtilCalendarModel model = new UtilCalendarModel();
        JDatePanelImpl jdatePanel = new JDatePanelImpl(model, pr);
        JDatePickerImpl JdatePicker = new JDatePickerImpl(jdatePanel, new DateComponentFormatter());
        textField.add(new JLabel("Select Date For Consultation:"));
        textField.add(JdatePicker);

        textField.add(new JLabel("Number of Hours:"));
        textField.add(noofhours);

        textField.add(new JLabel("Select a file:"));
        FilesOpen.addActionListener(this);
        textField.add(FilesOpen);

        JPanel panelNoTwo = new JPanel();
        submit.addActionListener(this);
        panelNoTwo.add(submit);
        panelNoTwo.add(submit);


        textField.add(Encrypt);
        Encrypt.addActionListener(this::encryptDataActionPerformed);

        textField.add(Encrypt);


        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout(2, 25));
        cp.add(textField, BorderLayout.NORTH);
        cp.add(panelNoTwo, BorderLayout.CENTER);

        setSize(600, 410);
        setResizable(false);
        setVisible(true);
        add(Encrypt,BorderLayout.AFTER_LAST_LINE);
        add(Encrypt,BorderLayout.AFTER_LINE_ENDS);



    }
    private void encryptDataActionPerformed(java.awt.event.ActionEvent evt){
        String text = "";
        String x=notes.getText();
        char[] chars= x.toCharArray();
        for (char c : chars) {
            c+=5;
            text +=c;
//            System.out.println(c);

        }

        try {
            File dataFile = new File("encrypt.txt");
            FileWriter myWriter = new FileWriter(dataFile);


            myWriter.write("notes: " +text);




            myWriter.close();
            System.out.println(" Saved Sucessfully");
        }
        catch (IOException E){
            System.out.println("File not found");
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isSelected = false;
        if (e.getSource() == FilesOpen) {

            FileChoose.setCurrentDirectory(new File("C:\\"));
            FileChoose.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png"));
            FileChoose.setDialogTitle("Select a file");
            int return_Value = FileChoose.showOpenDialog(null);
            if (return_Value == JFileChooser.APPROVE_OPTION) {
                File selectedFile = FileChoose.getSelectedFile();
                isSelected = true;
            }


        }

        if (e.getSource() == submit) {



            if (patient_Name.getText() == "" || patient_Name.getText() == null) {
                this.add(new JPopupMenu("Please Fill !!!"));
            }

            for (int j = 0; j < WestminsterSkinConsultationManager.DocList.size(); j++) {

                if (docselected == WestminsterSkinConsultationManager.DocList.get(j).getName()) {

                    Doctor doctor = WestminsterSkinConsultationManager.DocList.get(j);
//                    int mobileNumber = Integer.parseInt(patientNumber.getText());


                    Patient patient = new Patient(patient_Name.getText(), patient_SurName.getText(), patient_DOB.getText(), patient_MobileNumber.getText(), patient_NIC.getText());

                    if (consultationNo > 0) {
                        int costOfConsultation = (int) noofhours.getValue() * 25;
                        if (isSelected == true) {

                            Consultation consultation = new Consultation(patient, doctor, costOfConsultation, notes.getText(), consultationNo, selectedFile);
                            Consultation.ConsultationList.add(consultation);
                        } else {
                            Consultation consultation = new Consultation(patient, doctor, costOfConsultation, notes.getText(), consultationNo);
                            Consultation.ConsultationList.add(consultation);
                        }

                    } else if (consultationNo == 0) {

                        int CostOfConsultation = (int) noofhours.getValue() * 15;

                        if (isSelected == true) {

                            Consultation consultation = new Consultation(patient, doctor, CostOfConsultation, notes.getText(), consultationNo, selectedFile);
                            Consultation.ConsultationList.add(consultation);
                        } else {
                            Consultation consultation = new Consultation(patient, doctor, CostOfConsultation, notes.getText(), consultationNo);
                            Consultation.ConsultationList.add(consultation);
                        }
                    }
                    consultationNo++;
                }
            }
        }
    }
}
