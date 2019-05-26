package dat18c.modulopgave.efix.model;

public class Calculator {

    private int tal;
    private int pick;

    public Calculator() {
    }

    public Calculator(int tal, int pick) {
        this.tal = tal;
        this.pick = pick;
    }

    public int getTal() {
        return tal;
    }

    public void setTal(int tal) {
        this.tal = tal;
    }

    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }
}
