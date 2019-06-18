/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author Fellipe Luann
 */
public class animaisM {

    private int id;
    private String nome;
    private protetorM protetor_id;
    private raçaM raça_id;
    private String gênero;
    private espécieM espécie_id;
    private String idade;
    private String observações;

    public animaisM() {
        this.id = 0;
    }

    public animaisM(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public animaisM(int id, String nome, protetorM protetor_id, raçaM raça_id, String gênero, espécieM espécie_id, String idade, String observações) {
        this.id = id;
        this.nome = nome;
        this.protetor_id = protetor_id;
        this.raça_id = raça_id;
        this.gênero = gênero;
        this.espécie_id = espécie_id;
        this.idade = idade;
        this.observações = observações;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public protetorM getProtetor_id() {
        return protetor_id;
    }

    public void setProtetor_id(protetorM protetor_id) {
        this.protetor_id = protetor_id;
    }

    public raçaM getRaça_id() {
        return raça_id;
    }

    public void setRaça_id(raçaM raça_id) {
        this.raça_id = raça_id;
    }

    public String getGênero() {
        return gênero;
    }

    public void setGênero(String gênero) {
        this.gênero = gênero;
    }

    public espécieM getEspécie_id() {
        return espécie_id;
    }

    public void setEspécie_id(espécieM espécie_id) {
        this.espécie_id = espécie_id;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getObservações() {
        return observações;
    }

    public void setObservações(String observações) {
        this.observações = observações;
    }

    public String toString() {
        return this.nome;
    }

}
