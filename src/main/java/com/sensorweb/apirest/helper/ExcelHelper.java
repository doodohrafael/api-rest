package com.sensorweb.apirest.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.sensorweb.apirest.domain.model.Ponto;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Xid", "Nome" };
	static String SHEET = "dadosdoponto";

	public static boolean verificarXlsx(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Ponto> importarDadosXlsx(InputStream is) {
		try {
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator(); 
			List<Ponto> pontos = new ArrayList<Ponto>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				Ponto ponto = new Ponto();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						ponto.setXid(currentCell.getStringCellValue());
						break;
					case 1:
						ponto.setNome(currentCell.getStringCellValue());
						break;
					default:
						break;
					}
					cellIdx++;
				}
				pontos.add(ponto);
			}
			workbook.close();
			return pontos;
		} catch (IOException e) {
			throw new RuntimeException("Falha ao analisar o arquivo do Excel: " + e.getMessage());
		}
	}
}