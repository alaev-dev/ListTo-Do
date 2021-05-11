package dev.alaev.spring.todo.service;

import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.entity.Tag;

import java.util.List;

public interface Service {
    List<Docket> getAllDockets();

    List<Tag> getAllTags();

    void saveTag(Tag tag);

    void saveDocket(Docket docket);

    Docket getDocket(long id);

    void deleteDocket(long id);
}
