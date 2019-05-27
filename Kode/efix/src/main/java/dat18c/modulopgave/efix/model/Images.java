package dat18c.modulopgave.efix.model;
/** This class defines data structure.
 *
 */
public class Images {
    int id;
    String name;
    int top;
    int left;

    public Images() {
    }

    public Images(int id, String name, int top, int left) {
        this.id = id;
        this.name = name;
        this.top = top;
        this.left = left;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}
