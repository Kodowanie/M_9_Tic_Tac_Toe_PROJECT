package ticTacToe.project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Board implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean player1_turn;


    public void gameBoard() {

        //create game board for the application to run the game in
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //create banner uper most with and text "Tic Tac Toe"
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Forte", Font.BOLD, 50));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 600, 100);
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);

        //create buttons for the game to play
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.GRAY);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial Black", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        frame.add(button_panel);

        //check who begin the game
        TurnCheck turnCheck = new TurnCheck();
        turnCheck.gameTurnCheck(this); //finally working

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        CheckWinConditions checkWinConditions = new CheckWinConditions();

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                //game condition player X (Player)
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("CPU turn");
                        //check if wining condition has been meet
                        checkWinConditions.check(this);
                    }
                    //game condition player O (CPU)
                    //add element of CPU playing vs Player
                } else {
                    buttons[i].setForeground(Color.BLUE);
                    buttons[i].setText("O");
                    player1_turn = true;
                    textField.setText("Player turn");
                    //check if wining condition has been meet
                    checkWinConditions.check(this);
                }
            }
        }
    }

}