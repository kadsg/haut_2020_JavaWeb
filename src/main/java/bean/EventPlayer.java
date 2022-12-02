package bean;

public class EventPlayer {
    private String id_sport;
    private String id_item;
    private double grade;
    private boolean join;

    public EventPlayer(String id_sport, String id_item, double grade, boolean join) {
        this.id_sport = id_sport;
        this.id_item = id_item;
        this.grade = grade;
        this.join = join;
    }

    public String getId_sport() {
        return id_sport;
    }

    public void setId_sport(String id_sport) {
        this.id_sport = id_sport;
    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }
}
