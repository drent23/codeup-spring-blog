package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
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
    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String indexPage() {
        return "Welcome to Spring Blogs!";
    }
    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();
        Post firstPost = new Post();
        firstPost.setTitle("Sad Sack");
        firstPost.setBody("I have 100 friends on FB, none in real life.");
        Post secondPost = new Post();
        secondPost.setTitle("The One and Lonely");
        secondPost.setBody("At least they have 100 friends on FB");
        posts.add(firstPost);
        posts.add(secondPost);
        model.addAttribute("posts", postDao.findAll());
        return "index";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable int id) {
        return "Here's blog # " + id;
    }
    @PostMapping("/posts/{id}")
    public String getPost(Model model) {
        Post post = new Post();
        post.setTitle("Sad Sack");
        post.setBody("I have 100 friends on FB, none in real life.");
        model.addAttribute("post", post);
        return "show";
    }
    @GetMapping("/posts/create")
    public String createForm() {
        return "create";
    }
    @PostMapping("/posts/create")
    public String createPost(Model model) {
        model.addAttribute("posts", postDao.save());
        return "redirect:/posts";
    }
}
