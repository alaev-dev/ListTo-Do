package dev.alaev.spring.todo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class DocketInput {
    @NotBlank(message = "required field")
    @Size(max = 59, message = "up to 60 characters")
    private String       describeCase;
    private String       deadline;
    private String       reminder;
    private List<String> pickedTags = new ArrayList<>();

    public DocketInput() {}

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
}
