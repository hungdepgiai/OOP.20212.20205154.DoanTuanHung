package hust.soict.globalict.javafx;

import javafx.scene.paint.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;
	@FXML
	private RadioButton Pen;
	@FXML
	private RadioButton Eraser;
	 @FXML
	    private ToggleGroup identical;
	@FXML
	public void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	// Event Listener on Pane.onMouseDragged
	@FXML
	public void drawingAreaMouseDragged(MouseEvent event) {
		if(Pen.isSelected()) {
			Circle newCircle=new Circle(event.getX(),event.getY(),4,Color.BLACK);
			drawingAreaPane.getChildren().add(newCircle);
		}
		else if(Eraser.isSelected()) {
			Circle circle=new Circle(event.getX(),event.getY(),4,Color.WHITE);
			drawingAreaPane.getChildren().add(circle);
		}
			}
	
	
}
