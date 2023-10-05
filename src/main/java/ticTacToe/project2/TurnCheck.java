package ticTacToe.project2;

import java.util.Random;

public class TurnCheck {
    Random random = new Random();
    public void gameTurnCheck(Board board){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //turn decide by r-p-s ming-game
        if(random.nextInt(2) == 0){
            board.player1_turn = true;
            board.textField.setText("Player turn");

        } else {
            board.player1_turn = false;
            board.textField.setText("CPU turn");
        }
    }
}
