package jdbc_application.list;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbstractList extends JPanel {
	protected JTable table;

	public AbstractList() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
//		loadData();
	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);

		setAlignWidth();
	}
	
	protected abstract void setAlignWidth();

	protected void setCellWidth(int...witdh) {
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i=0; i<witdh.length; i++){
			cModel.getColumn(i).setPreferredWidth(witdh[i]);
		}
	}

	protected void setAlign(int align, int ...idx ) {
		//0번 컬럼을 정렬(Left, Right, Center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i=0; i<idx.length; i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}	
	}

	protected abstract String[] getColumnNames();

	protected abstract Object[][] getData();
	
	public abstract Object getSelectedItem();

}
