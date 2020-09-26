package com.farjad.fleet.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="selection_values")
public @Data
class SelectionValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    private String accountId;
    @Column
    private String category;
    @Column
    private String value;
    @Column
    private String labelKey;
}
