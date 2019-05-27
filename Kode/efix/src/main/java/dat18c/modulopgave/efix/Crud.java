package dat18c.modulopgave.efix;


import java.util.List;

/** This class is an CRUD Interface that gets implemented in All Service and Repository classes.
 *
 * @param <T> Is a generic variable.
 */
public interface Crud<T> {

    /**
     *This method returns all entrees from database.
     * @return This method returns all entrees from database.
     */
    List fetchAll();

    /**
     *This method returns one id.
     * @param id variable find all ids from Database.
     * @return This method returns one id.
     */
    T findById(int id);

    /**
     * This method updates database entrees.
     *
     * @param t variable takes a generic class as parameter.
     *
     */
    void update(T t);

    /**
     * This method adds a new entry to database.
     *
     * @param t variable takes a generic class as parameter.
     */
    void addItem(T t);

    /**
     * This method deletes a specific id from Database.
     * @param id variable deletes a selected id .
     */

    void deleteById(int id);
}
