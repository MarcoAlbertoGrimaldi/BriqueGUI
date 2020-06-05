import CLI.IO_Interface;
import Logic.Launch_Game;

public class Brique {

    public static void main(String[] args) {
        boolean choose_interface = IO_Interface.ChooseInterface();
        Launch_Game game = new Launch_Game(choose_interface);
        game.launch();
    }
}
