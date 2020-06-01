package Test;

import Logic.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    @Test
    public void Check_check_victory() {
        Graph white_graph = new Graph(PieceColor.WHITE);
        Graph black_graph = new Graph(PieceColor.BLACK);
        Board white_board = new Board();
        Board black_board = new Board();
        for (int i = 0; i < 15; i = i + 1) {
            Coordinates horizontal_coordinates = new Coordinates(1, i);
            Coordinates vertical_coordinates = new Coordinates(i, 1);
            white_board.getCell(horizontal_coordinates).setState(State.W_PIECE);
            white_graph.update_graph(horizontal_coordinates, white_board);
            black_board.getCell(vertical_coordinates).setState(State.B_PIECE);
            black_graph.update_graph(vertical_coordinates, black_board);


        }
        Controller controller = new Controller();
        assertTrue(controller.check_victory(white_graph));
        assertTrue(controller.check_victory(black_graph));
    }

    @Test
    public void check_switchPlayer(){
        Game game = set_initial_game();
        Controller controller = new Controller();
        controller.switchPlayer(game);
        assertEquals(game.getCurrent_player(),game.getPlayer_2());
    }

    @Test
    public void check_areEmpty(){
        Controller controller = new Controller();
        Board board = new Board();
        Coordinates coordinates = new Coordinates(1, 2);
        assertTrue(controller.areEmpty(board,coordinates));
    }

    @Test
    public void check_swapGraphs(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");
        Controller controller = new Controller();
        Graph player1_graph = player1.getGraph();
        controller.swapGraphs(player1,player2);
        assertEquals(player1_graph,player2.getGraph());
    }







    public Game set_initial_game(){
        Player player1 = new Player(PieceColor.BLACK, "Human");
        Player player2 = new Player(PieceColor.WHITE, "Human_2");
        Game game = new Game(player1,player2, true);
        return game;

    }

}
