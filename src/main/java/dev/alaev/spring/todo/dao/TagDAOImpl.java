package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Tag;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class TagDAOImpl extends DAO implements TagDAO {
    public TagDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Set<Tag> getAllTags() {
        return new HashSet<>(getSessionFactory().getCurrentSession()
                                                .createQuery("from Tag", Tag.class)
                                                .getResultList());
    }

    @Override
    public void saveTag(Tag tag) {
        getSessionFactory().getCurrentSession().save(tag);
    }
}
