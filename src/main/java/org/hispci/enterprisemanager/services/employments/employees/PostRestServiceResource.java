package org.hispci.enterprisemanager.services.employments.employees;

import org.hispci.enterprisemanager.domain.employment.employees.Post;
import org.hispci.enterprisemanager.repositories.employments.employees.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/posts")
@RestController
public class PostRestServiceResource {

    private PostRepository postRepository;

    public PostRestServiceResource(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    @ResponseBody
    public Post savePost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePost(Long id) {
        Optional<Post> result = postRepository.findById(id);
        if (result.isPresent()) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Post findById(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public List<Post> findPostByName(@PathVariable String name) {
        return postRepository.findByNameContaining(name);
    }
}
