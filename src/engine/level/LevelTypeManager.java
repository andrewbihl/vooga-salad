package engine.level;

import engine.AbstractTypeManager;
import engine.Manager;
import engine.ManagerMediator;
import engine.MethodData;
import engine.Type;
import java.util.List;

/**
 *
 * Created by ezra on 11/17/16.
 */
public class LevelTypeManager extends AbstractTypeManager<Level> implements LevelManager{
    private List<Level> levels;
    
    protected LevelTypeManager (ManagerMediator managerMediator) {
        // TODO Auto-generated constructor stub
    }

}