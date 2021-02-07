package com.yyh.pojo;

/**
 * @Description: com.yyh.pojo
 * @version: 1.0
 */
public class Title {
    private int tid;
    private String question;
    private String toption;
    private String tkey;
    private int level;
    private int score;
    private String course;

    public Title() {
    }

    public Title(int tid, String question, String toption, String tkey, int level, int score, String course) {
        this.tid = tid;
        this.question = question;
        this.toption = toption;
        this.tkey = tkey;
        this.level = level;
        this.score = score;
        this.course = course;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getToption() {
        return toption;
    }

    public void setToption(String toption) {
        this.toption = toption;
    }

    public String getTkey() {
        return tkey;
    }

    public void setTkey(String tkey) {
        this.tkey = tkey;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Title{" +
                "tid=" + tid +
                ", question='" + question + '\'' +
                ", toption='" + toption + '\'' +
                ", tkey='" + tkey + '\'' +
                ", level=" + level +
                ", score=" + score +
                ", course='" + course + '\'' +
                '}';
    }
}
