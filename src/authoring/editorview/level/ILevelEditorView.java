package authoring.editorview.level;

import java.util.List;
import java.util.Map;
import authoring.editorview.IUpdateView;


public interface ILevelEditorView extends ILevelSetView, IUpdateView {

    public void updateEnemy (Map<Integer, Integer> enemyCounts);

    public void updateRewardPoints (double winPoints);

    public void updateRewardHealth (double winHealth);

    public void updateRewardMoney (double winMoney);

    public void updatePath (int pathID);

    public void updateTransitionTime (double time);

    public void updateEnemyFrequency (double enemyFrequency);

    public void updateLevelOptions (List<Integer> levelOptions);

}
