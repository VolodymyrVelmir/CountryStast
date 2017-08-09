package zad1;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class CountryTable {
	String countriesFileName=null;
	int IntConstantColun=4,MaxElement=20,CastElement=4;
	CountryTable(String countriesFileName){
		this.countriesFileName=countriesFileName;
	}

	public JTable create() throws IOException {
		String  TextMemory[][]=new String[MaxElement-1][IntConstantColun-1];
		Object  TextTaitlMemory[]=new String[MaxElement];
		int IntMemory[]=new int [MaxElement];
		ImageIcon icons[]=new ImageIcon[MaxElement];
		icons[0]=new ImageIcon("data/1.jpg");
		icons[1]=new ImageIcon("data/2.jpg");
		icons[2]=new ImageIcon("data/3.jpg");
		
		int X=0,Y=0;
		BufferedReader istream;
		 List<String> tokens = new ArrayList<String>();
		 istream = new BufferedReader(new FileReader(countriesFileName));
             while (istream.ready()) {
                 for (String token: istream.readLine().split("    ")) {
                     if (token.trim().length() > 0) {
                    	 if(Y==0){
                    		 TextTaitlMemory[X]=(String)token;
                    	 }else{
                    		 if(X==2){
                    			 IntMemory[Y-1]=ToInt(token);
                    		 }else{
                    			 TextMemory[Y-1][X]=(String)token; 
                    		 }
                    	 }
                         tokens.add(token);
                         X++;
                     }
                     if(X>=CastElement-1){
                         X=0;
                         Y++;
                      }
                 }
             }
             istream.close();
             TextTaitlMemory[IntConstantColun-1]="Flags";
             String [] Flag={"data/1.jpg","data/2.jpg","data/3.jpg"}; 
          JTable jP=null;
          
          final AbstractTableModel nModel = new nDataModel(MaxElement,TextTaitlMemory,icons);
          jP = new JTable( nModel);
    
         jP.setPreferredScrollableViewportSize(new Dimension(250, 100));
         for(int ii=0;ii<CastElement-1;ii++){  //Add slots
            nModel.setValueAt(TextMemory[ii][0], ii, 0);
            nModel.setValueAt(TextMemory[ii][1], ii, 1);
            nModel.setValueAt(IntMemory[ii], ii, 2);
            nModel.setValueAt(new ImageIcon(Flag[ii]), ii, 3);
         }
         addElement(3,nModel,"Austria","Vienna", 6020,"data/4.jpg"); // add new Countrie
 
         jP.setDefaultRenderer(Object.class, new RenderSlot(nModel,4)); //Rendering slots
		return jP;
	}
   public int ToInt(String str){
	   return Integer.valueOf(str).intValue();
   }

	public boolean addElement(int row,AbstractTableModel nModel,String countries,String capital, int population,String Flag){
		if(CastElement+1<MaxElement){
			 nModel.setValueAt((String)countries,row,0);
			 nModel.setValueAt((String)capital,row,1);
			 nModel.setValueAt( population,row,2);
			 nModel.setValueAt(new ImageIcon(Flag),row,3);
		}
		return false;
				
	}
 

 
 
}
 