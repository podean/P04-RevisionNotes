package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

    private int id;
    private String content;
    private int star;

    public Note(int id, String content, int star) {
        this.id = id;
        this.content = content;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getStars() {
        return star;
    }

}
