package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String title;
    @Column(nullable = false)
    private String body;
    public Post() {}
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
