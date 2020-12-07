package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.application.Application;
import mediabiblioteket.GUIController;
import mediabiblioteket.LibraryController;
import mediabiblioteket.LoginController;

class mediabiblioteketTest {
	
	LoginController login;
	GUIController gui;
	LibraryController theController;
	
	@BeforeEach
	void setupGUI() {
		theController = new LibraryController();
		login = new LoginController();
		gui = new GUIController();
		Application.launch();
	}
	
	@AfterEach
    public void tearDown() throws Exception {
        System.exit(0);
    }
	
	@Test
	public void loginSuccessful() {
		login.user.setText("bob");
		login.login();
		assertTrue(login.isSuccessful());
	}
	
	@Test
	public void loginInvalid() {
		login.user.setText("bob");
		login.login();
		assertFalse(login.isSuccessful());
	}

}
