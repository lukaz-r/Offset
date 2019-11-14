
package javafxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafxmvc.model.database.Database;
import javafxmvc.model.database.DatabaseFactory;
import javafxmvc.model.domain.Cliente;



public class FXMLCadastroController implements Initializable {
   
    @FXML
    private TableView<Aluno> TableViewAluno;
    @FXML
    private TableColumn<Aluno, String> TableColumnClienteNome;
    @FXML
    private TableColumn<Aluno, String> TableColumnClienteMatricula;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label LabelAlunoNome;   
    @FXML
    private Label LabelAlunoSobrenome;
    @FXML
    private Label LabelAlunoMatricula;
    @FXML
    private Label LabelAlunoTelefone;

    private List<Aluno> listAluno;
    private ObservableList<Aluno> observableListAluno;

    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final AlunoDAO alunoDAO = new AlunoDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alunoDAO.setConnection (connection);
        
        carregarTableViewAluno();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewAluno(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        TableViewAluno.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewAluno(newValue));
    }    
 public void carregarTableViewAluno() {
        tableColumnAlunoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnAlunoMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        listAluno = alunoDAO.listar();

        observableListAluno = FXCollections.observableArrayList(listAluno);
        TableViewAluno.setItems(observableListAluno);
    }

public void selecionarItemTableViewClientes(Aluno aluno) {
        if (aluno != null) {
            
            LabelAlunoNome.setText(aluno.getNome());
            LabelAlunoSobrenome.setText(aluno.getSobrenome());
            LabelAlunoCodigo.setText(String.valueOf(aluno.getMatricula()));
            LabelAlunoTelefone.setText(aluno.getTelefone());
        } else {
            labelClienteCodigo.setText("");
            labelClienteNome.setText("");
            labelClienteCPF.setText("");
            labelClienteTelefone.setText("");
        }
    }




@FXML
public void handleButtonInserir() throws IOException {
    Aluno aluno = new Aluno();
    
    boolean buttonConfirmarClicked = showFXMLCadastroAlunoController(aluno);//
    if (buttonConfirmarClicked) {
        alunoDAO.inserir(aluno);
        carregarTableViewAluno();
    }
}

@FXML
public void handleButtonAlterar() throws IOException {
	 Aluno aluno  = TableViewAluno.getSelectionModel().getSelectedItem();//Obtendo cliente selecionado
    if (aluno  != null) {
        //boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosClientesDialog(cliente);
    	boolean buttonConfirmarClicked = showFXMLCadastroAlunoController(aluno);
        if (buttonConfirmarClicked) {
            alunoDAO.alterar(aluno);
            carregarTableViewAluno();
        }
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Por favor, escolha um aluno na Tabela!");
        alert.show();
    }
}



@FXML
public void handleButtonRemover() throws IOException {
	Aluno aluno = TableViewAluno.getSelectionModel().getSelectedItem();
    if (aluno != null) {
        alunoDAO.remover(aluno);
        carregarTableViewAluno();
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Por favor, escolha um aluno na Tabela!");
        alert.show();
    }
}




}
