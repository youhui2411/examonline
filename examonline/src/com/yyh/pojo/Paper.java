package com.yyh.pojo;

/**
 * @Description: com.yyh.pojo
 * @version: 1.0
 */
public class Paper {
    private int pid;
    private String course;
    private int questionNum;
    private int time;
    private String listTitle;
    private String listAnswer;
    private int point;
    private int userPoint;

    public Paper() {
    }

    public Paper(int pid, String course, int questionNum, int time, String listTitle, String listAnswer, int point, int userPoint) {
        this.pid = pid;
        this.course = course;
        this.questionNum = questionNum;
        this.time = time;
        this.listTitle = listTitle;
        this.listAnswer = listAnswer;
        this.point = point;
        this.userPoint = userPoint;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public String getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(String listAnswer) {
        this.listAnswer = listAnswer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "pid=" + pid +
                ", course='" + course + '\'' +
                ", questionNum=" + questionNum +
                ", time=" + time +
                ", listTitle='" + listTitle + '\'' +
                ", listAnswer='" + listAnswer + '\'' +
                ", point=" + point +
                ", userPoint=" + userPoint +
                '}';
    }
}
