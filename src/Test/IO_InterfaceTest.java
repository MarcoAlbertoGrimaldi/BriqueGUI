package Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IO_InterfaceTest {

    @Test
    public void testInput1() {
        String string = "b1";
        assertTrue(string.matches("[a-o0-9]+"));
    }

}