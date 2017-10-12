package jdbc_application.common;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFiledComponent extends JPanel {
	private JTextField textField;

	public TextFiledComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}
	
	public String getTextValue(){		
		return textField.getText();
	}
	
	public void setTextValue(String value){
		textField.setText(value);
	}

	public JTextField getTextField() {
		return textField;
	}
	
	public void isEmptyCheck() throws Exception{
		if(getTextValue().equals("")){
			textField.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	

}
