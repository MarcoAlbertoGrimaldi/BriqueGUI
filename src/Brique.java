import GUI.MainMenu;

import javax.swing.*;
import java.io.IOException;

public class Brique {

    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> {
            try {
                new MainMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
