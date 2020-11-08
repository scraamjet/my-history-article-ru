package models;

import java.util.Date;
import java.util.Objects;

public class Article {
    private Long id;
    private String title;
    private String text;
    private Long userID;
    private Date date;
    private String userLogin;

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Article(Long id, String title, String text, Long userID, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userID = userID;
        this.date = date;
    }


    public Article(String title, String text, Long userID) {
        this.title = title;
        this.text = text;
        this.userID = userID;
    }

    public Article(Long id,String title,String text,Long userID) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public Date getDate() {
        return date;
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
