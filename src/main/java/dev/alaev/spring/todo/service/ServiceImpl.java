package dev.alaev.spring.todo.service;

import dev.alaev.spring.todo.dao.DocketDAO;
import dev.alaev.spring.todo.dao.TagDAO;
import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private final DocketDAO docketDAO;
    private final TagDAO    tagDAO;

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
    public Set<Tag> getAllTags() {
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
}
