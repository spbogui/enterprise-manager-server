package org.hispci.enterprisemanager.domain.activities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
public class ActivityMeetingReport extends ActivityReport {
    @Temporal(TemporalType.TIME)
    private Date beginHour;
    @Temporal(TemporalType.TIME)
    private Date endHour;
    @Column(columnDefinition = "TEXT")
    private String discussion;
    @Column(columnDefinition = "TEXT")
    private String conclusion;
    @Column(columnDefinition = "TEXT")
    private String diligence;
    @Column(columnDefinition = "TEXT")
    private String recommendation;
}
