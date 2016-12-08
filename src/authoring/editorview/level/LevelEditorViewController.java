package authoring.editorview.level;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.editorview.path.NameIdPair;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.enemy.EnemyManagerController;
import engine.level.LevelManagerController;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class LevelEditorViewController extends EditorViewController
        implements LevelEditorViewDelegate {

    private ILevelEditorView levelView;
    private LevelManagerController levelDataSource;
    private EnemyManagerController enemyDataSource;
    private int currentLevelID;
    private int currentWaveID;
    private List<NameIdPair> nameIDList;

    public LevelEditorViewController (int editorWidth, int editorHeight) {
        nameIDList = new ArrayList<NameIdPair>();
        levelView = LevelEditorViewFactory.build(editorWidth, editorHeight);
        levelView.setDelegate(this);
        this.view = levelView;
    }

    public void setLevelDataSource (LevelManagerController source) {
        this.levelDataSource = source;
        this.levelDataSource.addTypeBankListener(this.levelView);
        onUserEnteredCreateLevel();
    }

    public void setEnemyDataSource (EnemyManagerController source) {
        this.enemyDataSource = source;
    }

    private void getCreatedEnemies () {
        List<Integer> enemyCreatedIDs = enemyDataSource.getCreatedTypeIds();
        nameIDList.clear();
        for (int id : enemyCreatedIDs) {
            String curName = enemyDataSource.getName(id);
            NameIdPair newPair = new NameIdPair(curName, id);
            nameIDList.add(newPair);
        }
    }

    private List<NameIdPair> getWaveList () {
        getCreatedEnemies();
        return nameIDList;
    }

    @Override
    public void onUserEnteredEditLevel (String level) {
        try {
            Integer.parseInt(level);
            currentLevelID = Integer.parseInt(level);
            currentLevelID = levelDataSource.createType(levelView);
        }
        catch (Exception e) {
            DialogueBoxFactory.createErrorDialogueBox("Not a correct level",
                                                      "Choose an appropriate integer");
        }
    }

    @Override
    public void onUserEnteredLevelName (String levelName) {
        levelDataSource.setName(currentLevelID, levelName);
    }

    @Override
    public void onUserEnteredCreateLevel () {
        currentLevelID = levelDataSource.createType(levelView);
        levelView.updateTransitionTime(levelDataSource.getTransitionTime(currentLevelID));
        levelView.updateRewardHealth(levelDataSource.getRewardHealth(currentLevelID));
        levelView.updateRewardMoney(levelDataSource.getRewardMoney(currentLevelID));
        levelView.updateRewardScore(levelDataSource.getRewardScore(currentLevelID));
        levelView.updateNameDisplay(levelDataSource.getName(currentLevelID));
        levelView.updateEnemyNames(getWaveList());
    }

    @Override
    public void onUserEnteredDeleteLevel () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTransitionTime (String time) {
        try {
            Double.parseDouble(time);
            levelDataSource.setTransitionTime(currentLevelID, Double.parseDouble(time));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyFrequency (String frequency) {
        try {
            Double.parseDouble(frequency);
            levelDataSource.setWaveFrequency(currentLevelID, currentWaveID,
                                             Double.parseDouble(frequency));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredAddWave () {
        currentWaveID = levelDataSource.createWave(currentLevelID, levelView);
        // TODO -Set default values for this created wave
    }

    @Override
    public void onUserEnteredRemoveWave (int waveID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredRewardScore (String score) {
        try {
            Double.parseDouble(score);
            levelDataSource.setRewardScore(currentLevelID, Double.parseDouble(score));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredRewardMoney (String money) {
        try {
            Double.parseDouble(money);
            levelDataSource.setRewardMoney(currentLevelID, Double.parseDouble(money));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredRewardHealth (String health) {
        try {
            Double.parseDouble(health);
            levelDataSource.setRewardHealth(currentLevelID, Double.parseDouble(health));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    private void createIntCheckDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

    @Override
    public void onUserEnteredEnemy (int enemyID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredNumofEnemies (int numEnemies) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredSpawnPoint (int spawnPoint) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWaveTimeDelay (int timeDelay) {
        // TODO Auto-generated method stub

    }
}
