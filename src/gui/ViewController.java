package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	// Código primeira aula:
//	@FXML
//	private TextField txtNumber1;
//	
//	@FXML
//	private TextField txtNumber2;
//	
//	@FXML
//	private Label labelResult;
//	
//	@FXML
//	private Button btSum;
//	
//	@FXML
//	public void onBtSumAction() {
//		try {
//		Locale.setDefault(Locale.US);
//		double number1 = Double.parseDouble(txtNumber1.getText());
//		double number2 = Double.parseDouble(txtNumber2.getText());
//		double sum = number1 + number2;
//		labelResult.setText(String.format("%.2f", sum));
//	
//		}
//		catch (NumberFormatException e) {
//			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
//			
//		}
//	}
	@FXML
	private ComboBox<Person> comboBoxPerson;
	
	@FXML
	private Button btAll;

	private ObservableList<Person> obsList;
	
	@FXML
	public void onBtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@mail.com"));
		list.add(new Person(2, "Alex", "alex@mail.com"));
		list.add(new Person(3, "Bob", "bob@mail.com"));

		obsList = FXCollections.observableArrayList(list);
		comboBoxPerson.setItems(obsList);

		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};

		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));
	}

}
