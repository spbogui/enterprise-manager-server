package org.hispci.enterprisemanager.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data @NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Column(nullable = false)
    protected Date dateCreated = new Date();
    protected Date dateChanged;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "creator", nullable = false)
//    protected String creator;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "changed_by")
//    protected String changedBy;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "retired_by")
//    protected String retiredBy;
    @Column(nullable = false)
    protected Boolean retired = false;
    protected Date dateRetired;
    protected String retireReason;
    @Column(nullable = false, unique = true, length = 36)
    protected String uuid = UUID.randomUUID().toString();

//    @PrePersist
//    public void onPrePersist(){
//        this.creator = SecurityContextHolder.getContext().getAuthentication().getName();
//    }
//
//    @PreUpdate
//    public void onPreUpdate() {
//        if (retired) {
//            this.retiredBy = SecurityContextHolder.getContext().getAuthentication().getName();
//            this.dateRetired = new Date();
//            return;
//        }
//        this.changedBy = SecurityContextHolder.getContext().getAuthentication().getName();
//        this.dateChanged = new Date();
//
//    }
}
