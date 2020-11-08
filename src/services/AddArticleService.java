package services;

import models.Article;
import repositories.ArticleRepositoryImpl;

import java.util.regex.Pattern;

public class AddArticleService {
    ArticleRepositoryImpl articleRepository = new ArticleRepositoryImpl();
    public void addArticle(Article article){
        articleRepository.save(article);
    }
    public boolean checkRegexTitleInput(Article article){
        String regexTitleInput = "[a-zA-ZА-Яа-я0-9\\s]";
        return Pattern.matches(regexTitleInput,article.getTitle());
    }

    public boolean checkTitleSeqLength(Article article){
        return article.getTitle().length()>=4;
    }
    public boolean checkTextSeqLength(Article article){
        return article.getText().length()>=40;
    }
}
