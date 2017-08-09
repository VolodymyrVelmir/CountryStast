package zad1;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class nDataModel extends AbstractTableModel{
	static int  MaxElement=20;
	Object columnNames[] = { "", "" ,"",""};
	//static Object[][] tableData = { new Object[MaxElement], new Object[MaxElement], new Object[MaxElement] ,new  ImageIcon[MaxElement]};
 
	nDataModel(int MaxElement,Object columnNames[],ImageIcon icons[]){
		//this.MaxElement=MaxElement;
		this.columnNames=columnNames;
		for(int i=0; i<tableData[0].length;i++){
			tableData[3][i]=icons[i];
		}
		//static Object[][] tableData = { new Object[MaxElement], new Object[MaxElement], new Object[MaxElement] ,new  ImageIcon[MaxElement]};
 
	}
	
	 static Object[][] tableData = { new Object[MaxElement], new Object[MaxElement], new Object[MaxElement] ,new  ImageIcon[MaxElement]};

 
	public int getColumnCount() {
		return tableData.length;
	}

 
	public int getRowCount() {
		return tableData[0].length;
	}

 
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[columnIndex][rowIndex];
	}
	public void setValueAt(Object valiue,int rowIndex, int columnIndex) {
		tableData[columnIndex][rowIndex]=  valiue;
	 
		    fireTableCellUpdated(rowIndex, columnIndex);
	}

	  public String getColumnName(int column) {
	        return columnNames[column].toString();
	      }
	 
}
