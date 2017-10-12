package jdbc_application.common;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ComboBoxComponent<T> extends JPanel {

	private JComboBox<T> comboBox;

	public ComboBoxComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		comboBox = new JComboBox<>();
	
		add(comboBox);
	}


	public void setComboBoxModel(Vector<T> lists){
		ComboBoxModel<T> Model = new DefaultComboBoxModel<>(lists);
		comboBox.setModel(Model);
	}
	
	public int getSelectedIndex(){
		return comboBox.getSelectedIndex();
	}
	
	public void setSelectedIndex(int idx){
		comboBox.setSelectedIndex(idx);
	}
	
	public void setSelectedItem(T item){
		comboBox.setSelectedItem(item);
	}
	
	public T getSelectedItem(){		
		return (T)comboBox.getSelectedItem();
	}
	
	public JComboBox<T> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<T> comboBox) {
		this.comboBox = comboBox;
	}
}
