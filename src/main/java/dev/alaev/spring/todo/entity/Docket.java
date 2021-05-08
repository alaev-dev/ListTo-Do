package dev.alaev.spring.todo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "docket")
public class Docket {

    @Column(name = "desc_case")
    protected String        describeCase;
    @Column(name = "time_setup")
    protected LocalDateTime timeSetup;
    @Column(name = "deadline")
    protected LocalDateTime deadline;
    @Column(name = "time_end")
    protected LocalDateTime timeEnd;
    @Column(name = "reminder")
    protected LocalDateTime reminder;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docket_id")
    private   Long          id;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "docket_tag",
            joinColumns = {@JoinColumn(name = "docket_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private   Set<Tag>      tags = new HashSet<>();

    public Docket() {}

    public Docket(Docket obj) {
        id = obj.id;
        describeCase = obj.describeCase;
        timeSetup = obj.timeSetup;
        deadline = obj.deadline;
        timeEnd = obj.timeEnd;
        reminder = obj.reminder;
        tags = obj.tags;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Long getId() {
        return id;
    }

    public String getDescribeCase() {
        return describeCase;
    }

    public String getTimeSetup() {
        return timeSetup.toString();
    }

    public String getDeadline() {
        return deadline == null ? "" : deadline.toString();
    }

    public String getTimeEnd() {
        return timeEnd == null ? "" : timeEnd.toString();
    }

    public String getReminder() {
        return reminder == null ? "" : reminder.toString();
    }

    // timeSetup is NOT NULL
    public LocalDateTime getTimeSetupLDT() {
        return timeSetup;
    }

    public LocalDateTime getDeadlineLDT() {
        return deadline;
    }

    public LocalDateTime getTimeEndLDT() {
        return timeEnd;
    }

    public LocalDateTime getReminderLDT() {
        return reminder;
    }
}
