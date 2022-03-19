package PaooGame.Maps;

import PaooGame.RefLinks;

public class MapFactory {
    public Map Factory(RefLinks refLinks, int level){
        switch(level){
            case 1:
                return new Level1Map(refLinks);
            case 2:
                return new Level2Map(refLinks);
            default:
                return null;
        }

        /*if(level == 1){
            return new Level1Map(refLinks);
        }
        else if(level == 2){
            return new Level2Map(refLinks);
        }
        else{
            return new Level1Map(refLinks);
        }*/
    }

}
