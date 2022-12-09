package dev.baotran.service.controller;

import dev.baotran.service.model.Post;
import dev.baotran.service.repository.PostRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

  private final PostRepository repository;

  public PostController(PostRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Post> getAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Post getById(@PathVariable UUID id) {
    return repository.findById(id).orElseThrow();
  }

  @PostMapping
  public Post create(@RequestBody Post requestBody) {
    return repository.save(requestBody);
  }

  @PutMapping("/{id}")
  public Post update(@RequestBody Post post, @PathVariable UUID id) {
    return repository.findById(id)
        .map(_post -> {
          _post.setTitle(post.getTitle());
          _post.setContent(post.getContent());
          return repository.save(_post);
        })
        .orElseThrow();
  }

  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable UUID id) {
    repository.deleteById(id);
  }
}
