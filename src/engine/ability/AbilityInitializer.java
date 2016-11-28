package engine.ability;

import engine.TypeInitializer;
import engine.observer.ObservableProperty;


public interface AbilityInitializer extends TypeInitializer {

    ObservableProperty<Double> getFireRate ();

    ObservableProperty<String> getEffect ();

}
