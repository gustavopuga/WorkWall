package br.com.workwall.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


public class WorkWall implements EntryPoint{

	public void onModuleLoad() {
		
		CardWall cardWall = new CardWall();
//		cardWall.addStepsColumn("TO DO", "IN PROCESS", "TEST", "DONE");
		for (String stepName : new String[]{"TO DO", "IN PROCESS", "TEST", "DONE"}) {
			cardWall.addStepColumn(stepName);
		}
		
		RootPanel.get("colmeia").add(cardWall);
	}

}
