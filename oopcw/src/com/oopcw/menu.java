package com.oopcw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public  class menu extends JFrame {










    public JButton b1,b2,b3;


    public void createButton(){






        b1 =new JButton("View Doctors");
        b2 =new JButton("Book consultation");
        b3 =new JButton("View Consultation !");




        b1.setBackground(new Color(139, 188, 220));
        b1.setOpaque(true);
        b2.setBackground(new Color(139, 188, 220));
        b2.setOpaque(true);
        b3.setBackground(new Color(139, 188, 220));
        b3.setOpaque(true);

        b1.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource()== b1){
                    DoctorTable table = new DoctorTable(WestminsterSkinConsultationManager.DocList);
                    table.setVisible(true);}



            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==b2) {
                    BookConsultation screen= new BookConsultation();

                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==b3){
                    ViewConsultations sc3= new ViewConsultations();
                }
            }
        });

    }
    public menu() throws IOException {






        createButton();
        setLayout(new GridBagLayout());
        add(b1);
        add(b2);
        add(b3);



        GridLayout layout = new GridLayout(3,3,10,40);
        layout.setVgap(50);



        setTitle("GridBag Layout Test");
        setSize(600,600);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       getContentPane().setBackground(new Color(203, 174, 229));










    }
}
