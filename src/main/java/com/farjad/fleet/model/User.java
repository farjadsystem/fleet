package com.farjad.fleet.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data
class User {
    @Id
    @Column
    private String userId;
    @Column
    private String accountId;
}
