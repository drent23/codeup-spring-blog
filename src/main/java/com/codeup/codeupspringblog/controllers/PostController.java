package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userRepository;
    private final EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userRepository, EmailService emailService) {
        this.postDao = postDao;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id).get());
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userRepository.findById(1L));
        postDao.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postDao.getReferenceById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @GetMapping("/posts/email/{id}")
    public String sendEmailAboutPost(@PathVariable long id) {
        Post post = postDao.getReferenceById(id);
        emailService.prepareAndSend(post, "Here's the post you requested", post.getTitle() + " : " + post.getBody() + " ~ creator: " + post.getUser().getUsername());
        return "redirect:/posts";
    }
}