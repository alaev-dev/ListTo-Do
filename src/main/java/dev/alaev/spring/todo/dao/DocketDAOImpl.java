package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Docket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DocketDAOImpl implements DocketDAO {

    private final SessionFactory sessionFactory;

    public DocketDAOImpl(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    @Transactional
    public List<Docket> getAllDockets() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Docket", Docket.class).getResultList();
    }
}
