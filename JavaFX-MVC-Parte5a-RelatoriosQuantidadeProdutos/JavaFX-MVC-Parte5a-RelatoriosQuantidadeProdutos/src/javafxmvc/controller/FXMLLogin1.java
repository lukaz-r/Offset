package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxmvc.model.domain.Funcionario;

public class FXMLLogin1 implements Initializable {

	@FXML
	private TextField textfieldUsuario;

	@FXML
	private PasswordField textfieldSenha;

	@FXML
	private Button buttonLogin;
	
	private Stage dialogStage;
	private boolean buttonConfirmarclicked;
	private Funcionario funcionario;

	@FXML
	void BotaoConfirmar() {
	
		textfieldUsuario.getText();
		textfieldSenha.getText();
		
		
	buttonConfirmarclicked = true;
	dialogStage.close();
		
		
		

	}

	public Button getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(Button buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}