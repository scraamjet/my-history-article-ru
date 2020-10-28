package models;

import java.util.Date;
import java.util.Objects;

public class Article {
    private Long id;
    private String title;
    private String text;
    private Long userID;
    private double averageRate;
    private Date date;

    public Article(Long id, String title, String text, Long userID, double averageRate,Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userID = userID;
        this.averageRate = averageRate;
        this.date = date;
    }

    public Article(String title, String text, Long userID) {
        this.title = title;
        this.text = text;
        this.userID = userID;
        this.averageRate = 0.0;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
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
