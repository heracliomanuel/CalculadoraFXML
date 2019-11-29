package dad.javafx.CalculadoraFXML;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty CuadroTexto = new SimpleStringProperty();

	public final StringProperty CuadroTextoProperty() {
		return this.CuadroTexto;
	}
	

	public final String getCuadroTexto() {
		return this.CuadroTextoProperty().get();
	}
	

	public final void setCuadroTexto(final String CuadroTexto) {
		this.CuadroTextoProperty().set(CuadroTexto);
	}
	


	

	
}
