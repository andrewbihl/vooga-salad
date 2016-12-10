package engine.effect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import engine.Manager;


public interface EffectManager extends Manager<Effect> {

    List<Method> getAnnotatedClassMethods (String className);

    List<String> getAnnotatedClasses ();

}
