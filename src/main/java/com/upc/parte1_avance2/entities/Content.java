package com.upc.try1_talkia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 150)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private Integer year;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "link")
    private String link;

    //se colocó updatable = false
    @Column(name = "i_created_at", updatable = false)
    private Instant iCreatedAt;

    @Column(name = "i_created_by", length = 150, updatable = false)
    private String iCreatedBy;

    @Column(name = "i_modified_at")
    private Instant iModifiedAt;

    @Column(name = "i_modified_by", length = 150)
    private String iModifiedBy;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)//LAZZY en session @Transactional
    @JoinTable(
            name = "content_levels",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "levels_id")
    )
    private Set<Level> levels = new HashSet<>();


    @PrePersist
    protected void onCreate() {
        iCreatedAt = Instant.now();
        iModifiedAt=Instant.now();
        iCreatedBy=System.getProperty("user.name");
        iModifiedBy = System.getProperty("user.name");
    }
    @PreUpdate
    protected void onUpdate() {
        iModifiedAt = Instant.now();
        iModifiedBy = System.getProperty("user.name");

    }
}