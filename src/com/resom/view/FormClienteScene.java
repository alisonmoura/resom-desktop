package com.resom.view;

import com.resom.controller.ClienteController;
import com.resom.model.Cliente;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FormClienteScene extends Scene {

	private static VBox painel = new VBox();
	private TextField inputNome;
	private TextField inputEmail;
	private TextField inputCpf;
	private TextField inputCelular;
	private Cliente cliente;

	public FormClienteScene(Palco palco, ClienteController clienteController) {

		super(painel, 800, 500);

		Text titulo = new Text("Novo Cliente");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));

		Button btnSalvar = new Button("Salvar");
		btnSalvar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cliente = new Cliente();
				cliente.setNome(inputNome.getText());
				inputNome.setText("");
				cliente.setEmail(inputEmail.getText());
				inputEmail.setText("");
				cliente.setCpf(inputCpf.getText());
				inputCpf.setText("");
				cliente.setCelular(inputCelular.getText());
				inputCelular.setText("");
				clienteController.cadastrar(cliente);
			}
		});
		
		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				palco.irParaHome();
			}
		});

		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, getCampoNome(), getCampoEmail(), getCampoCpf(), getCampoCelular(),
				btnSalvar, btnCancelar);

	}

	private HBox getCampoNome() {
		HBox linha = new HBox();
		Label label = new Label("Nome");
		label.setTextFill(Paleta.CONTRASTE);
		inputNome = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputNome);
		return linha;
	}

	private HBox getCampoEmail() {
		HBox linha = new HBox();
		Label label = new Label("Email");
		label.setTextFill(Paleta.CONTRASTE);
		inputEmail = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputEmail);
		return linha;
	}

	private HBox getCampoCpf() {
		HBox linha = new HBox();
		Label label = new Label("CPF");
		label.setTextFill(Paleta.CONTRASTE);
		inputCpf = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputCpf);
		return linha;
	}

	private HBox getCampoCelular() {
		HBox linha = new HBox();
		Label label = new Label("Celular");
		label.setTextFill(Paleta.CONTRASTE);
		inputCelular = new TextField();
		linha.setAlignment(Pos.CENTER);
		linha.setSpacing(10);
		linha.getChildren().addAll(label, inputCelular);
		return linha;
	}
	
}
