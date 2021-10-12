package Objects.Creature.Tiles;

import Extra.Assets;
import Objects.Creature.Tile;

public class TileTree extends Tile{
        public TileTree(int id){
            super(Assets.tree,id);
        }
    @Override
    public boolean isSolid(){
        return true;
    }
}
