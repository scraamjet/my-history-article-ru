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
        String regexTitleInput = "[^@$#%+=^{}_]";
        return Pattern.matches(regexTitleInput,article.getTitle());
    }
    public boolean checkRegexTextInput(Article article){
        String regexTextInput = "[^@#+=^{}_]";
        return Pattern.matches(regexTextInput,article.getText());
    }
    public boolean checkTitleSeqLength(Article article){
        return article.getTitle().length()>=4;
    }
    public boolean checkTextSeqLength(Article article){
        return article.getText().length()>=40;
    }
}
