package com.oopcw;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewConsultations  extends JFrame {

    ArrayList<Consultation> consultations = Consultation.ConsultationList;

    private String[] column_Names = {"Consultation No", "Consultation Amount", "Patient Name", "Patient NIC", "Assigned Doctor"};



    ViewConsultations(){
        JTable table = new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return consultations.size();
            }

            @Override
            public int getColumnCount() {
                return column_Names.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Object temp = null;
                if(columnIndex == 0){ //
                    temp = consultations.get(rowIndex).getConsultationNo();

                }
                else if(columnIndex == 1){ //
                    temp = consultations.get(rowIndex).getConsultationAmount();

                }
                else if(columnIndex == 2){ //
                    temp = consultations.get(rowIndex).getPatient().getName();

                }
                else if(columnIndex == 3){ //
                    temp = consultations.get(rowIndex).getPatient().getId();

                }
                else if(columnIndex == 4){ //
                    temp = consultations.get(rowIndex).getDoctor().getName();

                }


                return temp;
            }
            public String getColumnName(int col){
                return column_Names[col];
            }
        });

        JScrollPane viewConsultationsTable = new JScrollPane(table);
        getContentPane().setBackground(new Color(203, 174, 229));

        this.add(viewConsultationsTable);
        this.setSize(500,500);
        this.setVisible(true);

    }

}
