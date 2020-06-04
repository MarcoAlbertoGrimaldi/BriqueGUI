package CLI;

import Logic.PieceColor;
import Logic.Player;

import java.util.concurrent.atomic.AtomicBoolean;

public class Launch_Game_cli {

    public Launch_Game_cli(){}

    public void launch(){
        IO_Interface io_interface = new IO_Interface();
        Player player1, player2;
        Display display = new Display();
        Menu menu = new Menu();
        AtomicBoolean exit = new AtomicBoolean(false);
        while (!exit.get()){
            display.printMenu(menu);
            int s = io_interface.getMenuChoice();

            switch(s) {
                case 0:
                    player1 = new Player(PieceColor.BLACK, io_interface.getName(PieceColor.BLACK));
                    System.out.println();
                    player2 = new Player(PieceColor.WHITE, io_interface.getName(PieceColor.WHITE));
                    System.out.println();
                    Game_cli gameHum = new Game_cli(player1,player2, display, io_interface);
                    gameHum.playGame();
                    break;
                case 1:
                    player1 = new Player(PieceColor.BLACK);
                    System.out.println();
                    player2 = new Player(PieceColor.WHITE, io_interface.getName(PieceColor.WHITE));
                    System.out.println();
                    Game_cli gameAI = new Game_cli(player1,player2, display, io_interface);
                    gameAI.playGame();
                    break;
                case 2:
                    exit.set(true);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        }
        System.out.println("Bye!");
    }
}

