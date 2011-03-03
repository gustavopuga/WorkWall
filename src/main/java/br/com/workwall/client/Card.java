package br.com.workwall.client;

import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class Card extends HLayout implements DoubleClickHandler {

	private HTMLFlow label;
	private boolean editable;
	private EditLayout editLayout;
	
	public Card() {
		this("");
	}

	public Card(String content) {

		this.label = new HTMLFlow(content);
		this.label.setWidth100();
		this.label.setOverflow(Overflow.HIDDEN);
		
		this.editLayout = new EditLayout(this);
		this.editLayout.setVisible(false);
		
		this.addMember(label);
		this.addMember(editLayout);
		
		this.defineStyleComponent();
		this.addDoubleClickHandler(this);
		
	}
	
	private void defineStyleComponent() {
		
		this.setCanDrag(true);
		this.setCanDrop(true);
		this.setDragAppearance(DragAppearance.TRACKER);

		this.setPadding(5);
		this.setMargin(10);
		this.setShowEdges(true);
//		this.setBackgroundColor(Color.WHITESMOKE);
//		this.setEdgeBackgroundColor(Color.WHITESMOKE);
//		this.setEdgeImage("edges/gray/3.png");

		this.setEdgeSize(3);
		this.setEdgeOffset(10);
		this.setWidth100();
		this.setAutoHeight();
	} 
	
	public HTMLFlow getLabel() {
		return label;
	}

	public void setLabel(HTMLFlow label) {
		this.label = label;
	}

	public EditLayout getEditLayout() {
		return editLayout;
	}

	public void setEditLayout(EditLayout editLayout) {
		this.editLayout = editLayout;
	}

	public void setEditCard(boolean editable){
		label.setVisible(!editable);
		editLayout.setVisible(editable);
	}
	
	public void onDoubleClick(DoubleClickEvent event) {
		
		String contents = label.getContents();
		label.setContents(editLayout.getContents());
		editLayout.setContents(contents);
		
		editable = !editable;
		setEditCard(editable);
		
		this.redraw();
		
	}


}
