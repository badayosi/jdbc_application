package kr.or.dgit.jdbc_application_teacher.common;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboComponent<T> extends JPanel {
	private JComboBox<T> combo;

	public ComboComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		combo = new JComboBox<>();
		add(combo);
	}

	public int getSelectedIndex(){
		return combo.getSelectedIndex();
	}
	

	@SuppressWarnings("unchecked")
	public T getSelectedItem(){
		return (T)combo.getSelectedItem();
	}
	
	public void setSelectedIndex(int index){
		combo.setSelectedIndex(index);
	}
	
	public void setSelectedItem(T item){
		combo.setSelectedItem(item);
	}

	public void setComboBoxModel(Vector<T> lists){
		ComboBoxModel<T> model = new DefaultComboBoxModel<>(lists);
		combo.setModel(model);
	}
	
	public JComboBox<T> getCombo() {
		return combo;
	}
	
	public void isEmptyCheck() throws Exception{
		if (combo.getSelectedIndex()==-1){
			combo.requestFocus();
			throw new Exception("선택 하지 않음");
		}
	}

	public void setEnable(boolean isEnable) {
		combo.setEnabled(isEnable);		
	}
}




