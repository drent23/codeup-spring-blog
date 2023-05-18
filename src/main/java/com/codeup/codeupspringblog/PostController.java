package com.codeup.codeupspringblog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage() {
        return "Welcome to Spring Blogs!";
    }
    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        Post firstPost = new Post();
        firstPost.setTitle("Sad Sack");
        firstPost.setBody("I have 100 friends on FB, none in real life.");
        Post secondPost = new Post();
        secondPost.setTitle("The One and Lonely");
        secondPost.setBody("At least they have 100 friends on FB");
        posts.add(firstPost);
        posts.add(secondPost);
        model.addAttribute("posts", posts);
        return "index";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable int id) {
        return "Here's blog # " + id;
    }
    @PostMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        Post post = new Post();
        post.setTitle("Sad Sack");
        post.setBody("I have 100 friends on FB, none in real life.");
        model.addAttribute("post", post);
        return "show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "Here's the form to create a blog post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Please create your post";
    }
}
