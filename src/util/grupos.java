package util;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class grupos {

    public static void notEmpty(ToggleGroup... grupoMenu) {
        for (ToggleGroup grupo : grupoMenu) {
            grupo.selectedToggleProperty().addListener(
                    (ObservableValue<? extends Toggle> obs, Toggle old, Toggle novo) -> {
                        if (grupo.getSelectedToggle() == null) {
                            grupo.selectToggle(old);
                        }
                    });
        }
    }
    
}
