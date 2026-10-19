package com.example;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ProjetoCalculadoraIMC extends Application {

    @Override 
    public void start (Stage palco){
        
        //Etiquetas pra os campos de entrada
        Label etiquetaPeso = new Label ("Peso");
        Label etiquetaAltura = new Label ("Altura");

        //Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");

        //Label para mostrar o resultado do IMC
        Label etiquetaResultado = new Label();

        //Botão para calcular o IMC
        Button botaoCalcular = new Button("Calcular IMC"); // Criando o botão.
        botaoCalcular.setOnAction (e -> {
            double peso = Double.parseDouble(campoPeso.getText()); // Transformando o texto(String) recebido em Double.
            double altura = Double.parseDouble(campoAltura.getText()); // Transformando o texto(String) recebido em Double.
            
            double imc = peso / (altura * altura);
            etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc)); //O Format recebe a String e transforma em ponto flutuante com duas casas após a virgula (2f)
        });

        //Layout vertical
        VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
        layout.setPadding(new Insets(10)); // espaçamento de 10px
        layout.setAlignment(Pos.CENTER); // alinhamento centro

        //Cena e Palco
        Scene cena = new Scene(layout, 300, 250);
        palco.setTitle("Projeto 01 - Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }

    public static void main (String[] args){
        launch(args);
    }
}
/* Observaçoes de melhorias
Tratamento de Exception
        try {
            //Peso
            //Altura
            //Calculo IMC
            //Resultado
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText ("Por favor, insira números válidos para peso e altura. ");
        }

Conversão para separação de casas decimais com virgula:

    double peso = Double.parseDouble(campoPeso.getText().replace(",","."))
    double altura = Double.parseDouble(campoAltura.getText().replace(",","."))

*/