package controller;

import banco.DAO.controleDAO;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.dao.adotantesDAO;
import model.dao.animaisDAO;
import model.dao.espécieDAO;
import model.dao.protetorDAO;
import model.dao.raçaDAO;
import model.domain.adotantesM;
import model.domain.animaisM;
import model.domain.espécieM;
import model.domain.protetorM;
import model.domain.raçaM;
import util.Combo;
import util.MaskFieldUtil;
import util.diálogo;
import util.links;
import util.mensagens;
import util.validarCPFeCNPJ;

public class appMainController implements Initializable {
    
    public protetorM usuarioLogado = null;

    //-- Início Protetores
    private protetorM protetor;
    private protetorDAO protetor_DAO;

    //-- Fim Protetores
    //-- Início Raça
    private raçaM raça;
    private raçaDAO raça_DAO;
    //-- Fim Raça
    //-- Início Espécie
    private espécieM espécie;
    private espécieDAO espécie_DAO;
    //-- Fim Espécie
    //-- Início Animais
    private animaisM animais;
    private animaisM animaisSelecionar;
    private animaisDAO animais_DAO;
    //-- Fim Animais
    //-- Início Adotantes
    private adotantesM adotantes;
    private adotantesDAO adotantes_DAO;
    //-- Fim Adotantes

    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private BorderPane borderPaneConteúdo;

    @FXML
    private TextField txtLOGIN;

    @FXML
    private PasswordField txtPasswordProtetores;
    
    @FXML
    private PasswordField txtSenhaLogin;

    @FXML
    private JFXButton btEntrar;

    @FXML
    private JFXButton btSair;
    
    @FXML
    private Label lbInício;

    @FXML
    private ImageView imgLogoPataAmiga;

    @FXML
    private AnchorPane anchormain;

    @FXML
    private ToggleButton btProtetores;

    @FXML
    private ToggleGroup grupoMenus;

    @FXML
    private ToggleButton btAnimais;

    @FXML
    private ToggleButton btAdotantes;

    @FXML
    private Label lbUser;

    @FXML
    private Label lbLogOut;

    @FXML
    private Label lbVersãoDoSistema;

    @FXML
    private Hyperlink hyperLink;

    @FXML
    private AnchorPane boxCounteúdo;

    @FXML
    private AnchorPane anchorPaneProtetores;

    @FXML
    private AnchorPane anchorPaneInicioProtetores;

    @FXML
    private TableView<protetorM> tbProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnIdProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnNomeProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnCpfProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnCelularProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnEmailProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnEnderecoProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnBairroProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnEstadoProtetores;

    @FXML
    private TableColumn<protetorM, String> TableColumnTipoProtetores;
    
    @FXML
    private TableColumn<protetorM, String> TableColumnSenhaProtetores;

    @FXML
    private Label lbTituloProtetores;

    @FXML
    private TextField txtPesquisarProtetores;

    @FXML
    private ToggleButton btRelatorioProtetores;

    @FXML
    private ToggleGroup menu2;

    @FXML
    private ToggleButton btNovoProtetores;

    @FXML
    private ToggleGroup menu;

    @FXML
    private ToggleButton btAlterarProtetores;

    @FXML
    private ToggleButton btExcluirProtetores;

    @FXML
    private AnchorPane anchorPaneNovoProtetor;

    @FXML
    private Label lbTituloNovoProtetores;

    @FXML
    private TextField txtIdProtetores;

    @FXML
    private TextField txtNomeProtetores;

    @FXML
    private TextField txtCelularProtetores;

    @FXML
    private TextField txtEmailProtetores;

    @FXML
    private TextField txtEnderecoProtetores;

    @FXML
    private TextField txtBairroProtetores;

    @FXML
    private ComboBox<String> comboBoxEstadoProtetores;

    @FXML
    private TextField txtCPFProtetores;

    @FXML
    private ComboBox<String> comboBoxTipoProtetores;

    @FXML
    private Button btSalvarProtetores;

    @FXML
    private Button btCancelarProtetores;

    @FXML
    private AnchorPane anchorPaneAnimais;

    @FXML
    private AnchorPane anchorPaneInicioAnimais;

    @FXML
    private TableView<animaisM> tbAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdResponsávelAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdNomeAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdEspécieAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdRaçaAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdGêneroAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdadeAnimais;

    @FXML
    private TableColumn<animaisM, String> TableColumnIdObservaçõesAnimais;

    @FXML
    private Label lbTitulo;

    @FXML
    private TextField txtPesquisarAnimais;

    @FXML
    private ToggleButton btRelatorioAnimais;

    @FXML
    private ToggleGroup menu21;

    @FXML
    private ToggleButton btNovoAnimais;

    @FXML
    private ToggleButton btAlterarAnimais;

    @FXML
    private ToggleGroup menu23;

    @FXML
    private ToggleButton btExcluirAnimais;

    @FXML
    private AnchorPane anchorPaneNovoAnimais;

    @FXML
    private Label lbTitulo1;

    @FXML
    private Button btSalvarNovoAnimais;

    @FXML
    private Button btCancelarNovoAnimais;

    @FXML
    private TextField txtIdAnimais;

    @FXML
    private TextField txtNomeAnimais;

    @FXML
    private ComboBox<protetorM> comboBoxResponsávelAnimais;

    @FXML
    private ComboBox<raçaM> comboBoxRaçaAnimais;

    @FXML
    private ComboBox<String> comboBoxGêneroAnimais;

    @FXML
    private TextField txtIdadeAnimais;

    @FXML
    private TextField txtObservaçõesAnimais;

    @FXML
    private ToggleButton btNovaRaça;

    @FXML
    private ToggleGroup menu1;

    @FXML
    private ToggleButton btNovaEspécieAnimais;

    @FXML
    private ToggleGroup menu11;

    @FXML
    private ComboBox<espécieM> comboBoxEspécieAnimais;

    @FXML
    private AnchorPane anchorPaneNovaRaçaAnimais;

    @FXML
    private TableView<raçaM> tbRaçaAnimais;

    @FXML
    private TableColumn<raçaM, String> colunaIdRaçaAnimais;

    @FXML
    private TableColumn<raçaM, String> colunaNomeRaçaAnimais;

    @FXML
    private Button btSalvarRaçaAnimais;

    @FXML
    private Button btCancelarRaçaAnimais;

    @FXML
    private TextField txtPesquisarRaçaAnimais;

    @FXML
    private ToggleButton btExcluirRaçaAnimais;

    @FXML
    private ToggleGroup menu12;

    @FXML
    private ToggleButton btRelatorioRaçaAnimais;

    @FXML
    private ToggleGroup menu211;

    @FXML
    private ToggleButton btAlterarRaçaAnimais;

    @FXML
    private Label lbTituloRaça;

    @FXML
    private TextField txtIdRaçaAnimais;

    @FXML
    private TextField txtNomeRaçaAnimais;

    @FXML
    private AnchorPane anchorPaneNovaEspécieAnimais;

    @FXML
    private TableView<espécieM> tbEspécieAnimais;

    @FXML
    private TableColumn<?, ?> colunaIdEspécieAnimais;

    @FXML
    private TableColumn<?, ?> colunaNomeEspécieAnimais;

    @FXML
    private Button btSalvarEspécieAnimais;

    @FXML
    private Button btCancelarFornecedorProd;

    @FXML
    private TextField txtPesquisarEspécieAnimais;

    @FXML
    private ToggleButton btRelatorioEspécieAnimais;

    @FXML
    private ToggleGroup menu2111;

    @FXML
    private ToggleButton btAlterarEspécieAnimais;

    @FXML
    private ToggleGroup menu22;

    @FXML
    private ToggleButton btExcluirEspécieAnimais;

    @FXML
    private ToggleGroup menu121;

    @FXML
    private Label lbEspécie;

    @FXML
    private TextField txtIdEspécieAnimais;

    @FXML
    private TextField txtNomeEspécieAnimais;

    @FXML
    private AnchorPane anchorPaneAdotantes;

    @FXML
    private AnchorPane anchorPaneInicioAdotantes;

    @FXML
    private TableView<adotantesM> tbAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnIdAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnNomeAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnAnimalAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnCpfAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnCelularAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnEmailAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnEnderecoAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnBairroAdotantes;

    @FXML
    private TableColumn<adotantesM, String> TableColumnEstadoAdotantes;

    @FXML
    private Label lbTituloAdotantes;

    @FXML
    private TextField txtPesquisarAdotantes;

    @FXML
    private ToggleButton btRelatorioAdotantes;

    @FXML
    private ToggleGroup menu24;

    @FXML
    private ToggleButton btNovoAdotantes;

    @FXML
    private ToggleButton btAlterarAdotantes;

    @FXML
    private ToggleButton btExcluirAdotantes;

    @FXML
    private AnchorPane anchorPaneNovoAdotantes;

    @FXML
    private Label lbTituloNovoAdotantes;

    @FXML
    private TextField txtIdAdotantes;

    @FXML
    private TextField txtNomeAdotantes;

    @FXML
    private ComboBox<animaisM> comboBoxAnimalAdotantes;

    @FXML
    private TextField txtCelularAdotantes;

    @FXML
    private TextField txtEmailAdotantes;

    @FXML
    private TextField txtEnderecoAdotantes;

    @FXML
    private TextField txtBairroAdotantes;

    @FXML
    private TextField txtCPFAdotantes;

    @FXML
    private ComboBox<String> comboBoxEstadoAdotantes;

    @FXML
    private Button btSalvarAdotantes;

    @FXML
    private Button btCancelarAdotantes;

    //-- Início Protetores
    private boolean validarDadosProtetores() {
        //validação de campos
        String msgErro = "";

        if (txtNomeProtetores.getText() == null || txtNomeProtetores.getText().length() == 0) {
            msgErro += "Nome inválido\n";
        }
        if (comboBoxEstadoProtetores.getItems().isEmpty()) {
            msgErro += "Estado inválido\n";
        }
        if (txtCelularProtetores.getText() == null || txtCelularProtetores.getText().length() == 0) {
            msgErro += "Celular inválido\n";
        }
        if (txtEmailProtetores.getText() == null || txtEmailProtetores.getText().length() == 0) {
            msgErro += "Email inválido\n";
        }
        if (txtEnderecoProtetores.getText() == null || txtEnderecoProtetores.getText().length() == 0) {
            msgErro += "Endereço inválido\n";
        }
        if (txtBairroProtetores.getText() == null || txtBairroProtetores.getText().length() == 0) {
            msgErro += "Bairro inválido\n";
        }
        if (validarCPFeCNPJ.isValidCPF(validarCPFeCNPJ.removeMask(txtCPFProtetores.getText())) == false) {
            msgErro += "CPF inválido\n";
        }
        if (comboBoxEstadoProtetores.getItems().isEmpty()) {
            msgErro += "Tipo inválido\n";
        }
        if (txtPasswordProtetores.getText() == null || txtPasswordProtetores.getText().length() == 0) {
            msgErro += "Senha inválida\n";
        }
        //alertas de erros nos campos
        if (msgErro.length() == 0) {
            //se a variável msgErro tiver o tamanho 0, retorna true, não mostrando mensagem de erro
            return true;
        } else {
            mensagens.alerta(msgErro);
            return false;
        }
    }

    private void comboEstadoProtetores() {
        ObservableList<String> tipo = FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        Combo.popular(comboBoxEstadoProtetores, tipo);
    }

    private void comboTipoProtetores() {
        ObservableList<String> tipo = FXCollections.observableArrayList("Administrador", "Protetor");
        Combo.popular(comboBoxTipoProtetores, tipo);
    }

    void limparCamposProtetores() {
        txtIdProtetores.setText("0");
        txtNomeProtetores.setText("");
        comboBoxEstadoProtetores.getItems().clear();
        txtCelularProtetores.setText("");
        txtEmailProtetores.setText("");
        txtEnderecoProtetores.setText("");
        txtBairroProtetores.setText("");
        txtCPFProtetores.setText("");
        comboBoxTipoProtetores.getItems().clear();
        comboEstadoProtetores();
        comboTipoProtetores();
    }

    @FXML
    private void atualizarListaProtetores() {
        try {
            tbProtetores.setItems(controleDAO.getControleBanco().getProtetor_DAO().listar_protetores(txtPesquisarProtetores.getText()));
        } catch (Exception ex) {
            mensagens.erro("Erro : " + ex.getMessage());
        }
    }

    public void setCellTableProtetores() {
        TableColumnIdProtetores.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumnNomeProtetores.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumnEstadoProtetores.setCellValueFactory(new PropertyValueFactory<>("estado"));
        TableColumnCelularProtetores.setCellValueFactory(new PropertyValueFactory<>("celular"));
        TableColumnEmailProtetores.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumnEnderecoProtetores.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        TableColumnBairroProtetores.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        TableColumnCpfProtetores.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        TableColumnTipoProtetores.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        TableColumnSenhaProtetores.setCellValueFactory(new PropertyValueFactory<>("senha"));
    }

    @FXML
    public void selecionarItemTabelaProtetores() {
        tbProtetores.setOnMouseClicked(e -> {
            tbProtetores.requestFocus();
            btExcluirProtetores.setDisable(false);
            btAlterarProtetores.setDisable(false);
        });
    }

    void desativarbtsEditarExcluirProtetores() {
        btAlterarProtetores.setDisable(true);
        btExcluirProtetores.setDisable(true);
    }
    //-- Fim Protetores

    //-- Início Raça
    private boolean validarDadosRaçaAnimais() {
        //validação de campos
        String msgErro = "";

        if (txtNomeRaçaAnimais.getText() == null || txtNomeRaçaAnimais.getText().length() == 0) {
            msgErro += "Nome inválido\n";
        }
        //alertas de erros nos campos
        if (msgErro.length() == 0) {
            //se a variável msgErro tiver o tamanho 0, retorna true, não mostrando mensagem de erro
            return true;
        } else {
            mensagens.alerta(msgErro);
            return false;
        }
    }

    void limparCamposRaçaAnimais() {
        txtIdRaçaAnimais.setText("0");
        txtNomeRaçaAnimais.setText("");
        comboEstadoProtetores();
        comboTipoProtetores();
    }

    @FXML
    private void atualizarListaRaçaAnimais() {
        try {
            tbRaçaAnimais.setItems(controleDAO.getControleBanco().getRaça_DAO().listar_raça(txtPesquisarRaçaAnimais.getText()));
        } catch (Exception ex) {
            mensagens.erro("Erro : " + ex.getMessage());
        }
    }

    public void setCellTableRaçaAnimais() {
        colunaIdRaçaAnimais.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNomeRaçaAnimais.setCellValueFactory(new PropertyValueFactory<>("nome"));
    }

    @FXML
    public void selecionarItemTabelaRaçaAnimais() {
        tbRaçaAnimais.setOnMouseClicked(e -> {
            tbRaçaAnimais.requestFocus();
            btExcluirRaçaAnimais.setDisable(false);
            btAlterarRaçaAnimais.setDisable(false);
        });
    }

    void desativarbtsEditarExcluirRaçaAnimais() {
        btAlterarRaçaAnimais.setDisable(true);
        btExcluirRaçaAnimais.setDisable(true);
    }
    //-- Fim Raça

    //-- Início Espécie
    private boolean validarDadosEspécieAnimais() {
        //validação de campos
        String msgErro = "";

        if (txtNomeEspécieAnimais.getText() == null || txtNomeEspécieAnimais.getText().length() == 0) {
            msgErro += "Nome inválido\n";
        }
        //alertas de erros nos campos
        if (msgErro.length() == 0) {
            //se a variável msgErro tiver o tamanho 0, retorna true, não mostrando mensagem de erro
            return true;
        } else {
            mensagens.alerta(msgErro);
            return false;
        }
    }

    void limparCamposEspécieAnimais() {
        txtIdEspécieAnimais.setText("0");
        txtNomeEspécieAnimais.setText("");
        comboEstadoProtetores();
        comboTipoProtetores();
    }

    @FXML
    private void atualizarListaEspécieAnimais() {
        try {
            tbEspécieAnimais.setItems(controleDAO.getControleBanco().getEspécie_DAO().listar_espécie(txtPesquisarEspécieAnimais.getText()));
        } catch (Exception ex) {
            mensagens.erro("Erro : " + ex.getMessage());
        }
    }

    public void setCellTableEspécieAnimais() {
        colunaIdEspécieAnimais.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNomeEspécieAnimais.setCellValueFactory(new PropertyValueFactory<>("nome"));
    }

    @FXML
    public void selecionarItemTabelaEspécieAnimais() {
        tbEspécieAnimais.setOnMouseClicked(e -> {
            tbEspécieAnimais.requestFocus();
            btExcluirEspécieAnimais.setDisable(false);
            btAlterarEspécieAnimais.setDisable(false);
        });
    }

    void desativarbtsEditarExcluirEspécieAnimais() {
        btAlterarEspécieAnimais.setDisable(true);
        btExcluirEspécieAnimais.setDisable(true);
    }

    //-- Fim Espécie
    //-- Início Animais

    public void preenchercomboBoxProtetoresResponsáveisAnimais() {
        Combo.popular(comboBoxResponsávelAnimais, controleDAO.getControleBanco().getProtetor_DAO().comboProtetoresResponsáveis());
    }

    private void comboGêneroAnimais() {
        ObservableList<String> tipo = FXCollections.observableArrayList("Fêmea", "Macho");
        Combo.popular(comboBoxGêneroAnimais, tipo);
    }

    public void preenchercomboBoxRaçaAnimais() {
        Combo.popular(comboBoxRaçaAnimais, controleDAO.getControleBanco().getRaça_DAO().comboRaçaAnimais());
    }

    public void preenchercomboBoxEspécieAnimais() {
        Combo.popular(comboBoxEspécieAnimais, controleDAO.getControleBanco().getEspécie_DAO().comboEspécieAnimais());
    }

    private boolean validarDadosAnimais() {
        //validação de campos
        String msgErro = "";

        if (txtNomeAnimais.getText() == null || txtNomeAnimais.getText().length() == 0) {
            msgErro += "Nome inválido\n";
        }
        if (comboBoxResponsávelAnimais.getItems().isEmpty()) {
            msgErro += "Responsável inválido\n";
        }
        if (comboBoxRaçaAnimais.getItems().isEmpty()) {
            msgErro += "Raça inválido\n";
        }
        if (comboBoxGêneroAnimais.getItems().isEmpty()) {
            msgErro += "Gênero inválido\n";
        }
        if (comboBoxEspécieAnimais.getItems().isEmpty()) {
            msgErro += "Espécie inválida\n";
        }
        if (txtIdadeAnimais.getText() == null || txtIdadeAnimais.getText().length() == 0) {
            msgErro += "Idade inválida\n";
        }
        if (txtObservaçõesAnimais.getText() == null || txtObservaçõesAnimais.getText().length() == 0) {
            msgErro += "Observações inválidas\n";
        }
        //alertas de erros nos campos
        if (msgErro.length() == 0) {
            //se a variável msgErro tiver o tamanho 0, retorna true, não mostrando mensagem de erro
            return true;
        } else {
            mensagens.alerta(msgErro);
            return false;
        }
    }

    void limparCamposAnimais() {
        txtIdProtetores.setText("0");
        txtNomeAnimais.setText("");
        comboBoxResponsávelAnimais.getItems().clear();
        comboBoxRaçaAnimais.getItems().clear();
        comboBoxGêneroAnimais.getItems().clear();
        comboBoxEspécieAnimais.getItems().clear();
        txtIdadeAnimais.setText("");
        txtObservaçõesAnimais.setText("");
        comboGêneroAnimais();
        preenchercomboBoxProtetoresResponsáveisAnimais();
        preenchercomboBoxRaçaAnimais();
        preenchercomboBoxEspécieAnimais();
    }

    @FXML
    private void atualizarListaAnimais() {
        try {
            tbAnimais.setItems(controleDAO.getControleBanco().getAnimais_DAO().listar_animais(txtPesquisarAnimais.getText()));
        } catch (Exception ex) {
            mensagens.erro("Erro : " + ex.getMessage());
        }
    }

    public void setCellTableAnimais() {
        TableColumnIdAnimais.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumnIdNomeAnimais.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumnIdResponsávelAnimais.setCellValueFactory(new PropertyValueFactory<>("protetor_id"));
        TableColumnIdRaçaAnimais.setCellValueFactory(new PropertyValueFactory<>("raça_id"));
        TableColumnIdGêneroAnimais.setCellValueFactory(new PropertyValueFactory<>("gênero"));
        TableColumnIdEspécieAnimais.setCellValueFactory(new PropertyValueFactory<>("espécie_id"));
        TableColumnIdadeAnimais.setCellValueFactory(new PropertyValueFactory<>("idade"));
        TableColumnIdObservaçõesAnimais.setCellValueFactory(new PropertyValueFactory<>("observações"));
    }

    @FXML
    public void selecionarItemTabelaAnimais() {
        tbAnimais.setOnMouseClicked(e -> {
            tbAnimais.requestFocus();
            btAlterarAnimais.setDisable(false);
            btExcluirAnimais.setDisable(false);
        });
    }

    void desativarbtsEditarExcluirAnimais() {
        btAlterarAnimais.setDisable(true);
        btExcluirAnimais.setDisable(true);
    }

    //-- Fim Animais
    //-- Início Adotantes

    private boolean validarDadosAdotantes() {
        //validação de campos
        String msgErro = "";

        if (txtNomeAdotantes.getText() == null || txtNomeAdotantes.getText().length() == 0) {
            msgErro += "Nome inválido\n";
        }
        if (comboBoxAnimalAdotantes.getItems().isEmpty()) {
            msgErro += "Animal inválido\n";
        }
        if (txtCelularAdotantes.getText() == null || txtCelularAdotantes.getText().length() == 0) {
            msgErro += "Celular inválido\n";
        }
        if (txtEmailAdotantes.getText() == null || txtEmailAdotantes.getText().length() == 0) {
            msgErro += "Email inválido\n";
        }
        if (txtEnderecoAdotantes.getText() == null || txtEnderecoAdotantes.getText().length() == 0) {
            msgErro += "Endereço inválido\n";
        }
        if (txtBairroAdotantes.getText() == null || txtBairroAdotantes.getText().length() == 0) {
            msgErro += "Bairro inválido\n";
        }
        if (validarCPFeCNPJ.isValidCPF(validarCPFeCNPJ.removeMask(txtCPFAdotantes.getText())) == false) {
            msgErro += "CPF inválido\n";
        }
        if (comboBoxEstadoAdotantes.getItems().isEmpty()) {
            msgErro += "Estado inválido\n";
        }
        //alertas de erros nos campos
        if (msgErro.length() == 0) {
            //se a variável msgErro tiver o tamanho 0, retorna true, não mostrando mensagem de erro
            return true;
        } else {
            mensagens.alerta(msgErro);
            return false;
        }
    }

    private void comboEstadoAdotantes() {
        ObservableList<String> tipo = FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        Combo.popular(comboBoxEstadoAdotantes, tipo);
    }

    void limparCamposAdotantes() {
        txtIdAdotantes.setText("0");
        txtNomeAdotantes.setText("");
        comboBoxAnimalAdotantes.getItems().clear();
        txtCelularAdotantes.setText("");
        txtEmailAdotantes.setText("");
        txtEnderecoAdotantes.setText("");
        txtBairroAdotantes.setText("");
        txtCPFAdotantes.setText("");
        comboBoxEstadoAdotantes.getItems().clear();
        comboEstadoAdotantes();
        preenchercomboBoxAnimaisAdotantes();
        //comboTipoProtetores();
    }

    @FXML
    private void atualizarListaAdotantes() {
        try {
            tbAdotantes.setItems(controleDAO.getControleBanco().getAdotantes_DAO().listar_adotantes(txtPesquisarAdotantes.getText()));
        } catch (Exception ex) {
            mensagens.erro("Erro : " + ex.getMessage());
        }
    }

    public void setCellTableAdotantes() {
        TableColumnIdAdotantes.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumnNomeAdotantes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumnAnimalAdotantes.setCellValueFactory(new PropertyValueFactory<>("animais_id"));
        TableColumnCelularAdotantes.setCellValueFactory(new PropertyValueFactory<>("celular"));
        TableColumnEmailAdotantes.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumnEnderecoAdotantes.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        TableColumnBairroAdotantes.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        TableColumnCpfAdotantes.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        TableColumnEstadoAdotantes.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    @FXML
    public void selecionarItemTabelaAdotantes() {
        tbAdotantes.setOnMouseClicked(e -> {
            tbAdotantes.requestFocus();
            btExcluirAdotantes.setDisable(false);
            btAlterarAdotantes.setDisable(false);
        });
    }

    void desativarbtsEditarExcluirAdotantes() {
        btAlterarAdotantes.setDisable(true);
        btExcluirAdotantes.setDisable(true);
    }
    
    public void preenchercomboBoxAnimaisAdotantes() {
        Combo.popular(comboBoxAnimalAdotantes, controleDAO.getControleBanco().getAnimais_DAO().comboAnimais());
    }
    //-- Fim Adotantes

    @FXML
    void eventKeyPressedEnterAdotantes(KeyEvent event) {
        atualizarListaAdotantes();
    }

    @FXML
    void eventKeyPressedEnterAnimais(KeyEvent event) {
        atualizarListaAnimais();
    }

    @FXML
    void eventKeyPressedEnterEspécieAnimais(KeyEvent event) {
        atualizarListaEspécieAnimais();
    }

    @FXML
    void eventKeyPressedEnterProtetores(KeyEvent event) {
        atualizarListaProtetores();
    }

    @FXML
    void eventKeyPressedEnterRaçaAnimais(KeyEvent event) {
        atualizarListaRaçaAnimais();
    }

    @FXML
    void facebookCriador(ActionEvent event) {
        links.siteFacebookCriador("https://www.facebook.com/fellipeluannoliveira");
        links.siteFacebookCriador("https://www.facebook.com/profile.php?id=100002312407553");
        links.siteFacebookCriador("https://www.facebook.com/bruna.leonel.90");
    }

    @FXML
    void handleButtonAlterarAnimais(ActionEvent event) {
        if (tbAnimais.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione um Animal para alteração.");
            desativarbtsEditarExcluirProtetores();
        } else {
            anchorPaneInicioAnimais.setVisible(false);
            anchorPaneNovoAnimais.setVisible(true);
            animais = tbAnimais.getItems().get(tbAnimais.getSelectionModel().getSelectedIndex());
            txtIdAnimais.setText(String.valueOf(animais.getId()));
            txtNomeAnimais.setText(animais.getNome());
            comboBoxResponsávelAnimais.setValue(animais.getProtetor_id());
            comboBoxRaçaAnimais.setValue(animais.getRaça_id());
            comboBoxGêneroAnimais.setValue(animais.getGênero());
            comboBoxEspécieAnimais.setValue(animais.getEspécie_id());
            txtIdadeAnimais.setText(animais.getIdade());
            txtObservaçõesAnimais.setText(animais.getObservações());
            desativarbtsEditarExcluirAnimais();
        }
    }

    @FXML
    void handleButtonCancelarAdotantes(ActionEvent event) {
        diálogo.Resposta resp = mensagens.confirmar("Fechar cadastro", "Realmente deseja cancelar o cadastro do Adotante?");
        if (resp == diálogo.Resposta.YES) {
            limparCamposAdotantes();
            preenchercomboBoxAnimaisAdotantes();
            anchorPaneNovoAdotantes.setVisible(false);
            anchorPaneInicioAdotantes.setVisible(true);
            btProtetores.setDisable(false);
            btAdotantes.setDisable(true);
            btAnimais.setDisable(false);
            lbInício.setDisable(false);
            lbLogOut.setDisable(false);
            tbAdotantes.getSelectionModel().clearSelection();
            desativarbtsEditarExcluirAdotantes();
        }
    }

    @FXML
    void handleButtonCancelarEspécieAnimais(ActionEvent event) {
        diálogo.Resposta resp = mensagens.confirmar("Fechar cadastro", "Realmente deseja cancelar o cadastro da espécie?");
        if (resp == diálogo.Resposta.YES) {
            limparCamposEspécieAnimais();
            anchorPaneNovaEspécieAnimais.setVisible(false);
            anchorPaneNovoAnimais.setVisible(true);
            tbEspécieAnimais.getSelectionModel().clearSelection();
            desativarbtsEditarExcluirEspécieAnimais();
        }
    }

    @FXML
    void handleButtonCancelarAnimais(ActionEvent event) {
        diálogo.Resposta resp = mensagens.confirmar("Fechar cadastro", "Realmente deseja cancelar o cadastro do animal?");
        if (resp == diálogo.Resposta.YES) {
            limparCamposAnimais();
            anchorPaneNovoAnimais.setVisible(false);
            anchorPaneInicioAnimais.setVisible(true);
            btProtetores.setDisable(false);
            btAdotantes.setDisable(false);
            lbInício.setDisable(false);
            lbLogOut.setDisable(false);
            tbAnimais.getSelectionModel().clearSelection();
            desativarbtsEditarExcluirAnimais();
        }
    }

    @FXML
    void handleButtonCancelarProtetores(ActionEvent event) {
        diálogo.Resposta resp = mensagens.confirmar("Fechar cadastro", "Realmente deseja cancelar o cadastro do Protetor?");
        if (resp == diálogo.Resposta.YES) {
            limparCamposProtetores();
            anchorPaneNovoProtetor.setVisible(false);
            anchorPaneInicioProtetores.setVisible(true);
            btAnimais.setDisable(false);
            btAdotantes.setDisable(false);
            lbInício.setDisable(false);
            lbLogOut.setDisable(false);
            tbProtetores.getSelectionModel().clearSelection();
            desativarbtsEditarExcluirProtetores();
        }
    }

    @FXML
    void handleButtonCancelarRaçaAnimais(ActionEvent event) {
        diálogo.Resposta resp = mensagens.confirmar("Fechar cadastro", "Realmente deseja cancelar o cadastro da raça?");
        if (resp == diálogo.Resposta.YES) {
            limparCamposRaçaAnimais();
            anchorPaneNovaRaçaAnimais.setVisible(false);
            anchorPaneNovoAnimais.setVisible(true);
            tbRaçaAnimais.getSelectionModel().clearSelection();
            desativarbtsEditarExcluirRaçaAnimais();
        }
    }

    @FXML
    void handleButtonExcluirAnimais(ActionEvent event) throws Exception {
        if (tbAnimais.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione um Animal para exclusão.");
            desativarbtsEditarExcluirAnimais();
        } else {
            animais = tbAnimais.getItems().get(tbAnimais.getSelectionModel().getSelectedIndex());
            controleDAO.getControleBanco().getAnimais_DAO().excluirAnimal(animais);
            desativarbtsEditarExcluirAnimais();
            atualizarListaAnimais();
            tbAnimais.refresh();
            tbAnimais.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void handleButtonExcluirEspécieAnimais(ActionEvent event) throws Exception {
        if (tbEspécieAnimais.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione uma Espécie para exclusão.");
            desativarbtsEditarExcluirRaçaAnimais();
        } else {
            espécie = tbEspécieAnimais.getItems().get(tbEspécieAnimais.getSelectionModel().getSelectedIndex());
            controleDAO.getControleBanco().getEspécie_DAO().excluirEspécie(espécie);
            desativarbtsEditarExcluirEspécieAnimais();
            atualizarListaEspécieAnimais();
            tbEspécieAnimais.refresh();
            tbEspécieAnimais.getSelectionModel().clearSelection();
            txtPesquisarEspécieAnimais.setText("");
        }
    }

    @FXML
    void handleButtonExcluirRaçaAnimais(ActionEvent event) throws Exception {
        if (tbRaçaAnimais.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione uma Raça para exclusão.");
            desativarbtsEditarExcluirRaçaAnimais();
        } else {
            raça = tbRaçaAnimais.getItems().get(tbRaçaAnimais.getSelectionModel().getSelectedIndex());
            controleDAO.getControleBanco().getRaça_DAO().excluirRaça(raça);
            desativarbtsEditarExcluirRaçaAnimais();
            atualizarListaRaçaAnimais();
            tbRaçaAnimais.refresh();
            tbRaçaAnimais.getSelectionModel().clearSelection();
            txtPesquisarRaçaAnimais.setText("");
        }
    }

    @FXML
    void handleButtonInserirAnimais(ActionEvent event) {
        anchorPaneInicioAnimais.setVisible(false);
        anchorPaneNovoAnimais.setVisible(true);
        lbInício.setDisable(true);
        btProtetores.setDisable(true);
        btAdotantes.setDisable(true);
        btAnimais.setDisable(true);
        lbLogOut.setDisable(true);
        txtPesquisarAnimais.setText("");
        txtIdAnimais.setText("0");
    }

    @FXML
    void handleButtonInserirNovaEspécieAnimais(ActionEvent event) {
        txtPesquisarEspécieAnimais.setText("");
        atualizarListaEspécieAnimais();
        anchorPaneNovoAnimais.setVisible(false);
        anchorPaneNovaEspécieAnimais.setVisible(true);
        txtIdEspécieAnimais.setText("0");

    }

    @FXML
    void handleButtonInserirNovaRaçaAnimais(ActionEvent event) {
        txtPesquisarRaçaAnimais.setText("");
        atualizarListaRaçaAnimais();
        anchorPaneNovoAnimais.setVisible(false);
        anchorPaneNovaRaçaAnimais.setVisible(true);
        txtIdRaçaAnimais.setText("0");

    }

    @FXML
    void handleButtonInserirNovoAdotante(ActionEvent event) {
        anchorPaneInicioAdotantes.setVisible(false);
        anchorPaneNovoAdotantes.setVisible(true);
        lbInício.setDisable(true);
        btAnimais.setDisable(true);
        btAdotantes.setDisable(true);
        btProtetores.setDisable(true);
        lbLogOut.setDisable(true);
        txtIdAdotantes.setText("0");
        txtPesquisarAdotantes.setText("");
    }

    @FXML
    void handleButtonInserirProtetores(ActionEvent event) {
        anchorPaneInicioProtetores.setVisible(false);
        anchorPaneNovoProtetor.setVisible(true);
        lbInício.setDisable(true);
        btAnimais.setDisable(true);
        btAdotantes.setDisable(true);
        btProtetores.setDisable(true);
        lbLogOut.setDisable(true);
        txtIdProtetores.setText("0");
        txtPesquisarProtetores.setText("");
    }

    @FXML
    void handleButtonRelatorioAdotantes(ActionEvent event) {

    }

    @FXML
    void handleButtonRelatorioAnimais(ActionEvent event) {

    }

    @FXML
    void handleButtonRelatorioEspécieAnimais(ActionEvent event) {

    }

    @FXML
    void handleButtonRelatorioProtetores(ActionEvent event) {

    }

    @FXML
    void handleButtonRelatorioRaçaAnimais(ActionEvent event) {

    }

    @FXML
    void handleButtonSalvarAdotantes(ActionEvent event) {
        if (validarDadosAdotantes()) {
            try {
                adotantes.setId(Integer.parseInt((txtIdAdotantes.getText())));
                adotantes.setNome(txtNomeAdotantes.getText());
                adotantes.setAnimais_id(comboBoxAnimalAdotantes.getValue());
                adotantes.setCelular(txtCelularAdotantes.getText());
                adotantes.setEmail(txtEmailAdotantes.getText());
                adotantes.setEndereco(txtEnderecoAdotantes.getText());
                adotantes.setBairro(txtBairroAdotantes.getText());
                adotantes.setCpf(txtCPFAdotantes.getText());
                adotantes.setEstado(comboBoxEstadoAdotantes.getValue());
                controleDAO.getControleBanco().getAdotantes_DAO().salvarAdotantes(adotantes);
                anchorPaneNovoAdotantes.setVisible(false);
                anchorPaneInicioAdotantes.setVisible(true);
                limparCamposAdotantes();
                atualizarListaAdotantes();
                tbAdotantes.refresh();
                desativarbtsEditarExcluirAdotantes();
                tbAdotantes.getSelectionModel().clearSelection();
            } catch (Exception ex) {
                mensagens.erro("Erro ao salvar dados : " + ex.getMessage());
            }
        }
    }

    @FXML
    void handleButtonSalvarEspécieAnimais(ActionEvent event) {
        if (validarDadosEspécieAnimais()) {
            try {
                espécie.setId(Integer.parseInt((txtIdEspécieAnimais.getText())));
                espécie.setNome(txtNomeEspécieAnimais.getText());
                controleDAO.getControleBanco().getEspécie_DAO().salvarEspécie(espécie);
                anchorPaneNovaEspécieAnimais.setVisible(false);
                anchorPaneNovoAnimais.setVisible(true);
                limparCamposEspécieAnimais();
                preenchercomboBoxEspécieAnimais();
                atualizarListaEspécieAnimais();
                atualizarListaAnimais();
                tbEspécieAnimais.refresh();
                desativarbtsEditarExcluirEspécieAnimais();
                tbEspécieAnimais.getSelectionModel().clearSelection();
            } catch (Exception ex) {
                mensagens.erro("Erro ao salvar dados : " + ex.getMessage());
            }
        }
    }

    @FXML
    void handleButtonSalvarAnimais(ActionEvent event) {
        if (validarDadosAnimais()) {
            try {
                animais.setId(Integer.parseInt((txtIdAnimais.getText())));
                animais.setNome(txtNomeAnimais.getText());
                animais.setProtetor_id(comboBoxResponsávelAnimais.getValue());
                animais.setRaça_id(comboBoxRaçaAnimais.getValue());
                animais.setGênero(comboBoxGêneroAnimais.getValue());
                animais.setEspécie_id(comboBoxEspécieAnimais.getValue());
                animais.setIdade(txtIdadeAnimais.getText());
                animais.setObservações(txtObservaçõesAnimais.getText());
                controleDAO.getControleBanco().getAnimais_DAO().salvarAnimais(animais);
                anchorPaneNovoAnimais.setVisible(false);
                anchorPaneInicioAnimais.setVisible(true);
                limparCamposAnimais();
                atualizarListaAnimais();
                tbAnimais.refresh();
                desativarbtsEditarExcluirAnimais();
                tbAnimais.getSelectionModel().clearSelection();
            } catch (Exception ex) {
                mensagens.erro("Erro ao salvar dados : " + ex.getMessage());
            }
        }
    }

    @FXML
    void handleButtonSalvarProtetores(ActionEvent event) {
        if (validarDadosProtetores()) {
            try {
                protetor.setId(Integer.parseInt((txtIdProtetores.getText())));
                protetor.setNome(txtNomeProtetores.getText());
                protetor.setEstado(comboBoxEstadoProtetores.getValue());
                protetor.setCelular(txtCelularProtetores.getText());
                protetor.setEmail(txtEmailProtetores.getText());
                protetor.setEndereco(txtEnderecoProtetores.getText());
                protetor.setBairro(txtBairroProtetores.getText());
                protetor.setCpf(txtCPFProtetores.getText());
                protetor.setTipo(comboBoxTipoProtetores.getValue());
                protetor.setSenha(txtPasswordProtetores.getText());
                controleDAO.getControleBanco().getProtetor_DAO().salvarProtetor(protetor);
                anchorPaneNovoProtetor.setVisible(false);
                anchorPaneInicioProtetores.setVisible(true);
                limparCamposProtetores();
                atualizarListaProtetores();
                tbProtetores.refresh();
                desativarbtsEditarExcluirProtetores();
                tbProtetores.getSelectionModel().clearSelection();
            } catch (Exception ex) {
                mensagens.erro("Erro ao salvar dados : " + ex.getMessage());
            }
            //tbCargos.getItems().clear();
            //atualizarListaCargo();
        }

    }

    @FXML
    void handleButtonSalvarRaçaAnimais(ActionEvent event) {
        if (validarDadosRaçaAnimais()) {
            try {
                raça.setId(Integer.parseInt((txtIdRaçaAnimais.getText())));
                raça.setNome(txtNomeRaçaAnimais.getText());
                controleDAO.getControleBanco().getRaça_DAO().salvarRaça(raça);
                anchorPaneNovaRaçaAnimais.setVisible(false);
                anchorPaneNovoAnimais.setVisible(true);
                limparCamposRaçaAnimais();
                preenchercomboBoxRaçaAnimais();
                atualizarListaRaçaAnimais();
                atualizarListaAnimais();
                tbRaçaAnimais.refresh();
                desativarbtsEditarExcluirRaçaAnimais();
                tbRaçaAnimais.getSelectionModel().clearSelection();
            } catch (Exception ex) {
                mensagens.erro("Erro ao salvar dados : " + ex.getMessage());
            }
            //tbCargos.getItems().clear();
            //atualizarListaCargo();
        }
    }

    @FXML
    void handleMenuFormulárioAdotantes(ActionEvent event) {
        imgLogoPataAmiga.setVisible(false);
        anchorPaneAdotantes.setVisible(true);
        anchorPaneInicioAdotantes.setVisible(true);
        btAdotantes.setDisable(true);
        btProtetores.setDisable(false);
        btAnimais.setDisable(false);

        anchorPaneAnimais.setVisible(false);
        anchorPaneProtetores.setVisible(false);

    }

    @FXML
    void handleMenuFormulárioAnimais(ActionEvent event) {
        imgLogoPataAmiga.setVisible(false);
        anchorPaneAnimais.setVisible(true);
        anchorPaneInicioAnimais.setVisible(true);
        btAnimais.setDisable(true);
        btProtetores.setDisable(false);
        btAdotantes.setDisable(false);

        anchorPaneProtetores.setVisible(false);
        anchorPaneAdotantes.setVisible(false);
    }

    @FXML
    void handleMenuFormulárioProtetores(ActionEvent event) {
        imgLogoPataAmiga.setVisible(false);
        anchorPaneProtetores.setVisible(true);
        anchorPaneInicioProtetores.setVisible(true);
        btProtetores.setDisable(true);
        btAnimais.setDisable(false);
        btAdotantes.setDisable(false);

        anchorPaneAdotantes.setVisible(false);
        anchorPaneAnimais.setVisible(false);

    }

    @FXML
    void handleMenuInício(MouseEvent event) {
        imgLogoPataAmiga.setVisible(true);
        btProtetores.setDisable(false);
        btAnimais.setDisable(false);
        btAdotantes.setDisable(false);
        
        
        anchorPaneProtetores.setVisible(false);
        anchorPaneNovoProtetor.setVisible(false);
        limparCamposProtetores();
        
        
        
        
        
        anchorPaneAnimais.setVisible(false);
        anchorPaneNovoAnimais.setVisible(false);
        anchorPaneNovaEspécieAnimais.setVisible(false);
        anchorPaneNovaRaçaAnimais.setVisible(false);
        limparCamposAnimais();
        limparCamposEspécieAnimais();
        limparCamposRaçaAnimais();
        
        
        
        
        anchorPaneAdotantes.setVisible(false);
        anchorPaneNovoAdotantes.setVisible(false);
        limparCamposAdotantes();
        
        
        
        
        
    }

    @FXML
    void handlebuttonAlterarAdotante(ActionEvent event) {
        if (tbAdotantes.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione um Adotante para alteração.");
            desativarbtsEditarExcluirAdotantes();
        } else {
            anchorPaneInicioAdotantes.setVisible(false);
            anchorPaneNovoAdotantes.setVisible(true);
            adotantes = tbAdotantes.getItems().get(tbAdotantes.getSelectionModel().getSelectedIndex());
            txtIdAdotantes.setText(String.valueOf(adotantes.getId()));
            txtNomeAdotantes.setText(adotantes.getNome());
            comboBoxAnimalAdotantes.setValue(adotantes.getAnimais_id());
            txtCelularAdotantes.setText(adotantes.getCelular());
            txtEmailAdotantes.setText(adotantes.getEmail());
            txtEnderecoAdotantes.setText(adotantes.getEndereco());
            txtBairroAdotantes.setText(adotantes.getBairro());
            txtCPFAdotantes.setText(adotantes.getCpf());
            comboBoxEstadoAdotantes.setValue(adotantes.getEstado());
            desativarbtsEditarExcluirAdotantes();
        }
    }

    @FXML
    void handlebuttonAlterarEspécieAnimais(ActionEvent event) {
        if (tbEspécieAnimais.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione uma Espécie para alteração.");
            desativarbtsEditarExcluirEspécieAnimais();
        } else {
            espécie = tbEspécieAnimais.getItems().get(tbEspécieAnimais.getSelectionModel().getSelectedIndex());
            txtIdEspécieAnimais.setText(String.valueOf(espécie.getId()));
            txtNomeEspécieAnimais.setText(espécie.getNome());
            desativarbtsEditarExcluirEspécieAnimais();
            txtPesquisarEspécieAnimais.setText("");
        }
    }

    @FXML
    void handlebuttonAlterarProtetores(ActionEvent event) {
        if (tbProtetores.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione um Protetor para alteração.");
            desativarbtsEditarExcluirProtetores();
        } else {
            anchorPaneInicioProtetores.setVisible(false);
            anchorPaneNovoProtetor.setVisible(true);
            protetor = tbProtetores.getItems().get(tbProtetores.getSelectionModel().getSelectedIndex());
            txtIdProtetores.setText(String.valueOf(protetor.getId()));
            txtNomeProtetores.setText(protetor.getNome());
            comboBoxEstadoProtetores.setValue(protetor.getEstado());
            txtCelularProtetores.setText(protetor.getCelular());
            txtEmailProtetores.setText(protetor.getEmail());
            txtEnderecoProtetores.setText(protetor.getEndereco());
            txtBairroProtetores.setText(protetor.getBairro());
            txtCPFProtetores.setText(protetor.getCpf());
            comboBoxTipoProtetores.setValue(protetor.getTipo());
            txtPasswordProtetores.setText(protetor.getSenha());
            desativarbtsEditarExcluirProtetores();
        }
    }

    @FXML
    void handlebuttonAlterarRaçaAnimais(ActionEvent event) {
        if (tbRaçaAnimais.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione uma Raça para alteração.");
            desativarbtsEditarExcluirRaçaAnimais();
        } else {
            raça = tbRaçaAnimais.getItems().get(tbRaçaAnimais.getSelectionModel().getSelectedIndex());
            txtIdRaçaAnimais.setText(String.valueOf(raça.getId()));
            txtNomeRaçaAnimais.setText(raça.getNome());
            desativarbtsEditarExcluirRaçaAnimais();
            txtPesquisarRaçaAnimais.setText("");
        }
    }

    @FXML
    void handlebuttonExcluirAdotante(ActionEvent event) throws Exception {
        if (tbAdotantes.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione um Adotantes para exclusão.");
            desativarbtsEditarExcluirAdotantes();
        } else {
            adotantes = tbAdotantes.getItems().get(tbAdotantes.getSelectionModel().getSelectedIndex());
            controleDAO.getControleBanco().getAdotantes_DAO().excluirAdotantes(adotantes);
            desativarbtsEditarExcluirAdotantes();
            atualizarListaAdotantes();
            tbAdotantes.refresh();
            tbAdotantes.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void handlebuttonExcluirProtetores(ActionEvent event) throws Exception {
        if (tbProtetores.getSelectionModel().isEmpty()) {
            mensagens.erro("Selecione um Protetor para exclusão.");
            desativarbtsEditarExcluirProtetores();
        } else {
            protetor = tbProtetores.getItems().get(tbProtetores.getSelectionModel().getSelectedIndex());
            controleDAO.getControleBanco().getProtetor_DAO().excluirProtetor(protetor);
            desativarbtsEditarExcluirProtetores();
            atualizarListaProtetores();
            tbProtetores.refresh();
            tbProtetores.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void handlebuttonEntrarLogin(ActionEvent event) {

        String cpf = txtLOGIN.getText();
        String senha = txtSenhaLogin.getText();
        if (controleDAO.getControleBanco().getLogin_DAO().autenticarUser(cpf)) {
            if (controleDAO.getControleBanco().getLogin_DAO().autenticarSenha(cpf, senha)){
                anchorPaneLogin.setVisible(false);
                borderPaneConteúdo.setVisible(true);
            }
        }
    }

    @FXML
    void handlebuttonFecharLogin(ActionEvent event) {
        appMain.palco.close();
    }

    @FXML
    void menuLogOut(MouseEvent event) {
        borderPaneConteúdo.setVisible(false);
        anchorPaneLogin.setVisible(true);
        imgLogoPataAmiga.setVisible(true);
        txtLOGIN.setText("");
        txtSenhaLogin.setText("");
        btProtetores.setDisable(false);
        btAnimais.setDisable(false);
        btAdotantes.setDisable(false);
        anchorPaneProtetores.setVisible(false);
        anchorPaneAnimais.setVisible(false);
        anchorPaneAdotantes.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //-- Início Protetores
        this.protetor = new protetorM();
        this.protetor_DAO = new protetorDAO();
        comboTipoProtetores();
        comboEstadoProtetores();
        setCellTableProtetores();
        atualizarListaProtetores();
        selecionarItemTabelaProtetores();
        //-- Fim Protetores
        //-- Início Raça Animais
        this.raça = new raçaM();
        this.raça_DAO = new raçaDAO();
        setCellTableRaçaAnimais();
        atualizarListaRaçaAnimais();
        selecionarItemTabelaRaçaAnimais();
        //-- Fim Raça Animais
        //-- Início Espécie
        this.espécie = new espécieM();
        this.espécie_DAO = new espécieDAO();
        setCellTableEspécieAnimais();
        atualizarListaEspécieAnimais();
        selecionarItemTabelaEspécieAnimais();
        //-- Fim Espécie
        //-- Início Animais
        comboGêneroAnimais();
        preenchercomboBoxRaçaAnimais();
        preenchercomboBoxEspécieAnimais();
        preenchercomboBoxProtetoresResponsáveisAnimais();
        this.animais = new animaisM();
        this.animaisSelecionar = new animaisM();
        this.animais_DAO = new animaisDAO();
        setCellTableAnimais();
        atualizarListaAnimais();
        selecionarItemTabelaAnimais();
        //-- Fim Animais
        //-- Início Adotantes
        this.adotantes = new adotantesM();
        this.adotantes_DAO = new adotantesDAO();
        setCellTableAdotantes();
        atualizarListaAdotantes();
        selecionarItemTabelaAdotantes();
        comboEstadoAdotantes();
        preenchercomboBoxAnimaisAdotantes();
        //-- Fim Adotantes
        //-- Início Global
        this.usuarioLogado = new protetorM();
        
        //-- Início Máscatas
        // Início Login
        MaskFieldUtil.cpfField(txtLOGIN);
        MaskFieldUtil.SenhaProtetorField(txtSenhaLogin);
        // Fim Login
        // Início Protetores
        MaskFieldUtil.NomeProtetoresField(txtNomeProtetores);
        MaskFieldUtil.foneCelularField(txtCelularProtetores);
        MaskFieldUtil.EmailProtetoresField(txtEmailProtetores);
        MaskFieldUtil.EndProtetoresField(txtEnderecoProtetores);
        MaskFieldUtil.BairroProtetores(txtBairroProtetores);
        MaskFieldUtil.cpfField(txtCPFProtetores);
        MaskFieldUtil.SenhaProtetorField(txtPasswordProtetores);
        // Fim Protetores
        // Início Animais
        MaskFieldUtil.NomeAnimaisField(txtNomeAnimais);
        MaskFieldUtil.numericField(txtIdadeAnimais);
        MaskFieldUtil.IdadeField(txtIdadeAnimais);
        MaskFieldUtil.ObsAnimais(txtObservaçõesAnimais);
        // Fim Animais
        // Início Raça e Espécie
        MaskFieldUtil.NomeRaçaField(txtNomeRaçaAnimais);
        MaskFieldUtil.NomeEspécieField(txtNomeEspécieAnimais);        
        // Fim Raça
        // Início Adotantes
        MaskFieldUtil.NomeAdotantesField(txtNomeAdotantes);
        MaskFieldUtil.EmailAdotantesField(txtEmailAdotantes);
        MaskFieldUtil.EndAdotantesField(txtEnderecoAdotantes);
        MaskFieldUtil.BairroAdotantesField(txtBairroAdotantes);
        MaskFieldUtil.cpfField(txtCPFAdotantes);
        MaskFieldUtil.foneCelularField(txtCelularAdotantes);
        // Fim Adotantes
        
        
        
        
        
        
        
        MaskFieldUtil.foneCelularField(txtCelularAdotantes);
        
        
        //-- Fim Máscaras
                
        //-- Fim Global
    }

}
