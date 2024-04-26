package ru.itis.springdemo_11206.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;

    @OneToMany(mappedBy = "author")
    private List<Article> createdArticles;

    @Enumerated(EnumType.STRING)
    private State state;

    private Role role;
    private String confirmCode;
}
