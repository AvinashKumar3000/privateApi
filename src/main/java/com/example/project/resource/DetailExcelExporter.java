package com.example.project.resource;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.example.project.entity.Detail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DetailExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Detail detail;

    public DetailExcelExporter(Detail detail) {
        this.detail = detail;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("POC Details");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        createCell(row, 0, "detail_id", style);
        createCell(row, 1, "Architecture Diagram", style);
        createCell(row, 2, "Associates Contributing Topocs", style);
        createCell(row, 4, "BRM/CP", style);
        createCell(row, 6, "Contextual Master", style);
        createCell(row, 7, "CRM Id", style);
        createCell(row, 8, "Crowd Sourcing Champion", style);
        createCell(row, 9, "Customer Account", style);
        createCell(row, 10, "Demo Video", style);
        createCell(row, 11, "Domain", style);
        createCell(row, 12, "End Date", style);
        createCell(row, 14, "G&T Story", style);
        createCell(row, 15, "Innovation Category", style);
        createCell(row, 16, "Innovista Champion", style);
        createCell(row, 17, "KPI", style);
        createCell(row, 18, "LOB", style);
        createCell(row, 19, "Personas", style);
        createCell(row, 20, "POV", style);
        createCell(row, 22, "Product Owners", style);
        createCell(row, 23, "Product Type", style);
        createCell(row, 24, "Start Date", style);
        createCell(row, 25, "Status", style);
        createCell(row, 26, "Tag", style);
        createCell(row, 27, "Tcs Solution", style);
        createCell(row, 28, "Technology", style);
        createCell(row, 29, "Title", style);
        createCell(row, 30, "Top Prospective Customers", style);
        createCell(row, 31, "ISU", style);
        createCell(row, 32, "subIsu", style);
        createCell(row, 33, "github", style);
        createCell(row, 34, "screenShot", style);
        createCell(row, 36,"Description",style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        Row row = sheet.createRow(rowCount++);
        int columnCount = 0;
        createCell(row, columnCount++, detail.getDetail_id(),style);
        createCell(row, columnCount++, detail.getTitle(),style);
        createCell(row, columnCount++, detail.getDomain(),style);
        createCell(row, columnCount++, detail.getLOB(),style);
        createCell(row, columnCount++, detail.getPersonas(),style);
        createCell(row, columnCount++, detail.getKPI(),style);
        createCell(row, columnCount++, detail.getSolution(),style);
        createCell(row, columnCount++, detail.getTag(),style);
        createCell(row, columnCount++, detail.getStartDate(),style);
        createCell(row, columnCount++, detail.getEndDate(),style);
        createCell(row, columnCount++, detail.getProductType(),style);
        createCell(row, columnCount++, detail.getStatus(),style);
        createCell(row, columnCount++, detail.getTechStack(),style);
        createCell(row, columnCount++, detail.getDemoVideoOrImage(),style);
        createCell(row, columnCount++, detail.getPov(),style);
        createCell(row, columnCount++, detail.getArchitecture(),style);
        createCell(row, columnCount++, detail.getTopProspectiveCustomers(),style);
        createCell(row, columnCount++, detail.getInnoCategory(),style);
        createCell(row, columnCount++, detail.getStory(),style);
        createCell(row, columnCount++, detail.getCrm(),style);
        createCell(row, columnCount++, detail.getCustAccount(),style);
        createCell(row, columnCount++, detail.getProductOwners(),style);
        createCell(row, columnCount++, detail.getContextualMaster(),style);
        createCell(row, columnCount++, detail.getInnovistaChampion(),style);
        createCell(row, columnCount++, detail.getCrowdSourcingChampionOrDP(),style);
        createCell(row, columnCount++, detail.getBrmorCP(),style);
        createCell(row, columnCount++, Long.toString( detail.getAssociatesContributingToPOCs() ),style);
        createCell(row, columnCount++, detail.getIsu(), style);
        createCell(row, columnCount++, detail.getSubIsu(), style);
        createCell(row, columnCount++, detail.getGithub(), style);
        createCell(row, columnCount++, detail.getScreenShot(), style);
        createCell(row, columnCount++, detail.getDescription(), style);
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}


