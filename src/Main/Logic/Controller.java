package Logic;

import CLI.Game_cli;

public class Controller {



    public Controller() {
    }

    public void switchPlayer(Game game) {
        if (game.getPlayer_1().isCurrent()) {
            game.getPlayer_1().setCurrent(false);
            game.getPlayer_2().setCurrent(true);
        } else {
            game.getPlayer_1().setCurrent(true);
            game.getPlayer_2().setCurrent(false);
        }
    }


     public void switchPlayer(Game_cli game) {

         if (game.getPlayer_1().isCurrent()) {
             game.getPlayer_1().setCurrent(false);
             game.getPlayer_2().setCurrent(true);
         } else {
             game.getPlayer_1().setCurrent(true);
             game.getPlayer_2().setCurrent(false);
         }
     }

     public void swapGraphs(Player p1, Player p2) {
         Graph temp = p1.getGraph();
         p1.setGraph(p2.getGraph());
         p2.setGraph(temp);
     }


    public boolean check_victory(Graph graph) {
        return graph.pathFound(225, 226);
    }

    public boolean areEmpty(Board board, Coordinates coordinates) {
        return board.getCell(coordinates).getState() == State.EMPTY;
    }

     public void swapControl(Player p1, Player p2) {
         PieceColor temp = p1.getControl();
         p1.setControl(p2.getControl());
         p2.setControl(temp);
     }


    public void apply_pie_rule(Game_cli game, Rules rules, boolean pie_bool) {

        if (pie_bool) {
            rules.Pie_rule_cli(game.getPlayer_1(), game.getPlayer_2());
            swapGraphs(game.getPlayer_1(), game.getPlayer_2());
        } else {
            switchPlayer(game);
        }
    }


}