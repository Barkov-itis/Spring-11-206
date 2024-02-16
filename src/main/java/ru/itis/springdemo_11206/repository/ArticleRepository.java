package ru.itis.springdemo_11206.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springdemo_11206.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
