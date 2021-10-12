package Objects.Creature;

import Objects.Creature.Tiles.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //STATIC STUFF HERE
    public static Tile[] tiles=new Tile[256];
    public static Tile grasstile=new TileGrass(0);
    public static Tile rocktile=new TileRock(1);
    public static Tile dirttile=new TileDirt(2);
    public static Tile treetile=new TileTree(3);
    public static Tile watertile=new TileWater(4);
    protected BufferedImage texture;
    protected final int id;
    protected   final int TILEWIDGTH=64,TILEHEIGHT=64;

    public Tile(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;

        tiles[id]=this;

    }
    public void tick(){

    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture,x,y,TILEHEIGHT,TILEHEIGHT,null);
    }
    public boolean isSolid(){
        return false;
    }
    public int getId(){
        return id;
    }

    public int getTILEWIDGTH() {
        return TILEWIDGTH;
    }

    public int getTILEHEIGHT() {
        return TILEHEIGHT;
    }

}
