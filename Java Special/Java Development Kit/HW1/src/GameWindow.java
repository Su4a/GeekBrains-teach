import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");
    Map map = new Map();
    SettingWindow settingWindow = new SettingWindow(this);

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);
        setVisible(true);

        JPanel panButton = new JPanel(new GridLayout(1,2));
        panButton.add(btnStart);
        panButton.add(btnExit);

        add(panButton, BorderLayout.SOUTH);
        add(map);

        btnStart.addActionListener(e -> settingWindow.setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
