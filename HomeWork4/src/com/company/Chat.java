package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat {
    private final String[] users = { "Alex" ,"Ivan" ,"Olga"};
    private static String activeUser;

    private JPanel panel1;
    private JButton sendMessageButton;
    private JTextField messageField;
    private JList<String> userList;
    private JTextArea sentMessagesArea;


    public Chat() {
        // Список Пользователей
        DefaultListModel<String> listModel = new DefaultListModel<>();
        userList.setModel(listModel);
        for ( int i = 0; i < users.length; i++ ){
            listModel.addElement(users[i]);
        }

        // Выбор текущего пользователя
        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                activeUser = userList.getSelectedValue();
            }
        });

        // Отпправка сообщений
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sentMessagesArea.append(activeUser + ": " + messageField.getText() + "\n");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat");
        frame.setContentPane(new Chat().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
