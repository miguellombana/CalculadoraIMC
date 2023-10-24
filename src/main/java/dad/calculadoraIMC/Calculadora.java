package dad.calculadoraIMC;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Calculadora extends Application {

	@Override

	public void start(Stage primaryStage) throws Exception {

		VBox Vbox1 = new VBox();
		VBox Vbox2 = new VBox();
		HBox Hbox1 = new HBox();
		HBox Hbox2 = new HBox();
		HBox Hbox3 = new HBox();
		TextField TextPeso = new TextField();
		TextField TextAltura = new TextField();
		Label result = new Label();
		Label resultimc = new Label();

		Vbox1.getChildren().addAll(Hbox1, Hbox2, Vbox2);
		Vbox1.setAlignment(Pos.CENTER);
		Vbox1.setSpacing(5);
		
		Hbox3.getChildren().addAll(new Label("Resultado imc = "), resultimc);
		Hbox3.setAlignment(Pos.CENTER);
		
		Hbox1.getChildren().addAll(new Label("Peso:  "), TextPeso, new Label(" kg"));
		Hbox1.setAlignment(Pos.CENTER);
		Hbox1.setSpacing(5);
		
		Hbox2.getChildren().addAll(new Label("Altura: "), TextAltura, new Label(" cm"));
		Hbox2.setAlignment(Pos.CENTER);
		Hbox2.setSpacing(5);
		
		
		Vbox2.getChildren().addAll(Hbox3, result);
		Vbox2.setAlignment(Pos.CENTER);
		Scene scene = new Scene(Vbox1, 700, 500);
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Calculadora IMC JavaFX");
		primaryStage.show(); 




		// BIndings

		imc imc1 = new imc();

		TextPeso.textProperty().bindBidirectional(imc1.pesoProperty(), new NumberStringConverter());
		TextAltura.textProperty().bindBidirectional(imc1.alturaProperty(), new NumberStringConverter());
		resultimc.textProperty().bindBidirectional(imc1.imcProperty(), new NumberStringConverter());
		imc1.imcProperty().addListener((o, ov, nv) -> {


	}

		);
		
		result.textProperty().bind(Bindings.createStringBinding(() -> {
			double imc = imc1.imcProperty().get();
			
			
			if(imc < 18.5) {
				
				return "Bajo peso";
			}else if (imc < 24.9) {
				
				return "Normal";
				
			}else if (imc < 29.9) {
				return "Sobrepeso";
			}else {
				return "Obeso";
			}
			
			
			
			
		},  imc1.imcProperty() ));
		
		

	}

}
