package org.hispci.enterprisemanager.domain.employment.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractTypeTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;
    @Column(nullable = false, unique = true)
    private String templateName;
    @Column(nullable = false)
    private String templateExtension;
    @Column(nullable = false)
    private String templateSize;
    @Column(nullable = false)
    private byte content;
    @Column(nullable = false)
    private ContractType contractType;
    @Column(length = 36, nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();
}
