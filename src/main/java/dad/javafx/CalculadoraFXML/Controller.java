package dad.javafx.CalculadoraFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller extends Application {

	private Model model = new Model();
	private boolean puesto = false;
	private String operar;
	private double valor;
	

	@FXML
	private GridPane root;

	@FXML
	private Button unoButton, dosButton, tresButton, ceButton, cButton, cuatroButton, cincoButton, seisButton,
			multiButton, divButton, sieteButton, ochoButton, nueveButton, menosButton, puntoButton, masButton,
			igualButton, ceroButton;

	@FXML
	private TextField valorText;
	

	public TextField getValorText() {
		return valorText;
	}

	public void setValorText(TextField valorText) {
		this.valorText = valorText;
	}

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
		loader.setController(this);
		loader.load();
		
	//	model.CuadroTextoProperty().bind(valorText.getValorText().textProperty());
		
	

	}
	
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(root, 500, 400);

		primaryStage.setTitle("Calculadora FXML");
		primaryStage.setScene(scene);
		primaryStage.show();

		unoButton.setOnAction(e -> unoButtonAction(e));
		dosButton.setOnAction(e -> dosButtonAction(e));
		tresButton.setOnAction(e -> tresButtonAction(e));
		cuatroButton.setOnAction(e -> cuatroButtonAction(e));
		cincoButton.setOnAction(e -> cincoButtonAction(e));
		seisButton.setOnAction(e -> seisButtonnAction(e));
		sieteButton.setOnAction(e -> sieteButtonAction(e));
		ochoButton.setOnAction(e -> ochoButtonAction(e));
		nueveButton.setOnAction(e -> nueveButtonAction(e));
		ceroButton.setOnAction(e -> ceroButtonAction(e));

		ceButton.setOnAction(e -> ceButton(e));
		cButton.setOnAction(e -> cButton(e));
		multiButton.setOnAction(e-> multiButton(e));
		divButton.setOnAction(e-> divButton(e));
		menosButton.setOnAction(e-> menosButton(e));
		igualButton.setOnAction(e-> igualButton(e));
		masButton.setOnAction(e-> masButton(e));
		puntoButton.setOnAction(e-> puntoButton(e));

		
		
	}
	
	

	private void puntoButton(ActionEvent e) {
		if (puesto == false) {
			if (valorText.getText().isEmpty()) {
				valorText.setText("0.");
			} else {
				valorText.setText(valorText.getText() + ".");
			}
			puesto = true;
		}
	}

	private void masButton(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operar = "suma";
			valor = Double.parseDouble(valorText.getText());
			valorText.setPromptText("+");
			valorText.setText("");
			puesto = false;
		}
	}

	private void igualButton(ActionEvent e) {
		try {
			double segundo = Double.parseDouble(valorText.getText());
			double resultado;

				switch (operar) {
				case "suma":
					resultado = valor + segundo;
					valorText.setText(String.valueOf(resultado));
					break;
				case "resta":
					resultado = valor - segundo;
					valorText.setText(String.valueOf(resultado));
					break;
				case "multi":
					resultado = valor * segundo;
					valorText.setText(String.valueOf(resultado));
					break;
				case "divi":
					resultado = valor / segundo;
					valorText.setText(String.valueOf(resultado));
					break;

				}
			} catch ( java.lang.NumberFormatException e1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Fallo al operar");
				alert.setContentText("No se puede operar sin elementos");
				alert.showAndWait();
			}
	}

	private void menosButton(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operar = "resta";
			valor = Double.parseDouble(valorText.getText());
			valorText.setPromptText("-");
			valorText.setText("");
			puesto = false;
		}
	}

	private void divButton(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operar = "divi";
			valor = Double.parseDouble(valorText.getText());
			valorText.setPromptText("/");
			valorText.setText("");
			puesto = false;
		}
	}

	private void multiButton(ActionEvent e) {
		if (!valorText.getText().isEmpty()) {
			operar = "multi";
			valor = Double.parseDouble(valorText.getText());
			valorText.setPromptText("*");
			valorText.setText("");
			puesto = false;
		}
	}

	private void cButton(ActionEvent e) {
		try {
			String nuevo = valorText.getText();
			nuevo = nuevo.substring(0, nuevo.length() - 1);
			valorText.setText(nuevo);
		} catch (java.lang.StringIndexOutOfBoundsException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fallo al borrar");
			alert.setContentText("No borres un elemento vacio");
			alert.showAndWait();
		}
	}

	private void ceButton(ActionEvent e) {
		valorText.setText("");
		puesto = false;
		valor = 0;
		operar = null;
		valorText.setPromptText("0.0");
	}
	
	
	
	
	

	private void ceroButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("0");
		} else {
			valorText.setText(valorText.getText() + "0");
		}
	}

	private void nueveButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("9");
		} else {
			valorText.setText(valorText.getText() + "9");
		}
	}

	private void ochoButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("8");
		} else {
			valorText.setText(valorText.getText() + "8");
		}
	}

	private void sieteButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("7");
		} else {
			valorText.setText(valorText.getText() + "7");
		}
	}

	private void seisButtonnAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("6");
		} else {
			valorText.setText(valorText.getText() + "6");
		}
	}

	private void cincoButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("5");
		} else {
			valorText.setText(valorText.getText() + "5");
		}
	}

	private void cuatroButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("4");
		} else {
			valorText.setText(valorText.getText() + "4");
		}
	}

	private void tresButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("3");
		} else {
			valorText.setText(valorText.getText() + "3");
		}
	}

	private void dosButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("2");
		} else {
			valorText.setText(valorText.getText() + "2");
		}
	}

	private void unoButtonAction(ActionEvent e) {
		if (valorText.getText().isEmpty()) {
			valorText.setText("1");
		} else {
			valorText.setText(valorText.getText() + "1");
		}
	}

	public static void main(String[] args) {

		launch(args);
	}

}
