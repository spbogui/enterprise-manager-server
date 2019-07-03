package org.hispci.enterprisemanager.domain.activities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hispci.enterprisemanager.domain.locations.Location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ActivityTraining extends Activity {
    private Date departureDate;
    private Date returnDate;
    private String trainingLevel;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Location location;
    @Column(nullable = false)
    private String placeName;
}
