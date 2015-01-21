package mytableexample2;


import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javax.swing.event.*;
import javax.swing.table.TableModel;

/**
 * @version 1.0 11/09/98
 */
public class finalTest extends JFrame implements TableModelListener{
	
	Object temp[][]=new Object[10][15];
	
	public Object[][] getData()
	{
		return temp;
	}
	
	 public void tableChanged(TableModelEvent e) {
	        int row = e.getFirstRow();
	        int column = e.getColumn();
	        TableModel model = (TableModel)e.getSource();
	        String columnName = model.getColumnName(column);
	        Object data = model.getValueAt(row, column);

	        // Do something with the data...
	        temp[row][column]=data;
	        System.out.println(data.toString());
	    }
	
	finalTest() {
    super("test");
    

    
    
   
    String LO[] = new String[15];
    for(int i=0;i<LO.length;i++)
    {
        LO[i]="";
    }
    for(int i=1;i<LO.length;i++)
    {
    	//LO[i]=new String("L"+Integer.toString(i));
    	
    	try
    	{
    		BufferedReader ip1 = new BufferedReader(new FileReader(new File("./data/col.txt")));
    		String line=null;

    		int lNumber=1;
    		while((line= ip1.readLine()) != null)
    		{
    			//System.out.println(line);
    			temp[0][lNumber]=line;	
    			lNumber++;
    		}
    	}
    	catch(Exception e)
    	{

    	}
    	
    }
    
    try
    {
    	BufferedReader ip1 = new BufferedReader(new FileReader(new File("./data/row.txt")));
     	String line=null;
     	
    	int lNumber=1;
     	while((line= ip1.readLine()) != null)
    	{
    		//System.out.println(line);
    		temp[lNumber][0]=line;	
    		lNumber++;
    	}
    }
    catch(Exception e)
    {
    	
    }
    
    
   

    DefaultTableModel dm = new DefaultTableModel(temp,
       LO) {
      public Class getColumnClass(int columnIndex) {
        return String.class;
      }
    };
   /* dm.setDataVector(new Object[][] { { "a\na", "b\nb", "c\nc" },
        { "A\nA", "B\nB", "C\nC" } }, new Object[] { "1", "2", "3" });*/

    JTable table = new JTable(dm);

    int lines = 15;
    table.setRowHeight(table.getRowHeight() * lines);

    //
    // table.setRowHeight(0);
    //
    // I got "java.lang.IllegalArgumentException: New row height less than
    // 1"
    //
    table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
    table.getModel().addTableModelListener(this);
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(1058, 878);
    setVisible(true);
    

    
  
  }

  public static void main(String[] args) throws IOException{
    final finalTest frame = new finalTest();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
    	Object x[][]=frame.getData();
    	
    	
    	//print data
    	/*for(int i=0;i<10;i++)
    	{
    		for(int j=0;j<15;j++)
    		{
    			System.out.print(x[i][j]+" ");
    		}
    		System.out.println();
    	}*/
    	
    	StringBuffer ip = new StringBuffer();
		FileWriter op=null;
		try {
			op = new FileWriter("./data/dataGen.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=1;i<10;i++)
		{
			for(int j=1;j<15;j++)
			{
				ip.append(x[i][j]+",");
			}
			ip.append("\n");
		}
		
		try {
			op.write(ip.toString());
			op.flush();
			op.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        System.exit(0);
      }
    });
  }
}

/**
 * @version 1.0 11/09/98
 */

class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

  public MultiLineCellRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setFont(table.getFont());
    if (hasFocus) {
      setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
      if (table.isCellEditable(row, column)) {
        setForeground(UIManager.getColor("Table.focusCellForeground"));
        setBackground(UIManager.getColor("Table.focusCellBackground"));
      }
    } else {
      setBorder(new EmptyBorder(1, 2, 1, 2));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}
