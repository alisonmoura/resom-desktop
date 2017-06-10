package com.resom.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HomeScene extends Scene {

	static VBox painel = new VBox();

	public HomeScene(Palco palco) {
		
		super(painel, 800, 500);
		
		Text titulo = new Text("Resom");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));
		
		Button btnNovoCliente = new Button("Novo Cliente");
		btnNovoCliente.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				palco.irParaFormCliente();
			}
		});
		
		Button btnListarClientes= new Button("Listar Clientes");
		btnListarClientes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				palco.irParaListaCliente();
			}
		});
		
		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, btnNovoCliente, btnListarClientes);
		
	}
}
