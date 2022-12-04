package bean;

public class Score implements Comparable<Score> {
    private String id_item;
    private String id_player;
    private double score;
    private int rank;

    public Score(String id_item, String id_player, double score, int rank) {
        this.id_item = id_item;
        this.id_player = id_player;
        this.score = score;
        this.rank = rank;
    }

    public Score(String id_item, String id_player, double score) {
        this.id_item = id_item;
        this.id_player = id_player;
        this.score = score;
    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public String getId_player() {
        return id_player;
    }

    public void setId_player(String id_player) {
        this.id_player = id_player;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Score o) {
        return (int) (o.getScore() - this.score);
    }
}
