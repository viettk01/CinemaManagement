package entities.managerPlan;

public class Target {

    private int month;
    private double targetMonth;
    private double targetDay;
    private double targetWeek;

    public Target(double targetMonth, double targetWeek, double targetDay) {
        this.targetMonth = targetMonth;
        this.targetWeek = targetWeek;
        this.targetDay = targetDay;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTargetMonth() {
        return targetMonth;
    }

    public void setTargetMonth(double targetMonth) {
        this.targetMonth = targetMonth;
    }

    public double getTargetDay() {
        return targetDay;
    }

    public void setTargetDay(double targetDay) {
        this.targetDay = targetDay;
    }

    public double getTargetWeek() {
        return targetWeek;
    }

    public void setTargetWeek(double targetWeek) {
        this.targetWeek = targetWeek;
    }

    @Override
    public String toString() {
        return "Target Tháng " +month+
                "\n Target Tháng: " + targetMonth +
                "\n Target Tuần: " + targetWeek +
                "\n Target Ngày: " + targetDay;
    }
}
