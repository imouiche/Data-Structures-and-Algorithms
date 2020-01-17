package com.codewithinoussa.Streams;

public class Movies implements Comparable<Movies>{
    private String title;
    private int likes;
    private Genre genre;

    public Movies(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public int compareTo(Movies o) {
        return 0;
    }

    public Genre getGenre() {
        return genre;
    }
}
