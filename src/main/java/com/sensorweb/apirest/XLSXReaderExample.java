/*
 * package com.sensorweb.apirest;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.util.Iterator; import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class XLSXReaderExample { public static void main(String[] args) { try
 * { File myFile = new File("C:\\docs\\Refrigerador_-Divisão.xlsx");
 * FileInputStream fis = new FileInputStream(myFile);
 * 
 * XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
 * 
 * XSSFSheet mySheet = myWorkBook.getSheetAt(0);
 * 
 * Iterator<Row> rowIterator = mySheet.iterator();
 * 
 * while (rowIterator.hasNext()) { Row row = rowIterator.next(); Iterator<Cell>
 * cellIterator = row.cellIterator();
 * 
 * while (cellIterator.hasNext()) { Cell cell = cellIterator.next();
 * 
 * switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
 * System.out.print(cell.getStringCellValue() + "\t"); break;
 * 
 * case Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue() +
 * "\t"); break; case Cell.CELL_TYPE_BOOLEAN:
 * System.out.print(cell.getBooleanCellValue() + "\t"); break; default: } }
 * System.out.println(""); }
 * 
 * } catch (
 * 
 * Exception e) { e.printStackTrace(); } } }
 */