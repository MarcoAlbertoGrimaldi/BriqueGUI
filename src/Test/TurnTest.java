package Test;

import Logic.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnTest {


    @Test
    public void check_playTurn(){
        Game game =  set_initial_game();
        Coordinates coordinates = new Coordinates(1,2);
        Turn turn = new Turn(game,coordinates);

        ArrayList<Coordinates> c = turn.playTurn();
        assertEquals(game.getBoard().getCell(coordinates).getState(), State.B_PIECE);
        // i grafi e il resto non serve controllarli, perché già gli altri test lo fanno...però chiedo agli altri per sicure<zza

    }




    public Game set_initial_game(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");

        Game game = new Game(player1,player2, true);
        return game;

    }
}
