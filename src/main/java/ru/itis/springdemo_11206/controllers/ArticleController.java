package ru.itis.springdemo_11206.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springdemo_11206.dto.ArticleDto;
import ru.itis.springdemo_11206.dto.ArticleForm;
import ru.itis.springdemo_11206.services.ArticleService;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") Long userId,
                                 @RequestBody ArticleForm articleForm) {
        return articleService.addArtcle(userId, articleForm);
    }
    // localhost:8080/users/1/articles
    @GetMapping("/users/{user-id}/articles")
    public String getArticlesOfUser(@PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("articles", articleService.getByUser(userId));
        return "article_page";
    }
}
