package org.hispci.enterprisemanager.domain.activities;

import lombok.*;
import org.hispci.enterprisemanager.domain.employment.employees.Staff;
import org.hispci.enterprisemanager.domain.locations.Location;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class ActivityOrders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "sactivity_id", nullable = false)
    private Activity activity;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "structure_id", nullable = false)
    private Structure structure;
    @Column(nullable = false)
    private String route;
    @Column(nullable = false)
    private Date departureDate;
    @Column(nullable = false)
    private Date returnDate;
    @ManyToMany
    @JoinTable(name = "activity_orders_locations",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Collection<Location> places;


}
