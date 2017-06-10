package com.resom.view;

import com.resom.controller.ClienteController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Palco extends Application {
	
	private Stage palco;
	private ClienteController clienteController = new ClienteController();
	private Scene home = new HomeScene(this);
	private Scene formCliente = new FormClienteScene(this, clienteController);
	private Scene listaCliente = new ListaClienteScene(this, clienteController);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage palco) throws Exception {
		this.palco = palco;
		
		palco.setScene(home);
		palco.setTitle("Resom");
		palco.show();

	}
	
	public void irParaHome(){
		palco.setScene(home);
	}
	
	public void irParaFormCliente(){
		palco.setScene(formCliente);
	}
	
	public void irParaListaCliente(){
		palco.setScene(listaCliente);
	}

}
