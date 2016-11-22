package authoring.editorview.tower.subviews;

import java.util.ResourceBundle;
import authoring.editorview.tower.TowerEditorView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


/**
 * 
 * @author Diane Hadley
 *
 */

public class NewTowerView {
    private BorderPane root;
    private TowerEditorView towerView;

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringTower";
    private ResourceBundle towerResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    public NewTowerView (TowerEditorView towerView) {
        root = new BorderPane();
        this.towerView = towerView;
        initRoot();

    }

    public Node getRoot () {
        return root;
    }

    private void initRoot () {
        Button newTower = new Button();
        newTower.setText(towerResources.getString("NewTower"));
        newTower.setOnAction( (event) -> {
            towerView.getTowerSetter();
        });
        root.setCenter(newTower);
    }
}
