package Controller;


import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    void dragDrop(DragEvent event) {
        System.out.println("aa");
    }

    @FXML
    void mouseDrag(MouseEvent event) {
        System.out.println("pashm");

    }

}


