package mytableexample2;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
//#1

import javax.swing.event.*;
import javax.swing.table.TableModel;

public class MyTableExample2 extends javax.swing.JFrame implements TableModelListener {

    public MyTableExample2() {
        initComponents();       
    }
    
    //#1
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        // Do something with the data...
        System.out.println(data.toString());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(
                    TableCellRenderer renderer, int row, int col) {
                if (col == 0) {
                    return this.getTableHeader().getDefaultRenderer()
                        .getTableCellRendererComponent(this,
                        this.getValueAt(row, col), false, false, row, col);
                } else {
                    return super.prepareRenderer(renderer, row, col);
                }
            }        
        };
        jTable1.setAutoCreateRowSorter(false);
       // final JTableHeader header = jTable1.getTableHeader();
       // header.setDefaultRenderer(new HeaderRenderer(jTable1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Row 1", "Data 2", "Data 3", "Data 4", "Data 5"},
                {"Row 2", "Data 6", "Data 7", "Data 8", "Data 9"},
                {"Row 3", "Data 10", "Data 11", "Data 12", "Data 13"}
            },
            new String [] {
                "", "Col 1", "Col 2", "Col 3", "Col 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
       
        //#1
        jTable1.getModel().addTableModelListener(this);
        
        //#2
        /*TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = jTable1.getColumnModel().getColumn(i);
            if (i == 2) {
                column.setPreferredWidth(100); //third column is bigger
            } else {
                column.setPreferredWidth(50);
            }
        }*/
        
        //#3
        jTable1.setRowHeight(100);


        //Netbeans generated layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }


    public static void main(String args[]) {
        try {
            //THIS SETS TO SYSTEM'S LOOK AND FEEL
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );

            //THIS SETS TO OTHER JAVA LOOK AND FEEL
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

        } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(MyTableExample2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(MyTableExample2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(MyTableExample2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(MyTableExample2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyTableExample2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}

class HeaderRenderer implements TableCellRenderer {
TableCellRenderer renderer;
    public HeaderRenderer(JTable jTable1) {
        renderer = jTable1.getTableHeader().getDefaultRenderer();
    }
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        return renderer.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, col);
    }
}