/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLCadastroFuncionarioController implements Initializable {
	
	
	
	@FXML
	private Label LabelFuncionarioNome;
	@FXML
	private Label LabelFuncionarioSobrenome;
	@FXML
	private Label LabelFuncionarioCPF;
	@FXML
	private Label LabelFuncionarioCREF;

	@FXML
	private TextField TextFieldFuncionarioNome;
	@FXML
	private TextField TextFieldFuncionarioSobrenome;
	@FXML
	private TextField TextFieldFuncionarioCPF;
	@FXML
	private TextField TextFieldFuncionarioCREF;

	@FXML
	private Button buttonConfirmar;
	@FXML
	private Button buttonCancelar;
	@FXML
	private Button buttonAlternarAluno;
   
	private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
	private Funcionario funcionario;
	
	
	
    public Stage getDialogStage() {
		return dialogStage;
	}



	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}



	public boolean isButtonConfirmarClicked() {
		return buttonConfirmarClicked;
	}



	public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
		this.buttonConfirmarClicked = buttonConfirmarClicked;
	}



	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@FXML
	public void handleButtonConfirmar() {
		
		if (validarEntradaDeDados()) {
			funcionario.setNome(TextFieldFuncionarioNome.getText());
			funcionario.setSobrenome(TextFieldFuncionarioSobrenome.getText());
			funcionario.setMatricula(TextFieldFuncionarioCPF.getText());
			funcionario.setTelefone(TextFieldFuncionarioCREF.getText());

			buttonConfirmarClicked = true;
			dialogStage.close();
		}
	}
	
	 public void handleButtonCancelar() {
	        getDialogStage().close();
	    }


	@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
