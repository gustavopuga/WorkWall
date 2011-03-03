package br.com.workwall.client;

import java.util.List;

import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.layout.HLayout;

public class CardWall extends HLayout {

	private List<String> stepsNames;

	public CardWall() {
		
		this.setMembersMargin(50);
		this.setMargin(5);
		this.setWidth100();
		this.setHeight100();
//		this.setBorder("10px solid blue");
//		this.setBackgroundColor("#abcde");
		
//		addMember(new Button("Bot&atilde;o"));

	}

	public void addStepsColumn(String... stepsName) {
		for (String stepName : stepsNames) {
			addStepColumn(stepName);
		}
	}

	public void addStepColumn(String stepName) {
		StepColumn column = new StepColumn(stepName);
		addStepColumn(column);
	}

	private void addStepColumn(StepColumn stepColumn) {
		this.addMember(stepColumn);
	}

}
