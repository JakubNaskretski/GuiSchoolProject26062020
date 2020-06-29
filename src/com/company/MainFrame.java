package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    private JButton loadButton;
    private ReadFile readFile;
    DrawShapes drawSquarePanel;
    private JFileChooser fc;

    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setResizable(false);
        setLocationRelativeTo(null);

        fc = new JFileChooser();
         readFile = new ReadFile("C:\\Users\\jnaskretski\\IdeaProjects\\SPRING37\\20200626 GUI2\\src\\com\\company\\testTxt");

        //Set up the content pane.
        try {
            addComponentsToPane();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Display the window.
        pack();
        setVisible(true);
    }

    private void addComponentsToPane() throws IOException {

        //Add button to tha pane
        loadButton = new JButton("Load file");
//        loadButton.addActionListener();

        drawSquarePanel = new DrawShapes(0,0,0,0);

        readFile.readAndDrawShapes(drawSquarePanel);

        add(drawSquarePanel, BorderLayout.CENTER);
        add(loadButton, BorderLayout.PAGE_END);

    }

    private void setPathToFile(){



    }

}
