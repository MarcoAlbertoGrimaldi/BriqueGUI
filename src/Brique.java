import CLI.IO_Interface;
import CLI.Launch_Game_cli;
import Logic.Launch_Game;

public class Brique {

    public static void main(String[] args) {
        IO_Interface io_interface = new IO_Interface();
        String inter_string = io_interface.ChooseInterface();
        if (inter_string == "GUI") {
            Launch_Game game = new Launch_Game();
            game.launch();
        } else {
            Launch_Game_cli game = new Launch_Game_cli();
            game.launch();

        }
    }


}