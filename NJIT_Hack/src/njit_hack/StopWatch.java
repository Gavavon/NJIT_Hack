/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njit_hack;

/**
 *
 * @author janka
 */
public class StopWatch extends NJIT_Hack {

    private long Start = 0;
    private long End = 0;
    private long elapsed = 0;
    private boolean run = false;
    private long end = 0;
    

    public void start(){
        this.Start = actualClock;
        this.run = true;
    }
    
    
    public long getStart() {
        return Start;
    }

 

    public boolean isRun() {
        return run;
    }

    public void setStart(long Start) {
        this.Start = Start;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public long getElapsed() { 
        end = System.currentTimeMillis()- kingCrimson;
        elapsed = end - Start;
        return elapsed;
        pokemon;
    }
    //i am legend
}

