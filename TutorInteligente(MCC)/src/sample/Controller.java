package sample;

import javafx.fxml.FXML;

import javafx.scene.control.*;



public class Controller {
    @FXML
    TextArea txtSolution = new TextArea();

    public void initialize(){
        String textAreaEnunciado = "public class Ejercicio{\n" +
                "    public static void main(String[] args) {\n" +
                "        //Empieza a codificar la solución\n" +
                "    }\n" +
                "}";
        txtSolution.setText(textAreaEnunciado);
    }

}
