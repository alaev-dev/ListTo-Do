package dev.alaev.spring.todo.formater;

import static dev.alaev.spring.todo.controller.Controller.LOCALE;

import dev.alaev.spring.todo.entity.Docket;
import java.time.format.DateTimeFormatter;

public class DateTimeDocketFormatter extends Docket {
  private static final String DATE_FORMATTER = "EEE, dd MMMM yyyy HH:mm";
  private final Docket docket;

  public DateTimeDocketFormatter(Docket object) {
    super(object);

    docket = object;
  }

  @Override
  public String getTimeSetup() {
    return docket.getTimeSetupLDT().format(DateTimeFormatter.ofPattern(DATE_FORMATTER, LOCALE));
  }

  @Override
  public String getDeadline() {
    if (deadline == null) {
      return "";
    }
    return docket.getDeadlineLDT().format(DateTimeFormatter.ofPattern(DATE_FORMATTER, LOCALE));
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
