package com.farjad.fleet.controller;

import com.farjad.fleet.services.FleetExport;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

@Controller
public class ExportController {
    @Autowired
    FleetExport fleetExport;

    @RequestMapping(value = "download/fleet.xlsx")
    public void fleetExport(HttpServletResponse response,
                            @RequestParam String accountID)throws IOException {
        System.out.println ("fleet export called");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; " +
                "filename=fleets.xlsx");
        ByteArrayInputStream stream =
                fleetExport.vehicleListToExcelFile (accountID,new Locale ("fa"));
        IOUtils.copy(stream, response.getOutputStream());
    }
    @RequestMapping(value = "fleet")
    public String fleet(){
        return "fleet";
    }

}
