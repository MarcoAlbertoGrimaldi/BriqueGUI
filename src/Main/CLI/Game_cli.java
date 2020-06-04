package CLI;

import Logic.*;

import java.util.concurrent.atomic.AtomicBoolean;


public class Game_cli {
    private final Player player_1;
    private final Player player_2;
    private final Board board;
    private int move_counter = 0;
    public Rules rules;
    private final Display display;
    public Controller controller;
    public IO_Interface io_interface;


    public Game_cli(Player player_1, Player player_2, Display display, IO_Interface io_interface) {
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.rules = new Rules();
        board = new Board();
        player_1.setCurrent(true);
        this.display = display;
        this.io_interface = io_interface;
        controller = new Controller();
    }


    public void playGame(){
        if(player_1.isHuman()) display.printBoard(board);
        AtomicBoolean victory = new AtomicBoolean(false);
        while (!victory.get()){
            move_counter++;
            Turn_cli turn = new Turn_cli(this);
            turn.playTurn();
            if(getCurrent_player().isResigned()){
                display.printResignedMessage(this);
                break;
            }
            display.printMove(this);
            display.printBoard(board);
            if(move_counter==1){
                controller.switchPlayer(this);
                boolean pie_bool = io_interface.getPieRule(getCurrent_player());
                controller.apply_pie_rule(this,this.rules,pie_bool);
            }
            if(move_counter >= 28){
                victory.set(controller.check_victory(getCurrent_player().getGraph()));
            }

            controller.switchPlayer(this);
        }
        controller.switchPlayer(this);
        display.printVictoryMessage(this);
    }

    public Player getPlayer_1() {
        return player_1;
    }

    public Player getPlayer_2(){
        return player_2;
    }

    Player getCurrent_player(){
        if (player_1.isCurrent()) return player_1;
        else return player_2;
    }

    Player getOther_player(){
        if (!player_1.isCurrent()) return player_1;
        else return player_2;
    }

    public Board getBoard(){
        return this.board;
    }

    public int getMove_counter() { return move_counter; }
}






