package dad.calculadoraIMC;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class imc {
	
	private DoubleProperty peso = new SimpleDoubleProperty();
	private DoubleProperty altura = new SimpleDoubleProperty();
	private DoubleProperty imc = new SimpleDoubleProperty();
	
	
	public void calcularimc() {
		
		double kg = peso.get();
		double cm = altura.get() / 100;
		
		if (kg > 0  && cm > 0) {
			
			double imc = kg / (cm * cm);
			this.imc.set(imc);
		}
		
		
	}
	
	
	public imc(){
		
		altura.addListener((o, ov,nv) -> calcularimc()); 
		peso.addListener((o, ov,nv) -> calcularimc()); 
	}


	public DoubleProperty pesoProperty() {
		
		return peso;
		
	}
	
	
	public DoubleProperty alturaProperty() {
		
		return altura;
		
	}

	public DoubleProperty imcProperty() {
		
		return imc;
		
	}


	public Double getPeso() {
		return peso.get();
	}


	public void setPeso(Double peso) {
		this.peso.set(peso); 
	}
	
	public Double getaltura() {
		return altura.get();
	}


	public void setaltura(Double altura) {
		this.altura.set(altura); 
	}
	
	
}
