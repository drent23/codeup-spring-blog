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
    //hypothetical get methods below here
    //a post method etc.
    //they NEED to access the Ad table to work tho! My get method needs to [R]ead the ads and my post method needs to [C]reate the ads!
    //To do the above.. I need a data - access - object
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
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
        post.setUser(userDao.findById(1L));
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