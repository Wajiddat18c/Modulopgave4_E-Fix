/**
 * dat18c.modulopgave.efix.model
 */
package dat18c.modulopgave.efix.model;
/** This class defines data structure.
 *
 */
public class Calculator {

    private int pickPhone;
    private int pickCondition;
    private int pickPower;
    private int pickMainFeatures;
    private int pickAppearance;
    private int pickScreen;
    private int pickLiquid;
    private int pickDeviceLocks;

    public Calculator() {
    }

    public Calculator(int pickPhone, int pickCondition, int pickPower, int pickMainFeatures, int pickAppearance, int pickScreen, int pickLiquid, int pickDeviceLocks) {
        this.pickPhone = pickPhone;
        this.pickCondition = pickCondition;
        this.pickPower = pickPower;
        this.pickMainFeatures = pickMainFeatures;
        this.pickAppearance = pickAppearance;
        this.pickScreen = pickScreen;
        this.pickLiquid = pickLiquid;
        this.pickDeviceLocks = pickDeviceLocks;
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

    public int getPickPower() {
        return pickPower;
    }

    public void setPickPower(int pickPower) {
        this.pickPower = pickPower;
    }

    public int getPickMainFeatures() {
        return pickMainFeatures;
    }

    public void setPickMainFeatures(int pickMainFeatures) {
        this.pickMainFeatures = pickMainFeatures;
    }

    public int getPickAppearance() {
        return pickAppearance;
    }

    public void setPickAppearance(int pickAppearance) {
        this.pickAppearance = pickAppearance;
    }

    public int getPickScreen() {
        return pickScreen;
    }

    public void setPickScreen(int pickScreen) {
        this.pickScreen = pickScreen;
    }

    public int getPickLiquid() {
        return pickLiquid;
    }

    public void setPickLiquid(int pickLiquid) {
        this.pickLiquid = pickLiquid;
    }

    public int getPickDeviceLocks() {
        return pickDeviceLocks;
    }

    public void setPickDeviceLocks(int pickDeviceLocks) {
        this.pickDeviceLocks = pickDeviceLocks;
    }
}
