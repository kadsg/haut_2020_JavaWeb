package bean;

public class EventPlayer {
    private String id_player;
    private String id_item;
    private double grade;
    private boolean join;

    public EventPlayer(String id_player, String id_item, double grade, boolean join) {
        this.id_player = id_player;
        this.id_item = id_item;
        this.grade = grade;
        this.join = join;
    }

    public String getId_sport() {
        return id_player;
    }

    public void setId_sport(String id_player) {
        this.id_player = id_player;
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
