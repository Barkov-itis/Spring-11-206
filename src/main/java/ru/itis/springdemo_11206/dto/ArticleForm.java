package ru.itis.springdemo_11206.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ArticleForm {
    private String name;
    private String type;
    private String text;
}
