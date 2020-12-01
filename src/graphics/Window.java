package graphics;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements ActionListener, KeyListener {

    JPanel pane;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivision;
    JButton buttonMultiplication;
    JButton buttonDivisionWithRemainder;
    JTextField firstNumber;
    JTextField secondNumber;
    JLabel labelFirstNumber;
    JLabel labelSecondNumber;
    JLabel labelResult;

    public Window() {
        init();
    }

    private void init() {
        this.setTitle("Calculator");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = (JPanel) (this.getContentPane());
        this.pane.setBackground(new Color(50, 50, 50));
        this.setLayout(null);

        buttonPlus = new JButton("+");
        buttonPlus.setBounds(0, 400, 100, 50);
        buttonPlus.setBorderPainted(false);
        buttonPlus.setFocusPainted(false);
        buttonPlus.setContentAreaFilled(false);
        buttonPlus.setForeground(Color.WHITE);
        buttonPlus.setFont(new Font("Sherif", Font.PLAIN, 35));

        buttonMinus = new JButton("-");
        buttonMinus.setBounds(100, 400, 100, 50);
        buttonMinus.setBorderPainted(false);
        buttonMinus.setFocusPainted(false);
        buttonMinus.setContentAreaFilled(false);
        buttonMinus.setForeground(Color.WHITE);
        buttonMinus.setFont(new Font("Sherif", Font.PLAIN, 35));

        buttonDivision = new JButton("/");
        buttonDivision.setBounds(200, 400, 100, 50);
        buttonDivision.setBorderPainted(false);
        buttonDivision.setFocusPainted(false);
        buttonDivision.setContentAreaFilled(false);
        buttonDivision.setForeground(Color.WHITE);
        buttonDivision.setFont(new Font("Sherif", Font.PLAIN, 35));

        buttonMultiplication = new JButton("x");
        buttonMultiplication.setBounds(300, 400, 100, 50);
        buttonMultiplication.setBorderPainted(false);
        buttonMultiplication.setFocusPainted(false);
        buttonMultiplication.setContentAreaFilled(false);
        buttonMultiplication.setForeground(Color.WHITE);
        buttonMultiplication.setFont(new Font("Sherif", Font.PLAIN, 35));

        buttonDivisionWithRemainder = new JButton("%");
        buttonDivisionWithRemainder.setBounds(400, 400, 100, 50);
        buttonDivisionWithRemainder.setBorderPainted(false);
        buttonDivisionWithRemainder.setFocusPainted(false);
        buttonDivisionWithRemainder.setContentAreaFilled(false);
        buttonDivisionWithRemainder.setForeground(Color.WHITE);
        buttonDivisionWithRemainder.setFont(new Font("Sherif", Font.PLAIN, 35));

        pane.add(buttonPlus);
        pane.add(buttonMinus);
        pane.add(buttonDivision);
        pane.add(buttonMultiplication);
        pane.add(buttonDivisionWithRemainder);

        firstNumber = new JTextField("");
        firstNumber.setBounds(150, 50, 200, 50);

        secondNumber = new JTextField("");
        secondNumber.setBounds(150, 150, 200, 50);

        pane.add(firstNumber);
        pane.add(secondNumber);

        labelFirstNumber = new JLabel("First number:");
        labelFirstNumber.setBounds(150, 25, 200, 25);
        labelFirstNumber.setFont(new Font("Sherif", Font.ITALIC, 20));
        labelFirstNumber.setForeground(Color.WHITE);

        labelSecondNumber = new JLabel("Second number:");
        labelSecondNumber.setBounds(150, 125, 200, 25);
        labelSecondNumber.setFont(new Font("Sherif", Font.ITALIC, 20));
        labelSecondNumber.setForeground(Color.WHITE);

        labelResult = new JLabel("564986", SwingConstants.CENTER);
        labelResult.setBounds(0, 250, 500, 50);
        labelResult.setFont(new Font("Sherif", Font.BOLD, 20));
        labelResult.setForeground(Color.WHITE);

        pane.add(labelFirstNumber);
        pane.add(labelSecondNumber);
        pane.add(labelResult);

        firstNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    firstNumber.setEditable(true);
                    labelResult.setText("");
                } else {
                    firstNumber.setEditable(false);
                    labelResult.setText("Enter only numeric digits (0-9)");
                }

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    Document doc = firstNumber.getDocument();
                    int position = doc.getLength() - 1;
                    try {
                        doc.remove(position, 1);
                        labelResult.setText("");
                    } catch (BadLocationException ex) {

                    }
                }

                if (e.getKeyCode()==KeyEvent.VK_TAB){
                    firstNumber.setEditable(true);
                    labelResult.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        secondNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    secondNumber.setEditable(true);
                    labelResult.setText("");
                } else {
                    secondNumber.setEditable(false);
                    labelResult.setText("Enter only numeric digits (0-9)");
                }

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    Document doc = secondNumber.getDocument();
                    int position = doc.getLength() - 1;
                    try {
                        doc.remove(position, 1);
                        labelResult.setText("");
                    } catch (BadLocationException ex) {

                    }
                }

                if (e.getKeyCode()==KeyEvent.VK_TAB){
                    secondNumber.setEditable(true);
                    labelResult.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fstNum = Double.parseDouble(firstNumber.getText());
                double scndNum = Double.parseDouble(secondNumber.getText());

                labelResult.setText(String.valueOf(fstNum + scndNum));
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fstNum = Double.parseDouble(firstNumber.getText());
                double scndNum = Double.parseDouble(secondNumber.getText());

                labelResult.setText(String.valueOf(fstNum - scndNum));
            }
        });

        buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fstNum = Double.parseDouble(firstNumber.getText());
                double scndNum = Double.parseDouble(secondNumber.getText());

                labelResult.setText(String.valueOf(fstNum / scndNum));
            }
        });

        buttonMultiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fstNum = Double.parseDouble(firstNumber.getText());
                double scndNum = Double.parseDouble(secondNumber.getText());

                labelResult.setText(String.valueOf(fstNum * scndNum));
            }
        });

        buttonDivisionWithRemainder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fstNum = Double.parseDouble(firstNumber.getText());
                double scndNum = Double.parseDouble(secondNumber.getText());

                labelResult.setText(String.valueOf(fstNum % scndNum));
            }
        });

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
