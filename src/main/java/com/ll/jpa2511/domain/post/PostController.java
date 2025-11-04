package com.ll.jpa2511.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public Post showPost(@PathVariable("id") Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/findWithShareLockById/{id}")
    public Post findWithShareLockById(@PathVariable("id") Long id) {
        return postService.findWithShareLockById(id).orElse(null);
    }


    @GetMapping("/findByUsername/{username}")
    public List<Post> findByUsername(@PathVariable("username") String username) {
        return postService.findByUsername(username);
    }
}
