package com.winseslas.openbook.beans;

public class Testimonial {
    
    private String picture;
    private String name;
    private String post;
    private int like;
    private String texte;
    
    // Constructor
    public Testimonial(String picture, String name, String post, int like, String texte) {
        this.picture = picture;
        this.name = name;
        this.post = post;
        this.like = like;
        this.texte = texte;
    }
    
    // Getters and Setters
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    
}