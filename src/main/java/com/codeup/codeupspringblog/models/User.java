package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 25)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;
    public User() {}
    //Copy constructor: for Spring security
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
    public User(Long id, String username, String password, String email, List<Post> post) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.post = post;
    }

    public User(String username, String password, String email, List<Post> post) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.post = post;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Post> getPost() {
        return post;
    }
    public void setPost(List<Post> post) {
        this.post = post;
    }
}