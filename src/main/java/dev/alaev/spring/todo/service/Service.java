package dev.alaev.spring.todo.service;

import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.entity.Tag;

import java.util.List;
import java.util.Set;

public interface Service {
    List<Docket> getAllDockets();

    Set<Tag> getAllTags();

    void saveTag(Tag tag);

    void saveDocket(Docket docket);
}
