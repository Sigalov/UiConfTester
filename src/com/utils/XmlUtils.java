package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Assert;

import com.kaltura.client.KalturaLogger;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;


public class XmlUtils {
	static KalturaLogger logger = KalturaLogger.getLogger(XmlUtils.class);

	public static Vector<Vector<XSSFCell>> importExcelSheet(File fileName)
	{

		Vector<Vector<XSSFCell>> cellVectorHolder = new Vector<Vector<XSSFCell>>();
		try
		{
			Workbook workBook = WorkbookFactory.create(new FileInputStream(fileName));
			Sheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rowIter = sheet.rowIterator();

			while(rowIter.hasNext())
			{
				XSSFRow row = (XSSFRow) rowIter.next();
				Iterator<Cell> cellIter = row.cellIterator();
				Vector<XSSFCell> cellStoreVector=new Vector<XSSFCell>();

				while(cellIter.hasNext())
				{
					XSSFCell cell = (XSSFCell) cellIter.next();
					cellStoreVector.addElement(cell);
				}
				cellVectorHolder.addElement(cellStoreVector);
			}
		}
		catch (Exception e)
		{
			logger.error("Couldn't load file - for more details, see log file", e);//Add path of log file
			logger.debug(e.getMessage());
		}
		if (!cellVectorHolder.isEmpty()){
			logger.info("UiConf configuration file: \"" + fileName + "\" was loaded successfully");
		}
		return cellVectorHolder;
	}

	public static void assertXMLEquals(String expectedXML, String actualXML) throws Exception {
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreAttributeOrder(true);

		DetailedDiff diff = new DetailedDiff(XMLUnit.compareXML(expectedXML, actualXML));

		List<?> allDifferences = diff.getAllDifferences();
		try {
			Assert.assertEquals("Differences found: "+ diff.toString(), 0, allDifferences.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void  computeDiff(String expectedXML, String actualXML) throws Exception {
		// Compute diff. Get the Patch object. Patch is the container for computed deltas.
//		List<String> original = fileToLines(convertStringToTempFile(expectedXML).getPath());
//		List<String> revised  = fileToLines(convertStringToTempFile(actualXML).getPath());
//
//		// Compute diff. Get the Patch object. Patch is the container for computed deltas.
////		Patch patch = DiffUtils.diff(original, revised);
//		   // At first, parse the unified diff file and get the patch
//        Patch patch = DiffUtils.parseUnifiedDiff(fileToLines(convertStringToTempFile(actualXML).getPath()));
//        
//        // Then apply the computed patch to the given text
//        List result = DiffUtils.patch(original, patch);
//        /// Or we can call patch.applyTo(original). There is no difference.
//
//		for (Delta delta: patch.getDeltas()) {
//			System.out.println(delta);
//		}
		StringUtils.difference(expectedXML, actualXML);
		
	}

	/**
	 * @param xmlString
	 */
	private static File convertStringToTempFile(String xmlString) {
		File temp = null;
		try {
		    // Create temp file.
		    temp = File.createTempFile("pattern", ".suffix");

		    // Delete temp file when program exits.
		    temp.deleteOnExit();

		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write(xmlString);
		    out.close();

		} catch (IOException e) {
			logger.error("DEBUG: Failed to convert XML to temp File in XmlUtil class");
			return null;
		}
		return temp;
		
	}
	// Helper method for get the file content
	private static List<String> fileToLines(String filename) {
		List<String> lines = new LinkedList<String>();
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public static void assertStringEquals(String expectedText, String actualText) throws Exception{
		Assert.assertEquals(expectedText, actualText);
	}
}
