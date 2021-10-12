package GameFiles;

import Objects.Handler;

import java.awt.*;

public abstract class State {
    //protected Game game;
    protected Handler handler;
    private static State currentState=null;
    public static void setState(State state){
        currentState=state;
    }
    public static State getState(){
        return currentState;
    }


    public  State(Handler handler){
        this.handler=handler;

    }
    public abstract void tick();
    public abstract void render(Graphics g);
}
