package kr.or.dgit.jdbc_application_teacher.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnCancel;
	private AbstractContent<?> pContent;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("추가");
		pBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		AbstractList pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
	}

	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract AbstractContent<?> createContent();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e){
		pContent.clear();
	}
}
