package ticTacToe.project1;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class Board implements ActionListener  {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    Random random = new Random();
    boolean player1_turn;





    public void gameBoard(){

        //create game board for the application to run
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Forte", Font.BOLD, 50));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.GRAY);

        for(int i = 0 ; i < 9 ; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial Black",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        gameTurnCheck();


    }

    public void gameTurnCheck(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2) == 0){
            player1_turn = true;
            textField.setText("Player turn");

        } else {
            player1_turn = false;
            textField.setText("CPU turn");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int  i = 0 ; i < 9 ; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("CPU turn");
                        check();
                    }
                }else{
                    buttons[i].setForeground(Color.BLUE);
                    buttons[i].setText("O");
                    player1_turn = true;
                    textField.setText("Player turn");
                    check();
                }
            }
        }
    }



    public void check(){
        //wins for X
        if( (buttons[0].getText()=="X") &&
            (buttons[1].getText()=="X") &&
            (buttons[2].getText()=="X")){
                xWins(0,1,2);
        }
        if( (buttons[3].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[5].getText()=="X")){
                xWins(3,4,5);
        }
        if( (buttons[6].getText()=="X") &&
            (buttons[7].getText()=="X") &&
            (buttons[8].getText()=="X")){
                xWins(3,7,8);
        }
        if( (buttons[0].getText()=="X") &&
            (buttons[3].getText()=="X") &&
            (buttons[6].getText()=="X")){
                xWins(0,3,6);
        }
        if( (buttons[1].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if( (buttons[2].getText()=="X") &&
            (buttons[5].getText()=="X") &&
            (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if( (buttons[0].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[8].getText()=="X")){
                xWins(0,4,8);
        }
        if( (buttons[2].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[6].getText()=="X")){
                xWins(2,4,6);
        }

        //wins for O
        if( (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if( (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if( (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(3,7,8);
        }
        if( (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if( (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if( (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if( (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if( (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }

    }

    public void xWins (int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0 ; i < 9 ; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("Player wins");
    }

    public void oWins (int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0 ; i < 9 ; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("CPU wins");
    }

}
