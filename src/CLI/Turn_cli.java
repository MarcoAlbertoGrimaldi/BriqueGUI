package CLI;

import Logic.AI_Logic;
import Logic.Board;
import Logic.Coordinates;
import Logic.State;

import java.util.ArrayList;

public class Turn_cli {
    private final Game_cli game;

    public Turn_cli(Game_cli game){
        this.game = game;
    }

    public void  playTurn(){

        Coordinates coordinates = null;

        if(game.getCurrent_player().isHuman()) {
            boolean valid_move = false;
            while (!valid_move) {
                coordinates = game.io_interface.getCoordinates(game.getCurrent_player());
                if(game.getCurrent_player().isResigned()) return;
                valid_move = game.controller.areEmpty(game.getBoard(), coordinates);
            }
        } else {
            coordinates = AI_Logic.chooseRandomCoordinates(game.getBoard());
        }

        makeMove(game.getBoard(), coordinates, game.getCurrent_player().getControl().toState());

        ArrayList<Coordinates> escorts = game.rules.escort_rules(game.getBoard(), coordinates, game.getCurrent_player().getControl().toState());

        game.getCurrent_player().getGraph().update_graph(coordinates, game.getBoard());

        for(Coordinates escort : escorts) {
            game.getCurrent_player().getGraph().update_graph(escort, game.getBoard());
            game.getOther_player().getGraph().restore_graph(escort, game.getBoard());
        }

    }

    public void makeMove(Board board, Coordinates coordinates, State piece_colour) {
        board.getCell(coordinates).setState(piece_colour);
    }

}
