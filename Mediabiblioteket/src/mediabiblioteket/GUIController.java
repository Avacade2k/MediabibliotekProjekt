package mediabiblioteket;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class GUIController implements Initializable{
	
	LibraryController theController;
	
	@FXML
	RadioButton radioID, radioTitle, radioAll;
	ToggleGroup group;
	
	@FXML
	TextField searchInput;
	
	@FXML
	ListView<String> textArea;
	
	public ObservableList<String> items;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		group = new ToggleGroup();
		radioAll.setSelected(true);
		
		radioAll.setToggleGroup(group);
		radioTitle.setToggleGroup(group);
		radioID.setToggleGroup(group);
	}
	
	public void search() {
		String theInput = searchInput.getText();
		items = FXCollections.observableArrayList();
		theController = new LibraryController(this);
		textArea = new ListView<>();
		textArea.setItems(items); 
		textArea.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		if(theController.checkUserInput(theInput))
		{
			clearTheTextArea();
			if(radioID.isSelected())
			{
				if(theController.checkInputOnlyDigits(theInput))
				{
					Media temp = theController.getMedia(theInput);
					theController.mediaSearchResults.add(temp);
					if(temp!=null)
						addElement(temp.toString());
				}
			}
			else if(radioTitle.isSelected())
			{
				theController.searchMediaTitleByString(theInput);
			}
			else if(radioAll.isSelected())
			{
				theController.searchMediaAllByString(theInput);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The textbox contains incorrect characters");
		}
	}
	
	public void showBorrowed() {
		clearTheTextArea();
		theController.searchBorrowed();
	}
	
	public void borrow() {
		
	}
	
	public void showInfo() {
		
	}
	
	public void clearTheTextArea()
	{
		items.clear();
		textArea.setItems(items);
	}
	
	public void addElement(String element) {
		System.out.println(element);
		items.add(element);
		textArea.setItems(items);
	}
}
