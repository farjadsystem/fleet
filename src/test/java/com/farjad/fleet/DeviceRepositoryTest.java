package com.farjad.fleet;

import com.farjad.fleet.dao.DeviceRepository;
import com.farjad.fleet.dao.VehicleRepository;
import com.farjad.fleet.model.Device;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
public class DeviceRepositoryTest {

    @Autowired
    DeviceRepository deviceRepository;

    @Test
    void testGetAll() {
        Iterator<Device> iterator = deviceRepository.findAll ().iterator ();
        while (iterator.hasNext ()) {
            Device device = iterator.next ();
            System.out.println ("deviceId = " + device.getDeviceId ());
        }
    }
}
