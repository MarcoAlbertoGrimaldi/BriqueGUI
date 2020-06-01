package Test;


import org.junit.jupiter.api.Test;
import CLI.Display;
import Logic.Board;
import Logic.Coordinates;
import Logic.State;

public class DisplayTest {


    @Test
    public void testDisplay() {
        Display display = new Display();
        Board board = new Board();
        board.getCell(new Coordinates(0,0)).setState(State.B_PIECE);
        board.getCell(new Coordinates(0,8)).setState(State.W_PIECE);
        board.getCell(new Coordinates(10,8)).setState(State.W_PIECE);
        board.getCell(new Coordinates(14,14)).setState(State.B_PIECE);

        display.printBoard(board);
    }

}



