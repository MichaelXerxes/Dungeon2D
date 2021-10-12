package Objects.Creature.Tiles;

import Extra.Assets;
import Objects.Creature.Tile;

public class TileRock extends Tile {
    public TileRock(int id){
        super(Assets.stone,id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
