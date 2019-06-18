package util;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class resize {
    private resize() {
    }

    public static void margin(Node no, double top, double right, double bottom, double left) {
        AnchorPane.setTopAnchor(no, top);
        AnchorPane.setRightAnchor(no, right);
        AnchorPane.setBottomAnchor(no, bottom);
        AnchorPane.setLeftAnchor(no, left);
    }

    public static void margin(Node no, double valor) {
        AnchorPane.setTopAnchor(no, valor);
        AnchorPane.setRightAnchor(no, valor);
        AnchorPane.setBottomAnchor(no, valor);
        AnchorPane.setLeftAnchor(no, valor);
    }

    public static void margin(Node no, double top, double right, double left) {
        AnchorPane.setTopAnchor(no, top);
        AnchorPane.setRightAnchor(no, right);
        AnchorPane.setLeftAnchor(no, left);
    }

    public static void margin(Node no, double right, double left) {
        AnchorPane.setRightAnchor(no, right);
        AnchorPane.setLeftAnchor(no, left);
    }

    public static void marginTop(Node no, double top) {
        AnchorPane.setTopAnchor(no, top);
    }

    public static void marginRight(Node no, double right) {
        AnchorPane.setRightAnchor(no, right);
    }

    public static void marginBottom(Node no, double bottom) {
        AnchorPane.setBottomAnchor(no, bottom);
    }

    public static void marginLeft(Node no, double left) {
        AnchorPane.setLeftAnchor(no, left);
    }
    
}
