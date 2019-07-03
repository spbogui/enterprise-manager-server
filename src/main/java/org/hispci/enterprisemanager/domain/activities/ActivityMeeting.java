package org.hispci.enterprisemanager.domain.activities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hispci.enterprisemanager.domain.locations.Location;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ActivityMeeting extends Activity {
    private String agenda;
    @Temporal(TemporalType.TIME)
    private Date startHour;
    @Temporal(TemporalType.TIME)
    private Date endHour;
    @ManyToOne
    private Location location;
    private String placeName;
}
