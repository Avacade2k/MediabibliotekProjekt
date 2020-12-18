package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mediabiblioteket.GUIController;
import mediabiblioteket.LibraryController;
import mediabiblioteket.LoginController;
import mediabiblioteket.Main;

class mediabiblioteketTest {
	
	LoginController login = new LoginController();;
	GUIController gui = new GUIController();
	LibraryController theController = new LibraryController();
	
	@Before
	void startGUI() throws IOException {
		new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(Main.class);
            }
        }.start();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mediabiblioteket/Login.fxml"));
        fxmlLoader.setController(login);
		Scene scene = new Scene(fxmlLoader.load(),500,750);  //setting size of the window
		Stage testStage = new Stage();
		testStage.setScene(scene);
		testStage.show();
	}
	
	@After
    void tearDown() throws Exception {
		System.out.println("Ending");
		System.exit(0);
    }
	
	@Test
	public void loginSuccessful() {
		login.setUser("900118-5555");
		login.login();
		assertTrue(login.isSuccessful());
	}
	
	@Test
	public void loginInvalid() {
		login.setUser("bob");
		login.login();
		assertFalse(login.isSuccessful());
	}
	
	@Test
	public void searchMediaByString() {
		String test = "Bok";
		theController.searchMediaAllByString(test);
		assertTrue(gui.items != null);
	}

}
