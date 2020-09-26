package com.farjad.fleet;

import com.farjad.fleet.dao.VehicleRepository;
import com.farjad.fleet.model.Account;
import com.farjad.fleet.model.Device;
import com.farjad.fleet.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
public class VehicleRepositoryTest {
    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    public void testGetAll() {
        Iterator<Vehicle> iterator = vehicleRepository.findAll ().iterator ();
        while (iterator.hasNext ()) {
            Vehicle vehicle = iterator.next ();
            Device device = vehicle.getDevice ();
            Account account = vehicle.getAccount ();
            System.out.println ("deviceId = " + device.getDeviceId () +
                    "  imei-->" + device.getUniqueID ()+" accountID="+
                    account.getAccountID ());

        }
    }
    @Test void testFindByAccount(){
        Iterator<Vehicle> iterator = vehicleRepository.findByAccount (
                "pakanfard2").iterator ();
    }
}
