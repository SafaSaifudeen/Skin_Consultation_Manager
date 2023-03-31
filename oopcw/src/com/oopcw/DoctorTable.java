package com.oopcw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DoctorTable extends JFrame {
    JTable myTable;
    DocTableModel tableModel;
    ArrayList<Doctor> list;






    // constructor
    public DoctorTable(ArrayList<Doctor> list){
        this.list=list;
        tableModel = new DocTableModel(list);
        myTable =  new JTable(tableModel);

        setBounds(10,10,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(380,280));

        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        add(panel1,BorderLayout.EAST);








    }

}

