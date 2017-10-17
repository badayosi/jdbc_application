package kr.or.dgit.jdbc_application_teacher.view;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.content.TitleContent;
import kr.or.dgit.jdbc_application_teacher.dto.Title;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import kr.or.dgit.jdbc_application_teacher.list.ListTitle;
import kr.or.dgit.jdbc_application_teacher.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
	
	public ViewTitle(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return (AbstractContent<Title>) pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertTitle((Title)content);
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteTitle((Title)content);
	}

	@Override
	protected void updateContent(Object content) {
		service.updateTitle((Title)content);
	}

	@Override
	protected Object messageBox() {
		return service.selectTitleByNo(new Title(Integer.valueOf(JOptionPane.showInputDialog("찾으실 직책번호를 입력하세요"))));
	}
}
