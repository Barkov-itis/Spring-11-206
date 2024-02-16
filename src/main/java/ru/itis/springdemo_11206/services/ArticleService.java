package ru.itis.springdemo_11206.services;

import ru.itis.springdemo_11206.dto.ArticleDto;
import ru.itis.springdemo_11206.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long userId);

    ArticleDto addArtcle(Long userId, ArticleForm articleForm);
}
