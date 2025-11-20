package com.ejemplo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testaddpositivo() {
        App app = new App();
        assertEquals(5, app.add(2, 3));
    }

    @Test
    public void testAddconcero() {
        App app = new App();
        assertEquals(2, app.add(2, 0));
    }

    @Test
    public void testmain() {
        
        App.main(new String[]{});
    }
}

