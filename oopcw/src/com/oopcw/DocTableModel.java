package com.oopcw;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DocTableModel extends AbstractTableModel {
    private String[] columnNames = {"Name", "Surname", "Date", "MobileNumber", "MedicalLicenseNumber", "Specialization"};
    private ArrayList<Doctor> list;
    public DocTableModel(ArrayList<Doctor> personList){
        list = personList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = list.get(rowIndex).getName();
        }
        else if (columnIndex == 1) {
            temp = list.get(rowIndex).getSurname();
        }
        else if (columnIndex == 2) {
            temp= list.get(rowIndex).getDateofbirth();
        }
        else if (columnIndex == 3) {
            temp= list.get(rowIndex).getMobileNumber();

        }
        else if (columnIndex == 4) {
            temp= list.get(rowIndex).getMedicalLicenseNumber();
        }
        else if (columnIndex == 5) {
            temp= list.get(rowIndex).getSpecialisation();
        }
        return temp;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }

}
