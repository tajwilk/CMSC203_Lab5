


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	
	Insets inset = new Insets(12);
	
	private Button hello;
	private Button howdy;
	private Button niHau;
	private Button konnichiwa;
	private Button clear;
	private Button exit;
	
	private Label feedback;
	
    private TextField outputField;
	
	//  declare two HBoxes
	
    private HBox topBox;
    private HBox bottomBox;
    
	//student Task #4:
	//  declare an instance of DataManager
    
    DataManager greetings;
    
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	/**
	 * 
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello = new Button("Hello");
		hello.setOnAction(new ButtonHandler());
		howdy = new Button("Howdy");
		howdy.setOnAction(new ButtonHandler());
		niHau = new Button("Chinese");
		niHau.setOnAction(new ButtonHandler());
		konnichiwa = new Button("Japanese");
		konnichiwa.setOnAction(new ButtonHandler());
		clear = new Button("Clear");
		clear.setOnAction(new ButtonHandler());
		exit = new Button("Exit");
		exit.setOnAction(new ButtonHandler());
		
		feedback = new Label("Feedback:");
		
	    outputField = new TextField();
		//  instantiate the HBoxes
	    
	    topBox = new HBox();
	    bottomBox = new HBox(); 
	    
		//student Task #4:
		//  instantiate the DataManager instance
	    
	    greetings = new DataManager();
	    
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
	    
	    bottomBox.getChildren().addAll(feedback, outputField);
	    bottomBox.setAlignment(Pos.CENTER);
	    
	    HBox.setMargin(feedback, inset);
	    HBox.setMargin(outputField, inset);
	    
		//  add the buttons to the other HBox
	    
	    topBox.getChildren().addAll(hello, howdy, niHau, konnichiwa, clear, exit);
	    
	    HBox.setMargin(hello, inset);
	    HBox.setMargin(howdy, inset);
	    HBox.setMargin(niHau, inset);
	    HBox.setMargin(konnichiwa, inset);
	    HBox.setMargin(clear, inset);
	    HBox.setMargin(exit, inset);
	    
	    topBox.setAlignment(Pos.CENTER);
	    
		//  add the HBoxes to this FXMainPanel (a VBox)
		
	    this.getChildren().addAll(topBox, bottomBox);
	    
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			EventTarget clickedButton = event.getTarget();

			if(clickedButton == exit) {
				Platform.exit();
				System.exit(0);
			}
			
			String output = "";
			
			if(clickedButton == hello) {
				output = greetings.getHello();
			} else if (clickedButton == howdy) {
				output = greetings.getHowdy();
			} else if (clickedButton == niHau) {
				output = greetings.getChinese();
			} else if (clickedButton == konnichiwa) {
				output = greetings.getJapanese();
			} else if (clickedButton == clear) {
				output = "";
			}
			
			outputField.setText(output);
			
		}
		
	}
	
}
	
