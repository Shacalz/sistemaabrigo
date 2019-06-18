package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;
public class Combo {

    private Combo() {
    }

    //Popular ComboBox através de uma coleção do tipo List

    public static void popular(ComboBox combo, List lista) {
        dados(combo, FXCollections.observableArrayList(lista));
    }


    //Popular ComboBox através um array de strings recebidos

    public static void popular(ComboBox combo, String... itens) {
        dados(combo, FXCollections.observableArrayList(itens));
    }


    //Popular ComboBox com dados informados no combo

    private static void dados(ComboBox combo, ObservableList dados) {
        if (dados.isEmpty() || dados == null) {
            limpar(combo);
        } else {
            combo.setItems(dados);
            combo.getSelectionModel().selectFirst();
        }
    }


    //Limpar Limpa os dados no ComboBox e deixa uma mensagem 

    private static void limpar(ComboBox<Object> combo) {
        combo.getItems().clear();
        combo.setPromptText("Sem registros");
    }
}