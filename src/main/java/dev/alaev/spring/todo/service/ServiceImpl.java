package dev.alaev.spring.todo.service;

import dev.alaev.spring.todo.dao.DocketDAO;
import dev.alaev.spring.todo.dao.TagDAO;
import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.entity.Tag;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

  private final DocketDAO docketDAO;
  private final TagDAO tagDAO;

  public ServiceImpl(DocketDAO docketDAO, TagDAO tagDAO) {
    this.docketDAO = docketDAO;
    this.tagDAO = tagDAO;
  }

  @Override
  @Transactional
  public List<Docket> getAllDockets() {
    return docketDAO.getAllDockets();
  }

  @Override
  @Transactional
  public List<Tag> getAllTags() {
    return tagDAO.getAllTags();
  }

  @Override
  @Transactional
  public void saveTag(Tag tag) {
    tagDAO.saveTag(tag);
  }

  @Override
  @Transactional
  public void saveDocket(Docket docket) {
    docketDAO.saveDocket(docket);
  }

  @Override
  @Transactional
  public Docket getDocket(long id) {
    return docketDAO.getDocket(id);
  }

  @Override
  @Transactional
  public void deleteDocket(long id) {
    docketDAO.deleteDocket(id);
  }
}
