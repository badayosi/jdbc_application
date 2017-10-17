package kr.or.dgit.jdbc_application_teacher.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnCancel;
	protected AbstractContent<?> pContent;
	protected AbstractList pList;
	private JButton btnOk;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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

		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		pBtn.add(btnOk);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		pList = createList();
		pList.setPopupMenu(createPopupMenu());
		contentPane.add(pList, BorderLayout.CENTER);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popUpMenu = new JPopupMenu();

		JMenuItem delItem = new JMenuItem("삭제");
		JMenuItem updateItem = new JMenuItem("수정");
		JMenuItem searchlItem = new JMenuItem("검색");

		delItem.addActionListener(this);
		updateItem.addActionListener(this);
		searchlItem.addActionListener(this);

		popUpMenu.add(delItem);
		popUpMenu.add(updateItem);
		popUpMenu.add(searchlItem);
		return popUpMenu;
	}

	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract AbstractContent<?> createContent();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			if (e.getActionCommand().equals("추가")) {
				btnOkActionPerformed(e);
			}
			if (e.getActionCommand().equals("수정")) {
				// 실제 수정
				// 1. pConent에서 입력된 내용(DTO)을 가져옴
				Object content = pContent.getContent();
				// 2. 입력된 DTO를 service를 이용해서 DB에 update
				updateContent(content);
				// 3. pList에서 목록을 새로 load
				pList.loadData();
				// 4. pContent 입력된 내용 Clear
				pContent.clear();
				// 5. btn "수정" -> "추가"
				btnOk.setText("추가");
			}
			if (e.getActionCommand().equals("확인")) {
				// 1. pContent내용을 clear
				// 2. pContent내용을 setEnable()
				pContent.clear();				
				// 3. btn "확인" -> "추가"
				btnOk.setText("추가");
			}
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getActionCommand().equals("삭제")) {
			// 1. 리스트에서 선택된 ITem을 가져와서
			Object content = pList.getSelectedItem();
			// 2. service에서 delete호출
			deleteContent(content);
			// 3. 삭제되고 난 후 목록을 다시 load
			pList.loadData();
		}
		if (e.getActionCommand().equals("수정")) {
			// 1. 리스트에서 선택된 content를 가져와서
			Object content = pList.getSelectedItem();
			// 2. 가져온 content를 pContent에 setContent();
			pContent.changeContent(content, "수정");
			// 3. 버튼의 글자를 "추가"->"수정"
			btnOk.setText("수정");
		}
		if (e.getActionCommand().equals("검색")) {
			// 1. 다이얼로그 상자를 띄워서 사원번호, 부서번호, 직책번호를 가져와서
			// 2. 해당하는 번호로 service에서 검색한 content를 가져옴
			// 3. 검색된 content를 pContent.setContent()
			// 4. pContent setEnable(false);
			pContent.changeContent(messageBox(), "검색");
			// 5. btn -> "확인"
			btnOk.setText("확인");
			
		}
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pContent.clear();
		btnOk.setText("추가");
	}

	protected void btnOkActionPerformed(ActionEvent e) {
		// 0. 공백체크
		try {
			pContent.isEmptyCheck();
		} catch (Exception e1) {
			//JOptionPane.showMessageDialog(null, e1.getMessage());
			return;
		}
		// 1. pConent에서 입력된 내용(DTO)을 가져옴
		Object content = pContent.getContent();
		// 2. 입력된 DTO를 service를 이용해서 DB에 insert
		insertContent(content);
		// 3. pList에서 목록을 새로 load
		pList.loadData();
		// 4. pContent 입력된 내용 Clear
		pContent.clear();
	}

	protected abstract Object messageBox();
	
	protected abstract void insertContent(Object content);

	protected abstract void deleteContent(Object content);

	protected abstract void updateContent(Object content);
}
