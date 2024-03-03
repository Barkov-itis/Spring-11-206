package ru.itis.springdemo_11206.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springdemo_11206.models.Article;
import ru.itis.springdemo_11206.models.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining(Long articleId, User user);
}
