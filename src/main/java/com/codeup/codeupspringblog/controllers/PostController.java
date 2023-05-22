package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userRepository;

    public PostController(PostRepository postDao, UserRepository userRepository) {
        this.postDao = postDao;
        this.userRepository = userRepository;
    }

    //    public PostController(PostRepository postDao) {
//        this.postDao = postDao;
//    }
//    public PostController(UserRepository userRepository) {
//        this.userRepository = userRepository);
//    }
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String createForm() {
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title,@RequestParam String body) {
        User user = userRepository.findAll().get(0);
        Post userPost = new Post();
        userPost.setTitle(title);
        userPost.setBody(body);
        postDao.save(userPost);
        return "redirect:/posts";
    }
}
//    List<Post> posts = new ArrayList<>();
//    Post firstPost = new Post();
//        firstPost.setTitle("Sad Sack");
//                firstPost.setBody("I have 100 friends on FB, none in real life.");
//                Post secondPost = new Post();
//                secondPost.setTitle("The One and Lonely");
//                secondPost.setBody("At least they have 100 friends on FB");
//                posts.add(firstPost);
//                posts.add(secondPost);
//@PostMapping("/posts/{id}")
//public String getPost(Model model) {
//    Post post = new Post();
//    post.setTitle("Sad Sack");
//    post.setBody("I have 100 friends on FB, none in real life.");
//    model.addAttribute("post", post);
//    return "posts/show";
//}
