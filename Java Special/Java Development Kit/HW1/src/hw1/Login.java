package hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    Login(Chat chat) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(chat.windowPosX, chat.windowPosY);
        //setLocationRelativeTo(chat);
        setSize(chat.windowWidth, chat.windowHeight);
        setTitle("HomeWork");
        setResizable(true);


        JPanel jPanelHello = new JPanel();
        JLabel jLabel = new JLabel("Войдите в систему");
        jPanelHello.add(jLabel);

        JPanel jPanel = new JPanel(new GridLayout(3,1));
        JTextField login = new JTextField();
        JTextField password = new JTextField();
        JButton button = new JButton("Войти");
        jPanel.add(login);
        jPanel.add(password);
        jPanel.add(button);

        add(jPanelHello);
        add(jPanel, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chat.setLogin(login.getText());
                chat.setPassword(login.getText());
                setVisible(false);
                chat.setVisible(true);
            }
        });

        setVisible(true);
    }
}
