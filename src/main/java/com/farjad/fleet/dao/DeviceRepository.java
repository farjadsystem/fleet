package com.farjad.fleet.dao;
import com.farjad.fleet.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends PagingAndSortingRepository<Device,
        String> {
}