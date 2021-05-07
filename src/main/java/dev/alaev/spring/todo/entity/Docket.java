package dev.alaev.spring.todo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "docket")
public class Docket {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "docket_tag",
            joinColumns = {@JoinColumn(name = "docket_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docket_id")
    private Long id;

    @Column(name = "desc_case")
    private String describeCase;

    @Column(name = "time_setup")
    private Timestamp timeSetup;

    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "time_end")
    private Timestamp timeEnd;

    @Column(name = "reminder")
    private Timestamp reminder;

    public Docket() {}

    public Docket(Long id,
                  String describeCase,
                  Timestamp timeSetup,
                  Timestamp deadline,
                  Timestamp timeEnd, Timestamp reminder) {
        this.id = id;
        this.describeCase = describeCase;
        this.timeSetup = timeSetup;
        this.deadline = deadline;
        this.timeEnd = timeEnd;
        this.reminder = reminder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescribeCase() {
        return describeCase;
    }

    public void setDescribeCase(String describeCase) {
        this.describeCase = describeCase;
    }

    public Timestamp getTimeSetup() {
        return timeSetup;
    }

    public void setTimeSetup(Timestamp timeSetup) {
        this.timeSetup = timeSetup;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Timestamp getReminder() {
        return reminder;
    }

    public void setReminder(Timestamp reminder) {
        this.reminder = reminder;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
