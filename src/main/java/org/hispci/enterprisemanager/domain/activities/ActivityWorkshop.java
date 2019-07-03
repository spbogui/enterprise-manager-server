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

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ActivityWorkshop extends Activity {
    @ManyToOne
    @JoinColumn(nullable = false)
    private Location location;
    @Column(nullable = false)
    private String placeName;
}
