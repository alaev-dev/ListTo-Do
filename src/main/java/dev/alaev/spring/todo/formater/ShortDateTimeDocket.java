package dev.alaev.spring.todo.formater;

import dev.alaev.spring.todo.entity.Docket;

import java.time.format.DateTimeFormatter;

public class ShortDateTimeDocket extends Docket {
    private static final String DATE_FORMATTER = "dd.MM.yyyy HH:mm";
    private final        Docket docket;

    public ShortDateTimeDocket(Docket object) {
        super(object);

        docket = object;
    }

    @Override
    public String getTimeSetup() {
        return docket.getTimeSetupLDT().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }

    @Override
    public String getDeadline() {
        return docket.getDeadline();
    }

    @Override
    public String getTimeEnd() {
        return docket.getTimeEnd();
    }

    @Override
    public String getReminder() {
        return docket.getReminder();
    }
}
