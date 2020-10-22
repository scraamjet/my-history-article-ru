package models;

import java.util.Objects;

public class Article {
    private Long id;
    private String title;
    private String text;
    private  User owner;

    public Article(Long id,String title, String text,User owner) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.owner = owner;
    }

    public Article(Long id,String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return Objects.equals(id, article.id) &&
                Objects.equals(title, article.title) &&
                Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text);
    }
}
