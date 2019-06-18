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
public class adotantesM {

    private int id;
    private String nome;
    private animaisM animais_id;
    private String celular;
    private String email;
    private String endereco;
    private String bairro;
    private String cpf;
    private String estado;

    public adotantesM() {
        this.id = 0;
    }
    
    public adotantesM(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public adotantesM(int id, String nome, animaisM animais_id, String celular, String email, String endereco, String bairro, String cpf, String estado) {
        this.id = id;
        this.nome = nome;
        this.animais_id = animais_id;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cpf = cpf;
        this.estado = estado;
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

    public animaisM getAnimais_id() {
        return animais_id;
    }

    public void setAnimais_id(animaisM animais_id) {
        this.animais_id = animais_id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String toString() {
        return this.nome;
    }

}
