package dev.alaev.spring.todo.dao;

import dev.alaev.spring.todo.entity.Docket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocketDAOImpl extends DAO implements DocketDAO {

    public DocketDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Docket> getAllDockets() {
        Session session = getSessionFactory().getCurrentSession();

        return session.createQuery("from Docket", Docket.class).getResultList();
    }

    @Override
    public void saveDocket(Docket docket) {
        Session session = getSessionFactory().getCurrentSession();

        session.save(docket);
    }
}
