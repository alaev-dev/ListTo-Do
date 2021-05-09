package dev.alaev.spring.todo.entity;

public class DocketInput {
    public String describeCase;
    public String deadline;
    public String reminder;

    public DocketInput() {}

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
