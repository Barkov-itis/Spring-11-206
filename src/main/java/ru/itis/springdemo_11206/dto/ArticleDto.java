package ru.itis.springdemo_11206.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springdemo_11206.models.Article;
import ru.itis.springdemo_11206.models.User;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorName;
    private Integer likesCount;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getArticle_id())
                .text(article.getText())
                .authorName(article.getAuthor().getEmail())
                .likesCount(article.getLikes().size())
                .build();
    }

    public static List<ArticleDto> articleList(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
