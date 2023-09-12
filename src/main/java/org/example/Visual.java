package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Arrays;

public class Visual extends Frame implements ActionListener, MouseWheelListener {
    TextField tf1;
    TextField tf2;

    TextField[][] tf;
    Button btn1;


    Visual(){
        tf1 = new TextField();
        tf1.setBounds(50, 50, 40, 20);
        tf2 = new TextField();
        tf2.setBounds(100, 50, 40, 20);

        tf = new TextField[8][8];
        int x = 50;
        int y = 100;
        int width = 50;
        int height = 50;
        for (int i = 0; i < tf.length; i++) {
            for (int j = 0; j < tf[i].length; j++) {
                tf[i][j] = new TextField();
                tf[i][j].setBounds(x, y, width, height);
                x += 60;
            }
            x = 50;
            y += 60;
        }

        btn1 = new Button("Start");
        btn1.setBounds(150, 50, 80, 20);

        add(tf1);
        add(tf2);
        add(btn1);
        addadd(tf);

        setSize(570, 620);
        setTitle("KnightHorse");
        setLayout(null);
        setVisible(true);

        btn1.addActionListener(this);
        btn1.addMouseWheelListener(this);
    }

    private void addadd(TextField[][] tf) {
        for (int i = 0; i < tf.length; i++) {
            for (int j = 0; j < tf[i].length; j++) {
                add(tf[i][j]);
            }
        }
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Color red = new Color(250, 41, 91);
        this.btn1.setBackground(red);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Color green = new Color(125, 234, 115);
        Color red = new Color(250, 41, 91);
        this.btn1.setBackground(green);
        int[][] field = new int[8][8];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        try {
            KnightHorse.goHorse(field, Integer.parseInt(tf1.getText()), Integer.parseInt(tf2.getText()), 0);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        int count = 1;
        int indexi = 0;
        int indexj = 0;
        while (count < 65) {
            b1: for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == count) {
                        tf[i][j].setText(String.valueOf(field[i][j]));
                        tf[i][j].setBackground(red);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                             throw new RuntimeException(ex);
                        }
                        tf[i][j].setBackground(green);
                        count++;
                        break b1;
                    }
                }
            }
        }
//        for (int i = 0; i < tf.length; i++) {
//            for (int j = 0; j < tf[i].length; j++) {
//                tf[i][j].setText(String.valueOf(field[i][j]));
//                tf[i][j].setBackground(red);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//                tf[i][j].setBackground(green);
//            }
//        }
    }


}
