package br.com.workwall.client;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EditLayout extends VLayout{

	private RichTextEditor richTextEditor;
	private Card card;
	private IButton confirmButton;
	private IButton cancelButton;
	
	public EditLayout(Card card) {
		
		this.card = card;
		this.richTextEditor = new RichTextEditor();
		this.richTextEditor.setControlGroups("styleControls", "colorControls");
		this.richTextEditor.setMembersMargin(5);
		this.richTextEditor.setOverflow(Overflow.HIDDEN);
		this.richTextEditor.setPadding(5);
		this.richTextEditor.setBorder("1px solid #eeeeee");
		this.richTextEditor.setWidth100();
		this.richTextEditor.setHeight(80);
		
		this.cancelButton = new IButton("Cancelar");
		cancelButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				cancelAction();
			}
		});
		
		this.confirmButton = new IButton("Confirmar");
		confirmButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {	
				confirmAction();
			}
		});
		
		
		this.addMember(richTextEditor);
		this.addMember(generateButtonsLayout());
		this.setWidth100();
		this.setHeight100();
	}
	
	private Layout generateButtonsLayout() {
		
		HLayout buttonsLayout = new HLayout();
		buttonsLayout.setMargin(10);
		buttonsLayout.setMembersMargin(10);
		buttonsLayout.setAlign(Alignment.CENTER);
		buttonsLayout.setAlign(VerticalAlignment.CENTER);
		buttonsLayout.addMember(confirmButton);
		buttonsLayout.addMember(cancelButton);
		buttonsLayout.setWidth100();
		buttonsLayout.setAutoHeight();
		
		return buttonsLayout;
	}
	
	public void setContents(String contents){
		richTextEditor.setValue(contents);
	}
	
	public String getContents(){
		return richTextEditor.getValue();
	}
	
	private void confirmAction(){
		card.getLabel().setContents(richTextEditor.getValue());
		card.setEditCard(false);
	}
	
	private void cancelAction(){
		card.setEditCard(false);
	}
}
