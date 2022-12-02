package bean.item;

/**
 * 项目类（赛事类）
 */
public class Item {
    private String id;
    private String name;
    private String rule;
    private String place;
    private String time;
    private boolean is_over;

    public Item(String id, String name, String rule, String place, String time, boolean is_over) {
        this.id = id;
        this.name = name;
        this.rule = rule;
        this.place = place;
        this.time = time;
        this.is_over = is_over;
    }

    public Item(String name, String rule, String place, String time) {
        this.name = name;
        this.rule = rule;
        this.place = place;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIs_over() {
        return is_over;
    }

    public void setIs_over(boolean is_over) {
        this.is_over = is_over;
    }
}
