package com.khurram.quizapp.listener;

import com.khurram.quizapp.model.Quiz;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;

public class QuizEntityListener {

    private final Path logFile = Paths.get("quiz_log.txt");

    @PrePersist
    public void beforeQuizCreated(Quiz quiz) {
        try {
            String log = "About to create Quiz: Title=" + quiz.getTitle();
            Files.write(logFile,
                    (log + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            System.out.println("PrePersist log written to: " + logFile.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostPersist
    public void afterQuizCreated(Quiz quiz) {
        try {
            if (quiz.getTitle() != null && quiz.getTitle().contains("Test")) {
                String log = "Quiz Created: ID=" + quiz.getId() + ", Title=" + quiz.getTitle();
                Files.write(logFile,
                        (log + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                System.out.println("PostPersist log written to: " + logFile.toAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
