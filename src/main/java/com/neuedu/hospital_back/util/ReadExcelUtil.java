package com.neuedu.hospital_back.util;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ReadExcelUtil {

    private static final String EXCEL_XLS = ".xls";
    private static final String EXCEL_XLSX = ".xlsx";


    public String getCellValue(Cell cell) {
        String ret = "";
        if (cell == null) return ret;
        CellType type = cell.getCellTypeEnum();
        switch (type) {
            case BOOLEAN:
                ret = String.valueOf(cell.getBooleanCellValue());
                break;
            case ERROR:
                ret = null;
                break;
            case FORMULA:
                Workbook wb = cell.getSheet().getWorkbook();
                CreationHelper crateHelper = wb.getCreationHelper();
                FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();
                ret = getCellValue(evaluator.evaluateInCell(cell));
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date theDate = cell.getDateCellValue();
                    ret = new SimpleDateFormat().format(theDate);
                } else {
                    ret = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
                break;
            case STRING:
                ret = cell.getRichStringCellValue().getString();
                break;
            default:
                ret = "";
        }

        return ret; // 有必要自行trim
    }

    /**
     * 判断excel的版本，并根据文件流数据获取workbook
     *
     * @throws IOException
     */
    public Workbook getWorkBook(InputStream is, File file) throws Exception {

        Workbook workbook = null;
        if (file.getName().endsWith(EXCEL_XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {
            workbook = new XSSFWorkbook(is);
        }

        return workbook;
    }

    /**
     * 校验文件是否为excel
     *
     * @throws Exception
     */
    public void checkExcelVaild(File file) throws Exception {
        String message;
        if (!file.exists()) {
            message = "文件不存在！";
            throw new Exception(message);
        }
        if (!file.isFile() || ((!file.getName().endsWith(EXCEL_XLS) && !file.getName().endsWith(EXCEL_XLSX)))) {
            System.out.println(file.isFile() + "===" + file.getName().endsWith(EXCEL_XLS) + "===" + file.getName().endsWith(EXCEL_XLSX));
            System.out.println(file.getName());
            message = "文件不是Excel";
            throw new Exception(message);
        }
    }

}