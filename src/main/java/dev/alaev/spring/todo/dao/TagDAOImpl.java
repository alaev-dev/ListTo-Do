package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Tag;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TagDAOImpl extends DAO implements TagDAO {
  public TagDAOImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public List<Tag> getAllTags() {
    return getSessionFactory()
        .getCurrentSession()
        .createQuery("from Tag", Tag.class)
        .getResultList();
  }

  @Override
  public void saveTag(Tag tag) {
    getSessionFactory().getCurrentSession().save(tag);
  }
}
