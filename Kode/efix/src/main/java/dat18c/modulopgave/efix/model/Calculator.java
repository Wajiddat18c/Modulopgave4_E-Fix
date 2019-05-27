package dat18c.modulopgave.efix.model;

public class Calculator {

    private int pickPhone;
    private int pickCondition;

    public Calculator() {
    }

    public Calculator(int pickPhone, int pickCondition) {
        this.pickPhone = pickPhone;
        this.pickCondition = pickCondition;
    }

    public int getPickPhone() {
        return pickPhone;
    }

    public void setPickPhone(int pickPhone) {
        this.pickPhone = pickPhone;
    }

    public int getPickCondition() {
        return pickCondition;
    }

    public void setPickCondition(int pickCondition) {
        this.pickCondition = pickCondition;
    }
}
