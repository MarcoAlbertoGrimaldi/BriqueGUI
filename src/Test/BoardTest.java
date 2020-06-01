package Test;


import Logic.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void Board_Size() {
        check_dim();
    }

    private void check_dim() {
        Board board = new Board();
        Assertions.assertEquals(15, board.dim);
    }
}
