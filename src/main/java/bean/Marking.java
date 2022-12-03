package bean;

/**
 * 打分项
 */
public class Marking {
    private String id_referee;
    private String id_item;
    private String id_player;
    private double grade;

    public Marking(String id_referee, String id_item, String id_player, double grade) {
        this.id_referee = id_referee;
        this.id_item = id_item;
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
        return id_item;
    }

    public void setId_event(String id_item) {
        this.id_item = id_item;
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
