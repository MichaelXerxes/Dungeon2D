package Objects.Creature;

import GameFiles.Game;
import Objects.Creature.Tiles.TileGrass;
import Objects.Entity;
import Objects.Handler;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_WIDTH=64;
    public static final int DEFAULT_HEIGHT=64;
    protected int health;
    protected float speed;
    protected float xMove,yMove;
    protected Tile tile;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y,width,height);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
        tile=new TileGrass(0);//!!!!!!!!!!!!!!!!!!!!!!!!
    }
    public void move(){
        moveX();
        moveY();

    }
    public void moveX(){
        if(xMove>0){//Move right
            int tx=(int)(x+xMove+bounds.x+bounds.width)/ tile.TILEWIDGTH;
            if(!collisionWithTile(tx,(int)(y+ bounds.y)/tile.TILEHEIGHT)&&
            !collisionWithTile(tx,(int)(y+ bounds.y+ bounds.height)/ tile.TILEHEIGHT)){
                x+=xMove;
            }else{
                x=tx* tile.TILEWIDGTH- bounds.x- bounds.width-1;
            }

        }else if(xMove<0) {//Moving left
            int tx=(int)(x+xMove+bounds.x)/64;
            if(!collisionWithTile(tx,(int)(y+ bounds.y)/64)&&
                    !collisionWithTile(tx,(int)(y+ bounds.y+ bounds.height)/64)){
                x+=xMove;
            }else{
                x=tx* tile.TILEWIDGTH+ tile.TILEWIDGTH- bounds.x;
            }
        }
    }
    public void moveY(){
        if(yMove<0){//Up
            int ty=(int)(y+yMove+ bounds.y/ tile.TILEHEIGHT);
            if(!collisionWithTile((int)(x+bounds.x)/ tile.TILEWIDGTH,ty)&&
            !collisionWithTile((int)(x+bounds.x+bounds.width)/ tile.TILEWIDGTH,ty)){
            y+=yMove;
            }else{
                y=ty* tile.TILEHEIGHT+ tile.TILEHEIGHT- bounds.y;
            }
        }else if (yMove>0){//Down
            int ty=(int)(y+yMove+ bounds.y+bounds.height/ tile.TILEHEIGHT);
            if(!collisionWithTile((int)(x+bounds.x)/ tile.TILEWIDGTH,ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/ tile.TILEHEIGHT,ty)){
                y+=yMove;
            }else{
                y=ty* tile.TILEHEIGHT- bounds.y- bounds.height-1;
            }
        }
    }
protected boolean collisionWithTile(int x,int y){
        return handler.getWorld().getTile(x,y).isSolid();
}
    public float getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }
}
