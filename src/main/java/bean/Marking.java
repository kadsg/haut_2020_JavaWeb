package bean;

/**
 * 打分项
 */
public class Marking {
    private String id_referee;
    private String id_event;
    private String id_player;
    private double grade;

    public Marking(String id_referee, String id_event, String id_player, double grade) {
        this.id_referee = id_referee;
        this.id_event = id_event;
        this.id_player = id_player;
        this.grade = grade;
    }

    public String getId_referee() {
        return id_referee;
    }

    public void setId_referee(String id_referee) {
        this.id_referee = id_referee;
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
