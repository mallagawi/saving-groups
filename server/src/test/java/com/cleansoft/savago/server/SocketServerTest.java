package com.cleansoft.savago.server;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SocketServerTest {

    private SocketServer server;
    private SocketService service;
    private int port;

    @Before
    public void setUp() throws Exception {
        service = new SocketServiceMock();
        port = 8020;
        server = new SocketServer(port, service);
    }

    @Test
    public void canCreate() {
        assertEquals(port, server.getPort());
        assertEquals(service, server.getService());
    }

    @Test
    public void whenStart_thenRunningIsTrue() {
        server.start();
        assertTrue(server.isRunning());
    }


    @Test
    public void whenStartAndStop_thenRunningIsFalse() {
        server.start();
        server.stop();
        assertFalse(server.isRunning());
    }



    private class SocketServiceMock implements SocketService {
    }
}
