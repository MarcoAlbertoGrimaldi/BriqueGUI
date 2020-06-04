package Test;

import Logic.Settings;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsTest {

    @org.junit.jupiter.api.Test
    void getResolution() {
        assertEquals(Settings.getResolution(), new Dimension(720, 720));
    }

    @org.junit.jupiter.api.Test
    void setResolution() {
        Settings.setResolution(0);
        assertEquals(Settings.getResolution(), new Dimension(480, 480));
    }

    @org.junit.jupiter.api.Test
    void toDimension() {
        assertEquals(new Dimension(720, 720), Settings.toDimension("720x720"));
    }
}
