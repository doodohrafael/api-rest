package com.sensorweb.apirest.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.sensorweb.apirest.domain.model.Dado;

public class DadoHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Ts", "Dado" };
	static String SHEET = "[Ambiente] Armazém 03";

	public static boolean verificarXlsx(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Dado> importarDadosXlsx(InputStream is) {
		try {
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);
			System.out.println(sheet.getSheetName());
			Iterator<Row> rows = sheet.iterator();
			List<Dado> dados = new ArrayList<Dado>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				Dado dado = new Dado();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						DataFormatter dataFormatter = new DataFormatter();
						String formattedCellStr = dataFormatter.formatCellValue(currentCell);
						dado.setTs(formattedCellStr);
						break;
					case 1:
						dado.setDado(currentCell.getNumericCellValue());
						break;
					default:
						break;
					}
					cellIdx++;
				}
				dados.add(dado);
			}
			workbook.close();
			return dados;
		} catch (IOException e) {
			throw new RuntimeException("Falha ao analisar o arquivo do Excel: " + e.getMessage());
		}
	}
}