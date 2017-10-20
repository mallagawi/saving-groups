package com.cleansoft.savago.server;

public class SocketServer {
    private final int port;
    private final SocketService service;
    private boolean running;

    public SocketServer(int port, SocketService service) {
        this.port = port;
        this.service = service;
    }

    public SocketService getService() {
        return service;
    }

    public int getPort() {
        return port;
    }

    public void start() {
        running=true;
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        running=false;
    }
}
