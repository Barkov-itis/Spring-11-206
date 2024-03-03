package ru.itis.springdemo_11206.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_11206.dto.ArticleDto;
import ru.itis.springdemo_11206.dto.ArticleForm;
import ru.itis.springdemo_11206.models.Article;
import ru.itis.springdemo_11206.models.User;
import ru.itis.springdemo_11206.repository.ArticleRepository;
import ru.itis.springdemo_11206.repository.UsersRepository;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<ArticleDto> getByUser(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Article> articlesOfUser = user.getCreatedArticles();
        return ArticleDto.articleList(articlesOfUser);
    }

    @Override
    public ArticleDto addArtcle(Long userId, ArticleForm articleForm) {
        User author = usersRepository.getOne(userId);

        Article newArticle = Article.builder()
                .author(author)
                .name(articleForm.getName())
                .type(articleForm.getType())
                .text(articleForm.getText())
                .build();

        articleRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId){
        User user = usersRepository.getOne(userId);
        Article article = articleRepository.getOne(articleId);
        if (articleRepository.existsByArticleIdAndLikesContaining(articleId, user)) {
            article.getLikes().remove(user);
        }
        else {
            article.getLikes().add(user);
        }
        System.out.println("**********************");
        articleRepository.save(article);
        return ArticleDto.from(article);
    }
}
