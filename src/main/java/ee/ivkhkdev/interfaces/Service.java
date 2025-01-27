package ee.ivkhkdev.interfaces;

import java.util.List;

public interface Service<T> {
    boolean add();
    boolean print();
    boolean edit();
    boolean remove();
    List<T> list();
    List<T> SortedCustomer();
}
