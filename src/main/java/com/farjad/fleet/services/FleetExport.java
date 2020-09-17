package com.farjad.fleet.services;

import com.farjad.fleet.dao.VehicleRepository;
import com.farjad.fleet.model.Vehicle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Locale;

@Service
public class FleetExport {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    MessageSource messageSource;

    public ByteArrayInputStream vehicleListToExcelFile(Locale locale) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook ();
            addVehiclesSheet (workbook , locale);
            addGPSInfoSheet (workbook , locale);
            addDriversSheet (workbook,locale);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
            workbook.write (outputStream);
            return new ByteArrayInputStream (outputStream.toByteArray ());
        } catch (IOException ex) {
            ex.printStackTrace ();
            return null;
        }
    }

    private void addVehiclesSheet(XSSFWorkbook workbook , Locale locale) {

        Iterable<Vehicle> vehicles = vehicleRepository.findAll ();
        Sheet sheet = workbook.createSheet (
                messageSource.getMessage (
                        "pasmand.excel.auto_info" , null , locale));
        String lang = locale.getLanguage ();
        if (lang.equalsIgnoreCase ("fa") ||
                lang.equalsIgnoreCase ("ar")) {
            sheet.setRightToLeft (true);
        }
        addVehiclesSheetHeaders (workbook , sheet , locale);

        // Creating data rows for each customer
        vehicles.forEach (vehicle -> {
                    Row dataRow = sheet.createRow (sheet.getLastRowNum () + 1);
                    dataRow.createCell (0).setCellValue (
                            vehicle.getDevice ().getUniqueID ());
                }
        );


    }

    private void addVehiclesSheetHeaders(XSSFWorkbook workbook , Sheet sheet ,
                                         Locale locale) {
        String vehicleSheetHeaderNames[] = {
                messageSource.getMessage ("pasmand.excel.radif" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.vin" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.job" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.vehicle_name" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.vehicle_type" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.man_year" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.plaque_4" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.plaque_3" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.plaque_2" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.plaque_1" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_name" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.imei" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.vehicle_health_cert" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.body_no" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.system_type" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.chassis_no" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.fuel_type" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.fuel_rate" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.fuel_tank_cap" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.num_cylindar" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.num_axles" , null , locale) ,
                messageSource.getMessage ("pasmand.excel.num_wheels" , null , locale) ,
        };
        Row topRow = sheet.createRow (0);
        for (int col = 0 ; col < vehicleSheetHeaderNames.length ; col++) {
            Cell cell = topRow.createCell (col);
            cell.setCellValue ("");

            sheet.autoSizeColumn (col);
        }

        //creating top merged row
        sheet.addMergedRegion (
                new CellRangeAddress (0 , 0 , 6 , 9));
        topRow.getCell (6).setCellValue (messageSource.getMessage (
                "pasmand.excel.plaque" , null , locale));
        topRow.getCell (6).setCellStyle (getTopRowCellStyle (workbook));
        sheet.addMergedRegion (
                new CellRangeAddress (0 , 0 , 13 , 21));

        topRow.getCell (13).setCellValue (messageSource.getMessage (
                "pasmand.excel.vehicle_info" , null , locale));
        topRow.getCell (13).setCellStyle (getTopRowCellStyle (workbook));
        Row row = sheet.createRow (1);

        // Creating header
        CellStyle headerCellStyle = getHeaderStyle (workbook);
        for (int col = 0 ; col < vehicleSheetHeaderNames.length ; col++) {
            Cell cell = row.createCell (col);
            cell.setCellValue (vehicleSheetHeaderNames[col]);
            cell.setCellStyle (headerCellStyle);
            sheet.autoSizeColumn (col);
        }


    }

    private void addGPSInfoSheet(XSSFWorkbook workbook , Locale locale) {
        Sheet sheet = workbook.createSheet (
                messageSource.getMessage (
                        "pasmand.excel.gps_info" , null , locale));
        String lang = locale.getLanguage ();
        if (lang.equalsIgnoreCase ("fa") ||
                lang.equalsIgnoreCase ("ar")) {
            sheet.setRightToLeft (true);
        }
        addGPSInfoHeaders (workbook , sheet , locale);
    }

    private void addGPSInfoHeaders(XSSFWorkbook workbook , Sheet sheet ,
                                   Locale locale) {
        String gpsInfoSheetHeaderNames[] = {
                messageSource.getMessage ("pasmand.excel.radif" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.simNumber" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.sim_owner" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.sim_provider" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.gps_serial" ,
                        null ,
                        locale) ,
                messageSource.getMessage ("pasmand.excel.equipment_type" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.gsp_provider" ,
                        null , locale) ,
        };
        Row row = sheet.createRow (1);

        // Creating header
        CellStyle headerCellStyle = getHeaderStyle (workbook);
        CreationHelper createHelper = workbook.getCreationHelper ();
        for (int col = 0 ; col < gpsInfoSheetHeaderNames.length ; col++) {
            Cell cell = row.createCell (col);
            cell.setCellValue (createHelper.
                    createRichTextString (gpsInfoSheetHeaderNames[col]));
            cell.setCellStyle (headerCellStyle);
            sheet.autoSizeColumn (col);
        }

    }

    private CellStyle getTopRowCellStyle(Workbook workbook) {
        CellStyle topRowCellStyle = workbook.createCellStyle ();
        topRowCellStyle.setAlignment (HorizontalAlignment.CENTER);
        return topRowCellStyle;
    }

    private CellStyle getHeaderStyle(XSSFWorkbook workbook) {

        XSSFCellStyle headerCellStyle = workbook.createCellStyle ();
        headerCellStyle.setFillForegroundColor (IndexedColors.AQUA.getIndex ());
        headerCellStyle.setFillPattern (FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setAlignment (HorizontalAlignment.CENTER);
        headerCellStyle.setReadingOrder (ReadingOrder.RIGHT_TO_LEFT);
        return headerCellStyle;
    }
    private void addDriversSheet(XSSFWorkbook workbook , Locale locale){
        Sheet sheet = workbook.createSheet (
                messageSource.getMessage (
                        "pasmand.excel.driver_info" , null , locale));
        String lang = locale.getLanguage ();
        if (lang.equalsIgnoreCase ("fa") ||
                lang.equalsIgnoreCase ("ar")) {
            sheet.setRightToLeft (true);
        }
        addDriversSheetHeaders (workbook , sheet , locale);
    }
    private void addDriversSheetHeaders(XSSFWorkbook workbook , Sheet sheet ,
                                        Locale locale) {
        String driversSheetHeaderNames[] = {
                messageSource.getMessage ("pasmand.excel.radif" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_name" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_national_code" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_id" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_birth_date" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_address" ,
                        null , locale) ,
                messageSource.getMessage ("pasmand.excel.owner_phone_num" ,
                        null , locale) ,
        };
        Row row = sheet.createRow (0);

        // Creating header
        CellStyle headerCellStyle = getHeaderStyle (workbook);
        CreationHelper createHelper = workbook.getCreationHelper ();
        for (int col = 0 ; col < driversSheetHeaderNames.length ; col++) {
            Cell cell = row.createCell (col);
            cell.setCellValue (createHelper.
                    createRichTextString (driversSheetHeaderNames[col]));
            cell.setCellStyle (headerCellStyle);
            sheet.autoSizeColumn (col);
        }


    }
}
