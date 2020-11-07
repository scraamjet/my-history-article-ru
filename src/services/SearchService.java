package services;

import models.Article;

import java.util.regex.Pattern;

public class SearchService {
    public boolean checkSearchTitleInput(String title){
        String regexTitleInput = "[^@$#%+=^{}_]";
        return Pattern.matches(regexTitleInput,title);
    }
}
