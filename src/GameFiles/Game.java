package GameFiles;

import Extra.Assets;
import Extra.ImageLoader;
import Extra.KeyManager;
import Extra.SpriteSheet;
import Objects.Creature.Player;
import Objects.Graphics.GameCamera;
import Objects.Handler;
import subbClasses.GameState;
import subbClasses.MenuState;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{

    private Display display;
    private int width,height;
    public String title;
    private boolean running=false;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage testImage,sheetImage,characters,terran;
    private SpriteSheet sheet,sheetChar,sheetTerr;
    ///

    //State
    private State gameState;
    private State menuState;

    private KeyManager keyManager;
    //Camera
    private GameCamera gameCamera;
    //Handler
    private Handler handler;

    public Game(String title, int width,int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager=new KeyManager();
        //Camera


    }
    private void init(){//initialize all the graphics
        display=new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);//

        Assets.init();
        gameCamera=new GameCamera(this,0,0);
        handler=new Handler(this);
        gameState=new GameState(handler);//initialize sub class
        menuState=new MenuState(handler);
        State.setState(gameState);
    }
    private void tick(){
        keyManager.tick();
            if(State.getState()!=null)
                State.getState().tick();
    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width,height);
        // Draw Here      !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        if(State.getState()!=null)
            State.getState().tick();

        gameState.render(g);




        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps =60;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();//returns  nano times that computer is running on
        while (running){//Game Loop to constant refresh graphics
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            lastTime=now;
            long timer=0;
            int ticks=0;
            if(delta>=1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer>=1.000000000){
                System.out.println("Ticks and Frames "+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();

    }
    public synchronized void start(){
        if (running)
            return;
        running=true;
        thread=new Thread(this);//that allows to run the thread on game class
        thread.start();

    }
    public synchronized void stop(){
        if(!running)
            return;//it return and don`t do code belong
        running=false;/// its like safety case
        try {
            thread.join();
        }catch (InterruptedException e)
            {
                e.printStackTrace();
        }

    }
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void Trash(){
        g.drawImage(Assets.grass,500,60,null);
        g.drawImage(Assets.grass,525,60,null);
        g.drawImage(Assets.grass,550,60,null);
        g.drawImage(Assets.grass,550,85,null);
        g.drawImage(Assets.grass,550,110,null);
        g.drawImage(Assets.grass,475,60,null);
        g.drawImage(Assets.grass,450,60,null);
        g.drawImage(Assets.grass,300,60,null);
        g.drawImage(Assets.grass,325,60,null);
        g.drawImage(Assets.stone,250,100,null);

        g.drawImage(sheet.crop(50,50,210,210),445,445,null);
        g.drawImage(testImage,200,220,null);
        g.setColor(Color.red);
        g.fillRect(10,450,50,70);
        g.setColor(Color.gray);
        g.fillRect(30, 50, 80, 15);
        g.fillRect(20, 55, 10, 5);
        g.fillRect(30, 60, 7, 15);
        g.fillRect(39, 60, 5, 15);
        g.fillRect(98, 60, 5, 15);
        g.fillRect(105, 60, 5, 15);
        g.fillRect(105, 40, 13, 13);


        testImage= ImageLoader.loadImage("res/testures/redmark1.png");
        sheetImage=ImageLoader.loadImage("res/testures/spritesheet.png");
        characters=ImageLoader.loadImage("res/testures/characters.png");
        terran=ImageLoader.loadImage("res/testures/map1Terran.png");
        sheet=new SpriteSheet(sheetImage);
        sheetChar=new SpriteSheet(characters);
        sheetTerr=new SpriteSheet(terran);
    }
}
