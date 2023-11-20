package hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Chat extends JFrame {
    final int windowPosX = 300;
    final int windowPosY = 300;
    final int windowWidth = 700;
    final int windowHeight = 400;
    private String login;
    private String password;
    private final ArrayList<String> messages = new ArrayList<>();

    Chat() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(windowPosX, windowPosY);
        setSize(windowWidth, windowHeight);
        setTitle("HomeWork");
        setResizable(true);

        JPanel jPanelAreaMessage = new JPanel();
        JTextArea jTextArea = new JTextArea();
        jPanelAreaMessage.add(jTextArea);

        JPanel jPanelSendMessage = new JPanel(new GridLayout(1, 2));
        JTextField textField = new JTextField();
        JButton buttonSendMessage = new JButton("Send");
        jPanelSendMessage.add(textField);
        jPanelSendMessage.add(buttonSendMessage);

        add(jPanelAreaMessage, BorderLayout.WEST);
        add(jPanelSendMessage, BorderLayout.SOUTH);

        buttonSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.add(textField.getText());
                jTextArea.append(login + ": " + textField.getText() + "\n");
                textField.setText("");
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    messages.add(textField.getText());
                    jTextArea.append(login + ": " + textField.getText() + "\n");
                    textField.setText("");
                }
            }
        });


        if (login == null || password == null) {
            new Login(this);
        } else {
            setVisible(true);
        }
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        new Chat();
    }
}
