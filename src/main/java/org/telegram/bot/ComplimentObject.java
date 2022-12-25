package org.telegram.bot;

public class ComplimentObject {
    private String id;
    private String text;
    private String date_create;
    private String view;
    private String sex;
    private String long1;
    private String like;

    public ComplimentObject() {
    }

    public ComplimentObject(String id, String text, String date_create, String view, String sex, String long1, String like) {
        this.id = id;
        this.text = text;
        this.date_create = date_create;
        this.view = view;
        this.sex = sex;
        this.long1 = long1;
        this.like = like;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}