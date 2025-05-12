package com.khurram.quizapp.model;

import com.khurram.quizapp.listener.QuizEntityListener;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@EntityListeners(QuizEntityListener.class)
@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

}