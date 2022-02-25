package com.company.udp;

import javafx.scene.control.TextArea;

public class Server extends Thread{
    private TextArea serverMsg;
    private boolean aBoolean;
    public Server(TextArea serverMsg) {
        this.serverMsg = serverMsg;
    }


    @Override
    public void run() {
//        for (int i = 0; /*!isInterrupted() && - не работает!!!*/ i < 100; i++) {
        for (int i = 0; !aBoolean && i < 100; i++) {
            serverMsg.appendText(i + "\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public void stopRun(){
        aBoolean = true;
    }
}
