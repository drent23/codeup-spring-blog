package com.codeup.codeupspringblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage() {
        return "Welcome to Spring Blogs!";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable int id) {
        return "Here's blog # " + id;
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
