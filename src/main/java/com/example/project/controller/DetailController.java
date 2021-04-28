package com.example.project.controller;

import com.example.project.entity.Detail;
import com.example.project.resource.DetailExcelExporter;
import com.example.project.resource.DetailsExcelExporter;
import com.example.project.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DetailController {

    String[] nameMapping = {
            "detail_id",
            "architectureDiagram",
            "associatesContributing",
            "brmCP",
            "codeReference",
            "contextualMaster",
            "crmId",
            "customerAccount",
            "demoVideo",
            "domain",
            "endDate",
            "gt",
            "innovationCategory",
            "innovistaChampion",
            "kpi",
            "lob",
            "personas",
            "pov",
            "productOwners",
            "productType",
            "startDate",
            "status",
            "tag",
            "tcsSolution",
            "technology",
            "title",
            "topProspectiveCustomers",
            "crowdSourcingChampion",
            "isu",
            "subIsu",
            "github",
            "screenShot",
            "TPC",
            "description"
    };
    String[] csvHeader = {
            "Id",
            "Architecture Diagram",
            "Associates Contributing",
            "BRM/CP",
            "Code Reference",
            "Contextual Master",
            "CRM Id",
            "Customer Account",
            "Demo Video",
            "Domain",
            "End Date",
            "G&T Story",
            "Innovation Category",
            "Innovista Champion",
            "KPI",
            "LOB",
            "Personas",
            "POV",
            "Product Owners",
            "Product Type",
            "Start Date",
            "Status",
            "Tag",
            "Tcs Solution",
            "Technology",
            "Title",
            "Top Prospective Customers",
            "Crowd Sourcing Champion",
            "ISU",
            "subIsu",
            "github",
            "screenShot",
            "TPC",
            "description"
    };
    @Autowired
    private DetailService service;

    // GET methods
    @GetMapping("/detail")
    public List<Detail> findAllDetails() {
        return service.listDetails();
    }
    @GetMapping("/detail/searchByIndustry/{industry}") // Domain
    public List<Detail> searchDetailsByIndustry(@PathVariable String industry ) {
        return service.searchByIndustry(industry);
    }
    @GetMapping("/detail/searchByLob/{lob}")
    public List<Detail> searchDetailsByLob(@PathVariable String lob) {
        return service.searchByLob(lob);
    }
    @GetMapping("/detail/searchByTechnology/{tech}")
    public List<Detail> searchByTechnology(@PathVariable String tech) {
        return service.searchByTechnology(tech);
    }
    @GetMapping("/detail/searchByKpi/{kpi}")
    public List<Detail> searchByKpi(@PathVariable String kpi) {
        return service.searchByKpi(kpi);
    }
    @GetMapping("/detail/searchByTag/{tag}")
    public List<Detail> searchByTag(@PathVariable String tag) {
        return service.searchByTag(tag);
    }
    @GetMapping("/detail/searchBy/startDateRange/{from}/{to}")
    public List<Detail> searchByStartDateRange(@PathVariable String from,@PathVariable String to) {
        return service.startDate(from,to);
    }
    @GetMapping("/detail/searchBy/endDateRange/{from}/{to}")
    public List<Detail> searchByEndDateRange(@PathVariable String from,@PathVariable String to) {
        return service.endDate(from,to);
    }
    @GetMapping("/detail/CrowdsourcingParterWise")
    public List<Object> crowdsourcingParterWises(){
        return service.crowd();
    }
    @GetMapping("/detail/DGTechnologyLandscape")
    public List<Object> dgTechnologyLandscape() {
        return service.dgTech();
    }
    @GetMapping("/detail/LOBview")
    public List<Object> lobView() {
        return service.lobView();
    }
    @GetMapping("/detail/PocStatus")
    public List<Object> pocStatus(){
        return service.pocStatus();
    }
    @GetMapping("/detail/{id}")
    public Detail searchDetailsById(@PathVariable int id) {
        return service.searchById(id);
    }
    @GetMapping("/detail/searchByTitle/{title}")
    public Detail searchDetailByTitle(@PathVariable String title){
        return service.searchByTitle(title);
    }
    @GetMapping("/detail/export/excel")
    public void exportToExcel( HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("MM-ddyyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Detail> details = service.listDetails();
        DetailsExcelExporter excelExporter = new DetailsExcelExporter(details);
        excelExporter.export(response);
    }
    @GetMapping("/detail/export/excel/{id}")
    public void exportToExcelId(@PathVariable int id,HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("MM-ddyyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        Detail detail = service.searchById(id);
        DetailExcelExporter excelExporter = new DetailExcelExporter(detail);
        excelExporter.export(response);
    }

    @GetMapping("/detail/export/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Detail> details = service.listDetails();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(csvHeader);
        for (Detail detail : details) {
            csvWriter.write(detail, nameMapping);
        }
        csvWriter.close();
    }
    @GetMapping("/detail/export/csv/{id}")
    public void exportToCSVId(@PathVariable int id,HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        Detail detail = service.searchById(id);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(csvHeader);
        csvWriter.write(detail, nameMapping);
        csvWriter.close();
    }
    // POST method
    @PostMapping("/detail")
    public Detail addDetails(@RequestBody Detail detail) {
        return service.saveDetail(detail);
    }

    @PostMapping("/detail/all")
    public List<Detail> addAllDetails(@RequestBody List<Detail> details){
        return service.saveAllDetails(details);
    }

    @PutMapping("/detail")
    public Detail updateDetails(@RequestBody Detail detail) {
        return service.updateDetail(detail);
    }

    @DeleteMapping("/detail/{id}")
    public String deleteDetails(@PathVariable int id){
        service.deleteDetail(id);
        return "The content deleted successfully";
    }
}
