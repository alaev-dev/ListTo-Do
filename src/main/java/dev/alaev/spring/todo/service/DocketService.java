package dev.alaev.spring.todo.service;

import dev.alaev.spring.todo.entity.Docket;

import java.util.List;

public interface DocketService {
    List<Docket> getAllDockets();

    void saveDocket(Docket docket);
}
