package kr.or.dgit.jdbc_application_teacher.view;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application_teacher.content.AbstractContent;
import kr.or.dgit.jdbc_application_teacher.content.TitleContent;
import kr.or.dgit.jdbc_application_teacher.dto.Title;
import kr.or.dgit.jdbc_application_teacher.list.AbstractList;
import kr.or.dgit.jdbc_application_teacher.list.ListTitle;
import kr.or.dgit.jdbc_application_teacher.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
	private TitleContent pContent;
	
	public ViewTitle(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();		
	}
}
