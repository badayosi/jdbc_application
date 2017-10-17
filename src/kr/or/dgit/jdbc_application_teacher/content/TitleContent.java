package kr.or.dgit.jdbc_application_teacher.content;

import java.awt.GridLayout;

import kr.or.dgit.jdbc_application_teacher.common.TextFieldComponent;
import kr.or.dgit.jdbc_application_teacher.dto.Title;

@SuppressWarnings("serial")
public class TitleContent extends AbstractContent<Title> {

	private TextFieldComponent pTitleNo;
	private TextFieldComponent pTitleName;

	public TitleContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleNo = new TextFieldComponent("직책 번호");
		add(pTitleNo);
		
		pTitleName = new TextFieldComponent("직책 명");
		add(pTitleName);
	}

	@Override
	public Title getContent(){
		int titleNo = Integer.parseInt(pTitleNo.getTextValue());
		String titleName = pTitleName.getTextValue();
		return new Title(titleNo, titleName);
	}
	
	@Override
	public void setContent(Title title){
		pTitleNo.setTextValue(title.getTitleNo()+"");
		pTitleName.setTextValue(title.getTitleName());
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pTitleNo.isEmptyCheck();
		pTitleName.isEmptyCheck();
	}
	
	@Override
	public void clear(){
		pTitleNo.setTextValue("");
		pTitleName.setTextValue("");
		pTitleNo.setEnable(true);
		pTitleName.setEnable(true);
	}

	@Override
	public void changeContent(Object content, String order) {
		if(order.equals("수정")){
			setContent((Title)content);
			pTitleNo.setEnable(false);
		}
		if(order.equals("검색")){
			setContent((Title)content);
			pTitleNo.setEnable(false);
			pTitleName.setEnable(false);
		}
	}
}










