package com.ecxel;

import java.io.File;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class Excel {


//################################################################################################### 
    //  Function to Read Data from XL and store in Array .....
//###################################################################################################
public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception
    {
        String[][] tabArray=null;
        System.out.println(" in the excel function .....");;
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            System.out.println("xl file found....");
            Sheet sheet = workbook.getSheet(sheetName); 
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            System.out.println("BreakPoint...");
            startCol=tableStart.getColumn();
            System.out.println("startRow...."+ startRow);
            System.out.println("startCol...."+startCol);
            Cell tableEnd= sheet.findCell(tableName+"End");                
            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                    "startCol="+startCol+", endCol="+endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;
            for (int i=startRow+1;i<endRow;i++,ci++)
            {
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
            }
            }
        return(tabArray);
    }


}
