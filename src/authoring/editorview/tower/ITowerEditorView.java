package authoring.editorview.tower;

import authoring.editorview.IEditorView;


/**
 * The Tower View interface will detail the components of the tower creation. The interface
 * determines a portion of our internal API.
 *
 * @author Kayla Schulz
 */
public interface ITowerEditorView extends IEditorView {

    public void setDelegate (TowerEditorViewDelegate delegate);

    // public int getCurrentTowerID ();

}
