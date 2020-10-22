package repositories;

import models.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article> {
    List<Article> findAllByTitle(String title);
    List<Article> findAllByUserID(Long userID);


}
