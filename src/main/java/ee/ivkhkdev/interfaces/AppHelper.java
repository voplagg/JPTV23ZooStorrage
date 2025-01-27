package ee.ivkhkdev.interfaces;

import java.util.List;

public interface AppHelper<T> {
    T create();
    boolean printList(List<T> entities);
    List<T> update(List<T> entitiesForModify);
}
