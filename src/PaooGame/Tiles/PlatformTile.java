package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PlatformTile extends Tile{

    public PlatformTile(int id)
    {
        super(Assets.platform, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
