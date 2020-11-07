package services;

import models.Article;
import repositories.ArticleRepositoryImpl;

import java.util.ArrayList;

public class ArticleService {
    ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public ArrayList<Article> findMyArticles(Long userID){
        return (ArrayList<Article>) articleRepository.findAllByUserID(userID);
    }
    public Article showMyArticle(Long articleID){
        return articleRepository.findById(articleID).get();
    }
    public ArrayList<Article> findSomeArticles(String title){
        return (ArrayList<Article>) articleRepository.findAllByTitle(title);
    }
}
