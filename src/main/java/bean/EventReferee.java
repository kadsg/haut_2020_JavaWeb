package bean;

/**
 * 裁判报名项
 */
public class EventReferee {
    private String id_referee;
    private String id_item;

    public EventReferee(String id_referee, String id_item) {
        this.id_referee = id_referee;
        this.id_item = id_item;
    }

    public String getId_referee() {
        return id_referee;
    }

    public void setId_referee(String id_referee) {
        this.id_referee = id_referee;
    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }
}
