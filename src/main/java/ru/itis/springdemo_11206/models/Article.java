package ru.itis.springdemo_11206.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    private String name;

    @Column(length = 1000)
    private String text;

    @ManyToOne
    @JoinTable(name = "article_author")
    private User author;

    @ManyToMany
    @JoinTable(name = "article_likes",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> likes;


}
