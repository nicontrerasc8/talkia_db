package com.upc.try1_talkia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('users_id_seq')")
    @Column(name = "users_id", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "total_points")
    private Integer totalPoints;

    //Con roles
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roles_id")
    private Role role;

    @Column(name = "i_created_at",updatable = false)
    private Instant iCreatedAt;

    @Column(name = "i_modified_at")
    private Instant iModifiedAt;

    //Mxs User --> 1 level
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "levels_id")
    private Level level;


    @PrePersist
    protected void onCreate() {
        iCreatedAt = Instant.now();
        iModifiedAt = Instant.now();

    }
    @PreUpdate
    protected void onUpdate() {
        iModifiedAt = Instant.now();
    }
}