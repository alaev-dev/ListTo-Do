package dev.alaev.spring.todo.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
  @Id
  @Column(name = "tag_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToMany(mappedBy = "tags")
  private Set<Docket> dockets = new HashSet<>();

  public Tag() {}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Tag)) return false;
    Tag tag = (Tag) o;
    return getId().equals(tag.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Docket> getDockets() {
    return dockets;
  }

  public void setDockets(Set<Docket> dockets) {
    this.dockets = dockets;
  }
}
