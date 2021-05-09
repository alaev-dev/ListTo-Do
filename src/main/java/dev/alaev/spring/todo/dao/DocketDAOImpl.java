package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Docket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocketDAOImpl implements DocketDAO {

    private final SessionFactory sessionFactory;

    public DocketDAOImpl(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    public List<Docket> getAllDockets() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Docket", Docket.class).getResultList();
    }

    @Override
    public void saveDocket(Docket docket) {
        Session session = sessionFactory.getCurrentSession();

        session.save(docket);
    }
}
