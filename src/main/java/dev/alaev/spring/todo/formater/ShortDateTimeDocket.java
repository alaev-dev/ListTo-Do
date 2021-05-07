package dev.alaev.spring.todo.formater;

import dev.alaev.spring.todo.entity.Docket;

import java.time.format.DateTimeFormatter;

public class ShortDateTimeDocket extends Docket {

    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    public String timeSetup;

    public ShortDateTimeDocket(Docket object) {
        super(object.getId(),
              object.getDescribeCase(),
              object.getTimeSetup(),
              object.getDeadline(),
              object.getTimeEnd(),
              object.getReminder());

        doPretty();
    }

    public static String getDateFormatter() {
        return DATE_FORMATTER;
    }

    public void doPretty() {
        timeSetup = getTimeSetup().toLocalDateTime().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }
}
