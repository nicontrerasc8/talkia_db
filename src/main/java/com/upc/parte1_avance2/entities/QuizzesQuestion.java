package com.upc.try1_talkia.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quizzes_questions")
public class QuizzesQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_answer", columnDefinition = "TEXT")
    private String userAnswer;

    @Column(name = "attempt")
    private int attempt;

    @Column(name = "points_earned")
    private int pointsEarned;

    @Column(name = "i_attempt_at")
    private LocalDateTime attemptAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizzes_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questions_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Question question;
}
