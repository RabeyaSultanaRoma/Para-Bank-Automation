package com.util;

public class HandleExampleTableData {
	public int getActualRow(String value) {
		String row = value.split("_")[0];
		String actualRowNumber = row.replace("Row", "");
		int rowNo= Integer.parseInt(actualRowNumber);
		//System.out.println(rowNo);
		return rowNo;
	}
	public int getActualCol(String value) {
		String col = value.split("_")[1];
		String actualColNumber = col.replace("Col", "");
		int colNo= Integer.parseInt(actualColNumber);
		//System.out.println(colNo);
		return colNo;
	}
	public static void main(String[] args) {
		String value = "Row2_Col1";
		HandleExampleTableData obj = new HandleExampleTableData();
		obj.getActualRow(value);
		obj.getActualCol(value);
	}
}
