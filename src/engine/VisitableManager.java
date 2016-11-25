package engine;

import engine.observer.Observable;

public interface VisitableManager<E>{

    void accept (VisitorManager visitor, E methodData);
}
