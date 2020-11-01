package services;

import models.Article;
import repositories.ArticleRepositoryImpl;

import java.util.ArrayList;

public class ArticleService {
    ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public ArrayList<Article> findMyArticles(Long userID){
        return (ArrayList<Article>) articleRepository.findAllByUserID(userID);
    }
}
