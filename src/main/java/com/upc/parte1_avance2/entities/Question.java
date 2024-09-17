package com.upc.try1_talkia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "sublevel")
    private int sublevel;

    @Column(name = "feedback", length = 255)
    private String feedback;

    @Column(name = "i_created_at")
    private LocalDateTime createdAt;

    @Column(name = "i_created_by", length = 150)
    private String createdBy;

    @Column(name = "i_modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "i_modified_by", length = 150)
    private String modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "levels_id", referencedColumnName = "levels_id")
    private Level level;  // Relación ManyToOne con Level

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;  // Relación OneToMany con Answer
}
