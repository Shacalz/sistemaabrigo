package util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author felli
 */
public class links {
    private links() {
    }

    public static void siteFacebookCriador(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (URISyntaxException | IOException ex) {
            mensagens.erro("Não foi possível abrir o site! \n Erro : " + ex.getMessage());
        }
    }
}
