package Objects.Graphics;

import GameFiles.Game;
import Objects.Creature.Tile;
import Objects.Handler;
import Objects.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private  int width,height;
    private int spanwX,spawnY;
    private int[][] florTiles;
    public World(Handler handler, String path){
        this.handler=handler;
        loadWorld(path);

    }
    public void  loadWorld(String path){
        String file= Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        height=Utils.parseInt(tokens[1]);
        spanwX=Utils.parseInt(tokens[2]);
        spawnY=Utils.parseInt(tokens[3]);


        florTiles=new  int[width][height];
        for(int y=0;y<height;y++) {
            for (int x = 0; x < width; x++) {
                florTiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }



    }
    public void tick(){

    }
    public void render(Graphics g){
        int xStart=(int)Math.max(0,handler.getGameCamera().getxOffset()/Tile.dirttile.getTILEWIDGTH());//changed!!!!
        int xEnd=(int)Math.min(width,(handler.getGameCamera().getxOffset()+handler.getWidth())/65);
        int yStart=(int)Math.max(0,handler.getGameCamera().getyOffset()/64);
        int yEnd=(int)Math.min(height,(handler.getGameCamera().getyOffset()+handler.getHeight())/65);
        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x,y).render(g,(int)(x*64-handler.getGameCamera().getxOffset()),(int)(y*64-handler.getGameCamera().getyOffset()));
            }
        }

    }
    public  Tile getTile(int x,int y){
        if(x<0||y<0||x>=width||y>=height)
            return Tile.grasstile;
        Tile t= Tile.tiles[florTiles[x][y]];
        if(t==null)
            return Tile.rocktile;
        return t;
    }
    public void trash(){
        /*width=6;
        height=6;
        florTiles=new int[width][height];
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                florTiles[x][y]=1;
            }
        }*/
    }
}
