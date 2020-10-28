package dto;

public class UserProfileDTO {
    private String login;
    private String imagePath;
    private double articleAverageRATE;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getArticleAverageRATE() {
        return articleAverageRATE;
    }

    public void setArticleAverageRATE(double articleAverageRATE) {
        this.articleAverageRATE = articleAverageRATE;
    }
}
