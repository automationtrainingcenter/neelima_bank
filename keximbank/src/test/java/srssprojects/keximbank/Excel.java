package srssprojects.keximbank;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class Excel {
	static Workbook book;
	static Sheet sh;

	// initialize excel file to read the data
	public static void setExcelToRead(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(".//Data//" + fileName);
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// get num of rows
	public static int getRowCount() {
		return sh.getRows();
	}

	// get num of columns
	public static int getColumnCount() {
		return sh.getColumns();
	}

	// read data
	public static String readData(int rnum, int cnum) {
		return sh.getCell(cnum, rnum).getContents();
	}

	// reads all data of the excel file and retuns that data a 2D string array
	public static String[][] getExcelData(String fileName, String sheetName) {
		setExcelToRead(fileName, sheetName);
		int nor = getRowCount();
		int noc = getColumnCount();
		String[][] data = new String[nor - 1][noc];
		for (int r = 1; r < nor; r++) {
			for (int c = 0; c < noc; c++) {
				data[r-1][c] = readData(r, c);
			}
		}
		return data;
	}

	// close the file
	public static void closeFile() {
		book.close();
	}

}
