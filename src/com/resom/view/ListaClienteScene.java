package com.resom.view;

import com.resom.controller.ClienteController;
import com.resom.model.Cliente;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ListaClienteScene extends Scene {

	static private VBox painel = new VBox();

	public ListaClienteScene(Palco palco, ClienteController clienteController) {
		super(painel, 800, 500);

		Text titulo = new Text("Clientes Cadastrados");
		titulo.setFill(Paleta.CONTRASTE);
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 50));

		TableView<Cliente> tabelaClientes = new TableView<Cliente>();

		TableColumn<Cliente, String> colNome = new TableColumn<>("Nome");
		colNome.setMinWidth(100);
		colNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));

		TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
		colEmail.setMinWidth(100);
		colEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));

		TableColumn<Cliente, String> colCpf = new TableColumn<>("CPF");
		colCpf.setMinWidth(100);
		colCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));

		TableColumn<Cliente, String> colCelular = new TableColumn<>("Celular");
		colCelular.setMinWidth(100);
		colCelular.setCellValueFactory(new PropertyValueFactory<Cliente, String>("celular"));

		tabelaClientes.setItems(FXCollections.observableArrayList(clienteController.buscarTodos()));
		tabelaClientes.getColumns().addAll(colNome, colEmail, colCpf, colCelular);

		Button btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				palco.irParaHome();
			}
		});

		Button btnAtualizar = new Button("Atualizar lista");
		btnAtualizar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tabelaClientes.setItems(FXCollections.observableArrayList(clienteController.buscarTodos()));
			}
		});

		painel.setAlignment(Pos.CENTER);
		painel.setSpacing(10);
		painel.setBackground(new Background(new BackgroundFill(Paleta.PRIMARIA, null, null)));
		painel.getChildren().addAll(titulo, tabelaClientes, btnVoltar, btnAtualizar);
	}

}
