package mediabiblioteket;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{
	
	static Stage stage;
	static Scene scene;

	@Override
	public void start(Stage main) throws IOException {
	    
		stage=main;
		Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));//loading FXML
		scene = new Scene(root, 400, 150);  //setting size of the window 
		stage.setScene(scene);  // setting scene
		stage.setTitle("Authorizing page"); //Title of the window
		stage.setResizable(false); //Making window non resizable
		stage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
		stage.show();  //Showing window
	}
	
	private void closeWindowEvent(WindowEvent event) {
        System.out.println("Window close request");
        alertOnExit();
        System.exit(0);
    }
	
	public void changeScene() {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("GUI.fxml"));//loading FXML
			Scene scene = new Scene(root,500,750);  //setting size of the window 
			stage.setScene(scene);  // setting scene
			stage.setTitle("Mediabiblioteket"); //Title of the window
			stage.setY(50);
			stage.setResizable(false); //Making window non resizable
			stage.show();  //Showing window
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void alertOnExit() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("Application is closing now");
		alert.setContentText("Hope to see you again!");

		alert.showAndWait();
	}
	
	public static void main(String[] args){
		launch();
    }



}	