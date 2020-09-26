package com.farjad.fleet.dao;

import com.farjad.fleet.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle,
        Long> {
    @Query("select v from Vehicle v join fetch v.device where v.account" +
            ".accountID=?1")
    List<Vehicle> findByAccount(String accountID);
}
