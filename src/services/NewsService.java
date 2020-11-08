package services;

import models.Article;
import repositories.ArticleRepositoryImpl;

import java.util.ArrayList;


public class NewsService {
    ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public ArrayList<Article> showNews(){
        return (ArrayList<Article>) articleRepository.findNews();
    }
}
