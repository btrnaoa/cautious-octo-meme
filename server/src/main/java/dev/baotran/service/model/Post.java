package dev.baotran.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Post {

  @Id
  @GeneratedValue
  private UUID id = UUID.randomUUID();

  private String title;

  private String content;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Post post = (Post) o;
    return Objects.equals(id, post.id)
        && Objects.equals(title, post.title)
        && Objects.equals(content, post.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content);
  }

  @Override
  public String toString() {
    return "Post{"
        + "id=" + id
        + ", title='" + title + '\''
        + ", content='" + content + '\''
        + '}';
  }
}
