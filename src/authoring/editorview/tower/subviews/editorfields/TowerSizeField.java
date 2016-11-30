package authoring.editorview.tower.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class TowerSizeField implements ITowerSetView {

    private TextField towerSizeField;
    private TowerEditorViewDelegate delegate;

    public TowerSizeField (ResourceBundle labelsResource) {
        towerSizeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate.onUserEnteredTowerSize(towerSizeField
                                                       .getText()));
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerSizeField;
    }

    public void updateTowerSize (String towerSize) {
        towerSizeField.setText(towerSize);
    }

}
