package services;

import models.Article;
import models.User;
import repositories.ArticleRepository;
import repositories.ArticleRepositoryImpl;

public class AddArticleService {
    ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public void createRelationWithUser(Article article, User user){
        article.setOwner(user);
    }
}
