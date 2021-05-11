package dev.alaev.spring.todo.dao;

import org.hibernate.SessionFactory;

public class DAO {
  private final SessionFactory sessionFactory;

  public DAO(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
