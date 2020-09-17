package com.farjad.fleet.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Device")
public @Data class Device implements Serializable {
    @Id
    @Column(name="deviceID")
    String deviceId;
    @Column(name="comment")
    private String comment;
    @Column(name="last_comment_date")
    private String lastCommentDate;
    @Column(name = "uniqueID")
    private String uniqueID;


}