package ticTacToe.project2;

import java.awt.*;

public class CheckWinConditions {
    public void check(Board board) {
        //wins for player X
        if ((board.buttons[0].getText() == "X") &&
                (board.buttons[1].getText() == "X") &&
                (board.buttons[2].getText() == "X")) {
            xWins(0, 1, 2, board);
        } else if ((board.buttons[3].getText() == "X") &&
                (board.buttons[4].getText() == "X") &&
                (board.buttons[5].getText() == "X")) {
            xWins(3, 4, 5, board);
        } else if ((board.buttons[6].getText() == "X") &&
                (board.buttons[7].getText() == "X") &&
                (board.buttons[8].getText() == "X")) {
            xWins(3, 7, 8, board);
        } else if ((board.buttons[0].getText() == "X") &&
                (board.buttons[3].getText() == "X") &&
                (board.buttons[6].getText() == "X")) {
            xWins(0, 3, 6, board);
        } else if ((board.buttons[1].getText() == "X") &&
                (board.buttons[4].getText() == "X") &&
                (board.buttons[7].getText() == "X")) {
            xWins(1, 4, 7, board);
        } else if ((board.buttons[2].getText() == "X") &&
                (board.buttons[5].getText() == "X") &&
                (board.buttons[8].getText() == "X")) {
            xWins(2, 5, 8, board);
        } else if ((board.buttons[0].getText() == "X") &&
                (board.buttons[4].getText() == "X") &&
                (board.buttons[8].getText() == "X")) {
            xWins(0, 4, 8, board);
        } else if ((board.buttons[2].getText() == "X") &&
                (board.buttons[4].getText() == "X") &&
                (board.buttons[6].getText() == "X")) {
            xWins(2, 4, 6, board);
        }
        //wins for player O
        if ((board.buttons[0].getText() == "O") && //1
                (board.buttons[1].getText() == "O") &&
                (board.buttons[2].getText() == "O")) {
            oWins(0, 1, 2, board);
        } else if ((board.buttons[3].getText() == "O") && //2
                (board.buttons[4].getText() == "O") &&
                (board.buttons[5].getText() == "O")) {
            oWins(3, 4, 5, board);
        } else if ((board.buttons[6].getText() == "O") && //3
                (board.buttons[7].getText() == "O") &&
                (board.buttons[8].getText() == "O")) {
            oWins(3, 7, 8, board);
        } else if ((board.buttons[0].getText() == "O") && //4
                (board.buttons[3].getText() == "O") &&
                (board.buttons[6].getText() == "O")) {
            oWins(0, 3, 6, board);
        } else if ((board.buttons[1].getText() == "O") && //5
                (board.buttons[4].getText() == "O") &&
                (board.buttons[7].getText() == "O")) {
            oWins(1, 4, 7, board);
        } else if ((board.buttons[2].getText() == "O") && //6
                (board.buttons[5].getText() == "O") &&
                (board.buttons[8].getText() == "O")) {
            oWins(2, 5, 8, board);
        } else if ((board.buttons[0].getText() == "O") && //7
                (board.buttons[4].getText() == "O") &&
                (board.buttons[8].getText() == "O")) {
            oWins(0, 4, 8, board);
        } else if ((board.buttons[2].getText() == "O") && //8
                (board.buttons[4].getText() == "O") &&
                (board.buttons[6].getText() == "O")) {
            oWins(2, 4, 6, board);
        }
        //draw
        for (int i = 0; i < 9; i++) {
            //if there are blank board field and no win condition was achieve, continue the game
            if (board.buttons[i].getText().isBlank()) {
                break;
            }
            //if board is filed and no one wan end the game
            if (i == 8)   {
                board.buttons[i].setEnabled(false);
                board.textField.setText("Draw");
            }
        }
    }
    
    public void xWins(int a, int b, int c, Board board) {
        board.buttons[a].setBackground(Color.GREEN);
        board.buttons[b].setBackground(Color.GREEN);
        board.buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            board.buttons[i].setEnabled(false);
        }
        board.textField.setText("Player wins");
    }

    public void oWins(int a, int b, int c, Board board) {
        board.buttons[a].setBackground(Color.GREEN);
        board.buttons[b].setBackground(Color.GREEN);
        board.buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            board.buttons[i].setEnabled(false);
        }
        board.textField.setText("CPU wins");
    }
}
