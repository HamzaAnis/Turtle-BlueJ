
import java.util.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 */
public class ActionTurtle extends BasicTurtle {

    List<Action> actionList = new ArrayList<Action>();

    public void addAction(Action action) {
        actionList.add(action);
    }

    @Override
    public void move(double dist) {
        super.move(dist);
        for(int i=0;i<actionList.size();i++){
            actionList.get(i).action(this);
        }
    }

}
