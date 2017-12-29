package com.dmtrk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;

/**
 * Created by dm on 12/29/17.
 */
public class Producer extends Thread {
    private final Logger log = LoggerFactory.getLogger(getClass().getName()+"@"+hashCode());
    //
    private boolean run = true;

    public Producer(String name) {
        super(name);
        setDaemon(true);
    }

    public void shutdown(){
        this.run = false;
    }

    @Override
    public void run() {
        log.info(this+".run()");
        this.run = true;
        while(run){
            try {
                log.info(this+".run() the time now is: "+ LocalTime.now());
                sleep(5000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
    }
}
