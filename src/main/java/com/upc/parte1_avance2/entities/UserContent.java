package com.upc.try1_talkia.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_content")
public class UserContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_content_id", nullable = false)
    private Integer id;

    @Column(name = "i_viewed_at",updatable = false)
    private Instant iViewedAt;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Content.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;
    @PrePersist
    protected void onCreate() {
        iViewedAt = Instant.now();

    }

}