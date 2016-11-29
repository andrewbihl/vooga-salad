package authoring.editorview.enemy;

import java.util.List;
import authoring.editorview.IUpdateView;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface IEnemyUpdateView extends IEnemyEditorView, IUpdateView {

    public void updateEnemyReactions (String enemyReactions);

    public void updateEnemySpeed (double speed);

    public void updateEnemyBank (List<Integer> activeEnemies);

    public void createNewEnemy ();

    public void updateEnemyHealthDisplay (double enemyHealth);

    public void updateEnemyDamage (double damage);

    public void updateEnemyRewardMoney (double rewardMoney);

    public void updateEnemyRewardPoints (double rewardPoints);

    public void updateEnemyCollisionEffect (String collisionEffect);

}
