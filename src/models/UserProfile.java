package models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class UserProfile {
    private long id;
    private String imagePath;
    private List<Article> articleList;

    public UserProfile() {
    }

    public UserProfile(long id, String imagePath) {
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


    public String getDefaultImagePATH(){
        return "drawable/default_user_icon.jpg";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserProfile that = (UserProfile) object;
        return id == that.id &&
                Objects.equals(imagePath, that.imagePath) &&
                Objects.equals(articleList, that.articleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imagePath, articleList);
    }
}