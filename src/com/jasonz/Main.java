package com.jasonz;

import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Main extends JFrame {

    private JTextField chatBox = new JTextField();
    private JTextArea chatArea = new JTextArea();

    private JScrollPane pane = new JScrollPane(chatArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JButton clear = new JButton("Clear chat");


    String userName;

    public Main() {
        //Frame attributes
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Java AI");
        this.add(pane);
        this.add(chatBox);
        this.add(clear);
        this.setVisible(true);

        //chat area
        chatArea.setSize(550,400);
        boxArea("Please tell me your name");

        //pane
        pane.setSize(550,400);
        setLayout(null);
        pane.setLocation(25,10);

        //clear button
        clear.setSize(100,30);
        clear.setLocation(250,450);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatArea.setText("");
            }
        });
        //chat box
        chatBox.setSize(550,30);
        chatBox.setLocation(25, 410);
        chatBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gtext = chatBox.getText();
                if (userName == null) {
                    userName = gtext;
                    boxArea("Hello " + userName);
                    chatBox.setText("");
                } else {

                    chatArea.append(userName + " ->" + gtext + "\n");
                    chatBox.setText("");

                    if (gtext.toLowerCase().contains("hi")) {
                        int rand = (int) (Math.random() * 2 + 1);

                        switch (rand) {
                            case 1:
                                boxArea("HI ");
                                break;
                            case 2:
                                boxArea("Hey " + userName);
                        }


                    } else if(gtext.toLowerCase().contains("whats my name")){
                        int rand = (int)(Math.random()*2 +1);

                        switch(rand){
                            case 1:
                                boxArea("Your name is " + userName);
                                break;
                            case 2:
                                boxArea("I think its " + userName +", but I'm not sure");
                                break;
                        }
                    }
                        else {
                        int rand = (int) (Math.random() * 3 + 1);

                        switch (rand) {
                            case 1:
                                boxArea("I didnt get that, please try again");
                                break;
                            case 2:
                                boxArea("My master has not programmed me to understand that phrase, please try again");
                                break;
                            case 3:
                                boxArea("Please put that into terms I can understand");
                        }
                    }
                }
            }
        });
    }

    public void boxArea(String aiSpeak){
        chatArea.append("AI ->" + aiSpeak + "\n");
    }

    public static void main(String[] args) {
        new Main();

    }
}
