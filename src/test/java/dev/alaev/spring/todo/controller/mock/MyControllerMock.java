package dev.alaev.spring.todo.controller.mock;

import dev.alaev.spring.todo.controller.MyController;
import dev.alaev.spring.todo.dao.DocketDAO;

public class MyControllerMock extends MyController {
    public MyControllerMock(DocketDAO docketDAO) {
        super(docketDAO);
    }
}
