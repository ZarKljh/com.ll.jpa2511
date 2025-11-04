package com.ll.jpa2511.domain.post;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public List<Post> findByUsername(String username) {
        return postRepository.findByUsername(username);
    }

    public Post create(String subject, String content, String username) {
        Post post = Post.builder()
                .subject(subject)
                .content(content)
                .username(username)
                .build();

        return postRepository.save(post);
    }
    @SneakyThrows
    public Optional<Post> findWithShareLockById(Long id) {

        /*lock으로 인해 에러가 발생하면 10초동안 멈추게 한다*/
        Thread.sleep(10000);

        return postRepository.findWithShareLockById(id);
    }
}
