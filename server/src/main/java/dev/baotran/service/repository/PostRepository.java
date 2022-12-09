package dev.baotran.service.repository;

import dev.baotran.service.model.Post;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, UUID> {}
