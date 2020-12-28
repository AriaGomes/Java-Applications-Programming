package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class ClientChatUI extends Application
{
	    @FXML
	    private GridPane gridPane;

	    @FXML
	    private RowConstraints connectionRow;

	    @FXML
	    private RowConstraints messageRow;

	    @FXML
	    private RowConstraints chatRow;

	    @FXML
	    private Pane connectionPane;

	    @FXML
	    private Pane messagePane;

	    @FXML
	    private Pane chatPane;

	    
	    /** Places content in a bordered pane with a title. */
	    class BorderedTitledPane extends StackPane {
	      BorderedTitledPane(String titleString, Node content) {
	        Label title = new Label(" " + titleString + " ");
	        title.getStyleClass().add("bordered-titled-title");
	        StackPane.setAlignment(title, Pos.TOP_CENTER);

	        StackPane contentPane = new StackPane();
	        content.getStyleClass().add("bordered-titled-content");
	        contentPane.getChildren().add(content);

	        getStyleClass().add("bordered-titled-border");
	        getChildren().addAll(title, contentPane);
	      }
	    }

	@Override
	public void start(Stage clientWindow) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"));
		clientWindow.setScene(new Scene(root, 588, 500));
		
		
		clientWindow.show();
	}		
	
}



