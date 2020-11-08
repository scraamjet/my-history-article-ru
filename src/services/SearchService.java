package services;

import models.Article;

import java.util.regex.Pattern;

public class SearchService {
    public boolean checkSearchTitleInput(String title){
        String regexTitleInput = "[a-zA-ZА-Яа-я0-9\\s]";
        return Pattern.matches(regexTitleInput,title);
    }
}
