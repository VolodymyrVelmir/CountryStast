package zad1;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class RenderSlot extends JTextPane implements TableCellRenderer {
	AbstractTableModel model;
	int maxFlagRender;
	 
	RenderSlot(AbstractTableModel model,int maxFlagRender){
		this. model= model;
		this.maxFlagRender=maxFlagRender;
	}

	 public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){
		 if(column==3 && row<maxFlagRender){
	     setText("");
	     table.setRowHeight(row, 50); 
	     insertIcon(( ImageIcon)model.getValueAt(row, 3));
	     setBackground(Color.WHITE);
	     return this;
		 }else{
			 if(column<2){
			 setText((String)model.getValueAt(row, column));
			 setBackground(Color.WHITE);
			 return this;
			 }else if(column==2 ){ 
			       if(isBigPopulation( model.getValueAt(row, column)) ){
			    	 setBackground(Color.red); 
			      }else{
			      	 setBackground(Color.WHITE);
			      }
			      if( model.getValueAt(row, column)!=null){
			    	 setText( toString(model.getValueAt(row, column))); 
			      }else{
			    	 setText( "");  
			      }
				 return this; 
			 }
		 }
		 return null;
	 }
	   public String toString(Object i){
		   return i+".00";
	   }
	   
	   public boolean isBigPopulation(Object population){
		   int i = population != null ? Double.valueOf(population.toString()).intValue() : 0;
		   if( i >20000){return true;}
		   return false;
	   }
	 
	 }


