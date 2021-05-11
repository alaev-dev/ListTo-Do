package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Tag;

import java.util.Set;

public interface TagDAO {
    Set<Tag> getAllTags();

    void saveTag(Tag tag);
}
