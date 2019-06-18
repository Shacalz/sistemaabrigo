package util;

import util.diálogo.Resposta;

public class mensagens {
    private mensagens() {
    }

    public static void info(String mensagem) {
        diálogo.mensagens("INFO", "Informação", mensagem);
    }

    public static void info(String mensagem, String titulo) {
        diálogo.mensagens("INFO", titulo, mensagem);
    }

    public static void erro(String mensagem) {
        diálogo.mensagens("ERRO", "Erro", mensagem);
    }

    public static void erro(String mensagem, String titulo) {
        diálogo.mensagens("ERRO", titulo, mensagem);
    }

    public static void alerta(String mensagem) {
        diálogo.mensagens("ALERTA", "Alerta", mensagem);
    }

    public static void alerta(String mensagem, String titulo) {
        diálogo.mensagens("ALERTA", titulo, mensagem);
    }

    public static Resposta confirmar(String mensagem) {
        return diálogo.mensageConfirmar("Confirmar", mensagem);
    }

    public static Resposta confirmar(String titulo, String mensagem) {
        return diálogo.mensageConfirmar(titulo, mensagem);
    }
    
}
