package com.farjad.fleet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vehicle",uniqueConstraints={@UniqueConstraint(columnNames="imei")
        ,@UniqueConstraint(columnNames="vehicle_VIN")})


public @Data
class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "imei", referencedColumnName = "uniqueID",nullable = true)
    private Device device;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="accountID")
    private Account account;
    @Column(name="vehicle_VIN")
    private String vin;
    @Column(name="info_type")
    private String infoType;
    @Column(name="region")
    private String region;
    @Column(name="area")
    private String area;
    @Column(name="job_category")
    private String jobCategory;
/*
    @Column(name="accountID")
    private String accountID;
*/
    @Column(name="vehicle_type")
    private String vehicleType;
    @Column
    private String job;
    @Column(name="plaque_p1")
    private String plaqueP1;
    @Column(name="plaque_p2")
    private String plaqueP2;
    @Column(name="plaque_p3")
    private String plaqueP3;
    @Column(name="plaque_p4")
    private String plaqueP4;
    @Column(name="vehicle_body_no")
    private String vehicleBodyNo;
    @Column(name="man_year",nullable = true)
    private Integer manYear;
    @Column(name="driver_name")
    private String driverName;
    @Column(name="driver_phone")
    private String driverPhone;
    @Column(name="driver_national_code")
    private String driverNationalCode;
    @Column(name="driver_address")
    private String driverAddress;
    @Column(name="driver_birth_date")
    private Date driverBirthDate;
    @Column(name="`driver_id_no`")
    private String driverIdNo;
    @Column(name="`fuel_type`")
    private String fuelType;
    @Column(name="fuel_rate")
    private Double fuelRate;
    @Column(name="fuel_tank_cap")
    private Integer fuelTankCap;
    @Column(name="num_wheels")
    private Integer numWheels;
    @Column(name="num_axles")
    private Integer numAxles;
    @Column(name="vehicle_name")
    private String vehicleName;
    @Column(name="num_cylinder")
    private Integer numCylinders;
    @Column(name="chassis_no")
    private Integer chassisNo;
    @Column(name="vehicle_health_cert")
    private String vehicleHealthCert;
    @Column(name="vehicle_system_type")
    private String vehicleSystemType;
    @Column(name="owner_name")
    private String ownerName;
    @Column(name="owner_national_code")
    private String ownerNationalCode;
    @Column(name="owner_id_no")
    private String ownerIdNo;
    @Column(name="owner_address")
    private String ownerAddress;
    @Column(name="motor_no")
    private String motorNo;
    private String comment;
    @Column(name="comment_date")
    private String lastCommentDate;
    @Column(name="status")
    private String status;


}
