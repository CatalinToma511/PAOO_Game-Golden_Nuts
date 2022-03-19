package PaooGame.Menu;

import PaooGame.RefLinks;
import PaooGame.States.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonManager {
    private List<Button> buttonList;
    private int currentButton;
    private final RefLinks refLink;
    private long lastButtonUpdate = 0;

    public ButtonManager(RefLinks refLink, List<Button> buttonList){
        this.refLink = refLink;
        this.buttonList = buttonList;
        currentButton = 0;
    }

    public void Update(){
        if(refLink.getCurrentTime() - lastButtonUpdate > 5 * refLink.getTimeFrame()){
            if(refLink.GetKeyManager().jump){
                currentButton--;
                if(currentButton < 0){
                    currentButton = buttonList.size() - 1;
                }
            }
            else if(refLink.GetKeyManager().down){
                currentButton++;
                if(currentButton >= buttonList.size()){
                    currentButton = 0;
                }
            }
            else if(refLink.GetKeyManager().enter){
                int aux = currentButton; //sa nu-l pierd
                setCurrentButton(0); //reseteaza lista de la inceput
                buttonList.get(aux).doAction();
            }
            lastButtonUpdate = refLink.getCurrentTime();
        }
    }

    public void Draw(Graphics g){
        for (int i = 0; i<buttonList.size(); ++i) {
            buttonList.get(i).Draw(g);
            if(i == currentButton){
                buttonList.get(i).DrawSelected(g);
            }
        }
    }

    public void setCurrentButton(int newIndex){
        currentButton = newIndex;
    }
}
