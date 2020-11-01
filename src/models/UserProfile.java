package models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class UserProfile {
    private long id;
    private String imagePath;
    private double articleAverageRATE;
    private List<Article> articleList;

    public UserProfile() {
    }

    public UserProfile(long id, double articleAverageRATE, String imagePath) {
        this.articleAverageRATE = articleAverageRATE;
        this.id = id;
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }
   /*
    public byte[] startImagePath() throws IOException {
        File file = new File(getImagePath());
        return Files.readAllBytes(file.toPath());
    }

    */

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public double getArticleAverageRATE() {
        return articleAverageRATE;
    }

    public void setArticleAverageRATE(double articleAverageRATE) {
        this.articleAverageRATE = articleAverageRATE;
    }
    public double getDefaultAverageRATE(){
        return 0.0;
    }
    public String getDefaultImagePATH(){
        return "WEB-INF/drawable/default_user_icon.jpg";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserProfile that = (UserProfile) object;
        return id == that.id &&
                Double.compare(that.articleAverageRATE, articleAverageRATE) == 0 &&
                Objects.equals(imagePath, that.imagePath) &&
                Objects.equals(articleList, that.articleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imagePath, articleAverageRATE, articleList);
    }
}