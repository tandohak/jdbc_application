package jdbc_application.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class SpinnerComponent extends JPanel {

	private JSpinner spinner;

	public SpinnerComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		add(spinner);

	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}
	
	public void isEmptyCheck() throws Exception{
		if(getSpinner().equals("")){
			spinner.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	public int getSpinerValue() {		
		return (int)spinner.getValue();
	}
}
