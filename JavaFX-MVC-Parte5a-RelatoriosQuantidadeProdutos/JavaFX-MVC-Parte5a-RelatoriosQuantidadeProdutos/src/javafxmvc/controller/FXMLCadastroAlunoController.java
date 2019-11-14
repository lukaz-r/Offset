
package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLCadastroAlunoController implements Initializable {

	@FXML
	private Label LabelAlunoNome;
	@FXML
	private Label LabelAlunoSobrenome;
	@FXML
	private Label LabelAlunoMatricula;
	@FXML
	private Label LabelAlunoTelefone;

	@FXML
	private TextField TextFieldAlunoNome;
	@FXML
	private TextField TextFieldAlunoSobrenome;
	@FXML
	private TextField TextFieldAlunoMatricula;
	@FXML
	private TextField TextFieldAlunoTelefone;

	@FXML
	private Button buttonConfirmar;
	@FXML
	private Button buttonCancelar;
	@FXML
	private Button buttonAlternarFuncionario;

	private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
	private Aluno aluno;

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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	public void handleButtonConfirmar() {
		
		if (validarEntradaDeDados()) {
			aluno.setNome(TextFieldAlunoNome.getText());
			aluno.setSobrenome(TextFieldAlunoSobrenome.getText());
			aluno.setMatricula(TextFieldAlunoMatricula.getText());
			aluno.setTelefone(TextFieldAlunoTelefone.getText());

			buttonConfirmarClicked = true;
			dialogStage.close();
		}
	}
	
	 public void handleButtonCancelar() {
	        getDialogStage().close();
	    }

}
