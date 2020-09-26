package com.farjad.fleet.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data
class Account {
    @Id
    @Column
    private String accountID;

}
