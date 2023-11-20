import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
������ ������� � �������� �� ����� �����������-����� � ����� �������� � �������� ��� ������������
 ������� ��������� ���������� � �������� �������: JLabel � ���������� ��������� ����� �����,
  ��������������� � ButtonGroup
������������� JRadioButton � ��������� ������� �������� ������ ���������� � �������� ������ ��������,
 JLabel � ���������� ��������� �������
�����, JLabel � ���������� �������������� ������ ����:�, JSlider �� ���������� 3..10,
JLabel � ���������� ��������� ����� ��� �������, JLabel � ���������� �������������� �����:�,
JSlider �� ���������� 3..10.
 */

/*
�������� ����������� ���������������,
� ������, ��� ����������� �������� ��������
� ��������������� ������� ������ ���������� ������� �������� ���������.
��� ����� ���������� ��������
� �������� ��������� ��������� (��� ��� ���� ������� ��� �������� ������).
 */
/*
� ������ ����������� ������� ������ ���������� �������� ��������� � ���������
������ ������ ������ ���� �� ������� ��������� ����������� (����� �����-������
�������, �������� �������� �������� ����, �������� �������� ���������� �����).
*/



public class SettingWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("�������� ����� ����");
    JLabel gameField = new JLabel("������������� ������ ����:");
    JLabel winCount = new JLabel("������������� �����:");
    JSlider fieldSlider = new JSlider(3,10);
    JSlider winLengthSlider = new JSlider(3,10);
    JRadioButton humanVsAi = new JRadioButton("������� ������ ����������");
    JRadioButton humanVsHuman = new JRadioButton("������� ������ ��������");
    ButtonGroup gameModeButtonsGroup = new ButtonGroup();
    JPanel panBottom;

    SettingWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(8, 1));
        gameModeButtonsGroup.add(humanVsAi);
        gameModeButtonsGroup.add(humanVsHuman);
        panBottom.add(gameMode);
        panBottom.add(humanVsAi);
        panBottom.add(humanVsHuman);
        panBottom.add(gameField);
        panBottom.add(fieldSlider);
        panBottom.add(winCount);
        panBottom.add(winLengthSlider);
        panBottom.add(btnStart);
        humanVsAi.setSelected(true);
        fieldSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameField.setText("������������� ������ ����: " + fieldSlider.getValue());
            }
        });
        winLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winCount.setText("������������� �����: " + winLengthSlider.getValue());
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(humanVsAi.isSelected()?0:1,
                        fieldSlider.getValue(),
                        fieldSlider.getValue(),
                        winLengthSlider.getValue());
                setVisible(false);
            }
        });
        add(panBottom);
//        add(btnStart);
    }
}