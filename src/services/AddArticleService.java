package services;

import models.Article;
import repositories.ArticleRepositoryImpl;

public class AddArticleService {
    ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public void addArticle(Article article){
        articleRepository.save(article);
    }
    public void checkTitleInput(Article article){

    }
    public void checkTextInput(Article article){

    }
}
