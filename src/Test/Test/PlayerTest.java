package Test;

import Logic.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void AI_player() {
        Player AI_player = new Player(PieceColor.WHITE);
        assertFalse(AI_player.isHuman());
        assertEquals(PieceColor.WHITE, AI_player.getControl());
    }

    @Test
    public void check_name(){
        Player player = new Player(PieceColor.WHITE,"player_1");
        assertTrue(player.isHuman());
        assertEquals(player.getName(),"player_1");
    }


}
