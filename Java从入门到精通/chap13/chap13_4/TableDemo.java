package chap13_4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableDemo extends JFrame{
	public TableDemo(){
		super("JTable��ʾ����");
		TableModel model=new TableModel();
		JTable table=new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(400, 200));
		JScrollPane scrollPane=new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	class TableModel extends AbstractTableModel{
		final String[] columnNames={"����","ѧ��","����","����","��Ա"};
		final Object[][] data={
				{"�Դ�Ԫ","S050107001",new Integer(23),"����",new Boolean(false)},
				{"��С��","S050107002",new Integer(22),"���",new Boolean(true)},
				{"���","S050107003",new Integer(23),"�Ϻ�",new Boolean(false)},
				{"��Զ��","S050107004",new Integer(23),"����",new Boolean(true)},
				{"������","S050107005",new Integer(24),"�㽭",new Boolean(false)},
				{"���","S050107006",new Integer(25),"����",new Boolean(true)},
		};
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		@Override
		public int getRowCount() {
			return data.length;
		}
		@Override
		public String getColumnName(int col){
			return columnNames[col];
		}
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int c){
			return getValueAt(0, c).getClass();
		}
		public boolean isCellEditable(int row,int col){
			if(col<2){
				return false;
			}else {
				return true;
			}
		}
		public void setValueAt(Object value,int row,int col){
			if(data[0][col] instanceof Integer&&!(value instanceof Integer)){
				try{
					data[row][col]=new Integer(value.toString());
					fireTableCellUpdated(row, col);
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(TableDemo.this, "The \""+getColumnName(col)+"\" ����ֻ������������");
				}
			}else {
				data[row][col]=value;
				fireTableCellUpdated(row, col);
			}
		}
	}
	public static void main(String[] args) {
		TableDemo frame=new TableDemo();
		frame.pack();
		frame.setVisible(true);
	}

}
