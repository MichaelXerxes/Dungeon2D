package subbClasses;

import Extra.Assets;
import GameFiles.Game;
import GameFiles.State;
import Objects.Creature.Player;
import Objects.Creature.Tile;
import Objects.Graphics.World;
import Objects.Handler;

import java.awt.*;

public class GameState extends State {
    private Player player;
    private World world;
    private Handler handler;
    public GameState(Handler handler){
        super(handler);

        world=new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
        player=new Player(handler,20,20);

        handler.getGameCamera().move(100,200);

    }
    @Override
    public void tick() {
        world.tick();
        player.tick();


    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        //Tile.tiles[0].render(g,400,400);
        //Tile.tiles[1].render(g,300,20);
        //Tile.tiles[2].render(g,50,300);
        //Tile.tiles[3].render(g,0,0);
        //Tile.tiles[4].render(g,70,70);

    }
}
