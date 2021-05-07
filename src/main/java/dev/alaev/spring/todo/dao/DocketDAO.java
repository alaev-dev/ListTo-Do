package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Docket;

import java.util.List;

public interface DocketDAO {
    List<Docket> getAllDockets();
}
