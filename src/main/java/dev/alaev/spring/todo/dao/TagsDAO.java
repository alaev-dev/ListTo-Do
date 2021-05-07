package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Tag;

import java.util.List;

public interface TagsDAO {
    List<Tag> getAllTags();
}
