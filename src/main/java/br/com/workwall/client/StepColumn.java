package br.com.workwall.client;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.HeaderControls;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Positioning;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public class StepColumn extends Window{

	private VLayout cardArea;
	private VLayout cardLayout;
	
	public StepColumn(String name) {

	    super.setWidth100();
        super.setHeight100();
        super.setCanDragReposition(false);
        super.setTitle("<div style='font-size:12px'>" + name + "</div>");
        super.setHeaderControls(HeaderControls.HEADER_LABEL);
        super.addItem(createCardLayout());
        
        for (int i = 0; i < 4; i++) {
			addCard(new Card("Test " + name + " " + i));
		}

	}
	
	private Layout createCardLayout(){
		
		cardLayout = new VLayout();
		cardLayout.setWidth100();
		cardLayout.setHeight100();
		cardLayout.setAlign(Alignment.CENTER);
		cardLayout.setAlign(VerticalAlignment.CENTER);
		cardLayout.setOverflow(Overflow.AUTO);
	    
	    Canvas lineThicknessCanvas = new Canvas();
	    lineThicknessCanvas.setBackgroundColor("#C0C0C0");
	    
	    cardArea = new VLayout();
	    cardArea.setMargin(15);
//	    cardArea.setCanDrag(true);
	    cardArea.setCanAcceptDrop(true);
	    cardArea.setDropLineThickness(2);
	    cardArea.setDropLineProperties(lineThicknessCanvas);
	    cardArea.setWidth100();
	    cardArea.setHeight100();
	    
	    cardLayout.addMember(cardArea);
	    return cardLayout;
	}
	
	public void addCard(Card card) {
		cardArea.addMember(card);
	}
	
}
