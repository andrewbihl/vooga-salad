package gameauthoringenvironment.view.createscene.editortabpane;

import javafx.scene.Node;

public interface IEditorTabPane {

    public Node getInstanceAsNode();
    public void setDelegate(EditorTabPaneDelegate delegate);
}
