package dat18c.modulopgave.efix;


import java.util.List;

public interface Crud<T> {

    List fetchAll();

    T findById(int id);

    void update(T t);

    void addItem(T t);

    void deleteById(int id);
}
