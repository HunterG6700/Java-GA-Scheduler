
public class NodeTime {

    int periodId;
    String day;
    int time;
    
    NodeTime(int periodId, String day, int time) {
        this.periodId = periodId;
        this.day = day;
        this.time = time;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPeriodId() {
        return periodId;
    }

    public String getDay() {
        return day;
    }

    public int getTime() {
        return time;
    }
}
