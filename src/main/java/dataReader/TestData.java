package dataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 * Read/write data from TestData (.xls/.xlsx) file
 * @author Harisha.P
 */
public class TestData {
	private static TestData getInstance=null;
	private TestData(){}
	public TestData getInstance() {
		if (getInstance == null) 
			getInstance = new TestData();
		return getInstance;
	}
	
	private static String sheetName = "Sheet1";
	private static String file = PropertyReader.read("test.dataPath");
	private static Map<String, String> map = new HashMap<>();
	
	/**
	 * Get the testData of a input testcase
	 * @author Harisha.P
	 * @param testName
	 * @param columnName
	 * @return testData of a input testcase
	 * @throws IOException
	 */
	public static String get(String testName, String columnName) throws IOException {
		FileInputStream fis;
		int targetCol = 0;
		
		fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheet(sheetName);
		int rows = ws.getPhysicalNumberOfRows();
		for (int rowNum = 0; rowNum < rows; rowNum++) {
			int cols = ws.getRow(0).getPhysicalNumberOfCells();
			for (int colNum = 0; colNum < cols; colNum++) {
				if (ws.getRow(rowNum).getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase(columnName)) {
					targetCol = colNum;
				}
				map.put(ws.getRow(rowNum).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""),
						ws.getRow(rowNum).getCell(targetCol, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
			}
		}
		wb.close();
		return map.get(testName);
	}
}
