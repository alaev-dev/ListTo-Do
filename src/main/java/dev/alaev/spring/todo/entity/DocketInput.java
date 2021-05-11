package dev.alaev.spring.todo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DocketInput {
  private long id = 0;

  @NotBlank(message = "required field")
  @Size(max = 59, message = "up to 60 characters")
  private String describeCase;

  private String deadline;
  private String reminder;
  private List<String> pickedTags = new ArrayList<>();

  public DocketInput() {}

  public DocketInput(
      long id, String describeCase, String deadline, String reminder, List<String> pickedTags) {
    this.id = id;
    this.describeCase = describeCase;
    this.deadline = deadline;
    this.reminder = reminder;
    this.pickedTags = pickedTags;
  }

  public List<String> getPickedTags() {
    return pickedTags;
  }

  public void setPickedTags(List<String> pickedTags) {
    this.pickedTags = pickedTags;
  }

  public String getDescribeCase() {
    return describeCase;
  }

  public void setDescribeCase(String describeCase) {
    this.describeCase = describeCase;
  }

  public String getDeadline() {
    return deadline;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public String getReminder() {
    return reminder;
  }

  public void setReminder(String reminder) {
    this.reminder = reminder;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
