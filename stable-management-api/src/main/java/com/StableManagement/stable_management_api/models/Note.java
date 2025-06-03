package com.StableManagement.stable_management_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Zawartość notatki nie moze być pusta")
    private String content;

    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "creatorId", nullable = false)
    private User creator;

    @ManyToOne
    @JoinColumn(name = "horseId", nullable = false)
    private Horse horse;

    public Note() {}

    public Note(User creator, String content, Horse horse){
        this.creator = creator;
        this.content = content;
        this.horse = horse;
        createdDate = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public Horse getHorse() { return horse; }
    public void setHorse(Horse horse) { this.horse = horse; }

    public User getCreator() { return creator; }
    public void setCreator(User creator) { this.creator = creator; }
}
