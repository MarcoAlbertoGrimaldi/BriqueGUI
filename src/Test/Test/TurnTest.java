package Test;

import Logic.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnTest {


    @Test
    public void check_playTurn(){
        Game game =  set_initial_game();
        Coordinates coordinates = new Coordinates(1, 2);
        Turn turn = new Turn(game, coordinates);
        turn.playTurn();
        assertEquals(game.getBoard().getCell(coordinates).getState(), State.B_PIECE);

    }




    public Game set_initial_game(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");

        return new Game(player1,player2, true);

    }
}
