package authoring.editorview.collisioneffects;

/**
 * 
 * @author Kayla Schulz
 *
 */
public interface EffectAuthoringViewDelegate {

    public void onUserSelectedAvailableClass (String selectedClass);

    public void onUserSelectedEffectName (String name);

    public void onUserEnteredCondition (String condition);

    public void onUserSelectedEffect (String effect);
}