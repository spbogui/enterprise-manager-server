package org.hispci.enterprisemanager.domain.activities;

import lombok.*;
import org.hispci.enterprisemanager.domain.locations.Location;

import javax.persistence.*;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ActivitySupervision extends Activity {
    @NonNull
    @ManyToMany
    @JoinTable(name = "activity_supervision_places",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Collection<Location> places;
    @OneToMany(mappedBy = "activitySupervision")
    private Collection<ActivitySupervisionStep> activitySupervisionSteps;
}
