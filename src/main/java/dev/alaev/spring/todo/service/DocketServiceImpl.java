package dev.alaev.spring.todo.service;

import dev.alaev.spring.todo.dao.DocketDAO;
import dev.alaev.spring.todo.entity.Docket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocketServiceImpl implements DocketService {

    private final DocketDAO docketDAO;

    public DocketServiceImpl(DocketDAO docketDAO) {this.docketDAO = docketDAO;}

    @Override
    @Transactional
    public List<Docket> getAllDockets() {
        return docketDAO.getAllDockets();
    }

    @Override
    @Transactional
    public void saveDocket(Docket docket) {
        docketDAO.saveDocket(docket);
    }
}
