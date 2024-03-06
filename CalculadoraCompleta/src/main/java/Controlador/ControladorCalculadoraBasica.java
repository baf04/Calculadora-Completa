package Controlador;

import Modelo.Model;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCalculadoraBasica extends Stage implements Initializable {

    private Stage stage;
    private Scene scene;

    private final Model data = Model.getInstance();

    @javafx.fxml.FXML
    private Button invertirSigno;
    @javafx.fxml.FXML
    private Button siete;
    @javafx.fxml.FXML
    private Button ocho;
    @javafx.fxml.FXML
    private Button multiplicar;
    @javafx.fxml.FXML
    private Button restar;
    @javafx.fxml.FXML
    private Button dos;
    @javafx.fxml.FXML
    private Button seis;
    @javafx.fxml.FXML
    private Button nueve;
    @javafx.fxml.FXML
    private Button cuatro;
    @javafx.fxml.FXML
    private Button cinco;
    @javafx.fxml.FXML
    private Button borrar;
    @javafx.fxml.FXML
    private Button uno;
    @javafx.fxml.FXML
    private Button sumar;
    @javafx.fxml.FXML
    private Button dividir;
    @javafx.fxml.FXML
    private Button tres;
    @javafx.fxml.FXML
    private Button igual;
    @javafx.fxml.FXML
    private Button decimal;
    @javafx.fxml.FXML
    private Button borrar2;
    @javafx.fxml.FXML
    private Button borrar3;
    @javafx.fxml.FXML
    private Button cero;
    @javafx.fxml.FXML
    private TextField memoria;
    @javafx.fxml.FXML
    private TextField resultado;
    private String primernumero = "";
    private String operador = "";
    private String numeroActual = "";
    private String mem = "";
    private double res;


    public void initialize(URL url, ResourceBundle resourceBundle){

        String mem = data.getMem();
        double res = data.getRes();

        if (res != 0) {
            if((res - (int) res) != 0){
                resultado.setText(Double.toString(res));
                memoria.setText(Double.toString(res));
            } else {
                int trunc = (int) Math.round(res);
                resultado.setText(Integer.toString(trunc));
                memoria.setText(Integer.toString(trunc));
            }

            numeroActual = Double.toString(res);
            operador = "";
            mem = Double.toString(res);
        }

    }

    public void calculationSetup(String calculationType){

        if (!operador.equals("")){
            this.operador = calculationType;
            memoria.setText(primernumero + " " + calculationType);
        }else {

        this.operador = calculationType;
        primernumero = numeroActual;
        numeroActual = "";
        memoria.setText(primernumero + " " + calculationType);
    }

    }

    @javafx.fxml.FXML
    public void clickDos(ActionEvent actionEvent) {
        addNumber("2");
    }

    @javafx.fxml.FXML
    public void clickNueve(ActionEvent actionEvent) {
        addNumber("9");
    }

    @javafx.fxml.FXML
    public void clickUno(ActionEvent actionEvent) {
        addNumber("1");
    }

    @javafx.fxml.FXML
    public void clickCuatro(ActionEvent actionEvent) {
        addNumber("4");
    }

    @javafx.fxml.FXML
    public void clickTres(ActionEvent actionEvent) {
        addNumber("3");
    }

    @javafx.fxml.FXML
    public void clickCinco(ActionEvent actionEvent) {
        addNumber("5");
    }

    @javafx.fxml.FXML
    public void clickCero(ActionEvent actionEvent) {
            addNumber("0");
    }

    @javafx.fxml.FXML
    public void clickSiete(ActionEvent actionEvent) {
        addNumber("7");
    }

    @javafx.fxml.FXML
    public void clickSeis(ActionEvent actionEvent) {
        addNumber("6");
    }

    @javafx.fxml.FXML
    public void clickOcho(ActionEvent actionEvent) {
        addNumber("8");
    }

    public void updateTextField(){
        resultado.setText("");
        resultado.setText(numeroActual);
    }

    public void addNumber(String num){
        numeroActual += num;
        updateTextField();
    }

    @javafx.fxml.FXML
    public void clickBorrar(ActionEvent actionEvent) {
            numeroActual = "";
            resultado.setText("0");
            memoria.setText("");
            res = 0.0;
            mem = "";
    }

    @javafx.fxml.FXML
    public void clickDecimal(ActionEvent actionEvent) {
        if (!numeroActual.contains(".")) {
            numeroActual += ".";
            resultado.setText(numeroActual);
        }
    }

    @javafx.fxml.FXML
    public void clickDividir(ActionEvent actionEvent) {
        if (!numeroActual.equals("")) {
            calculationSetup("/");
        }
    }

    @javafx.fxml.FXML
    public void clickCambioSigno(ActionEvent actionEvent) {
        if (!numeroActual.isEmpty() && !numeroActual.equals("0")) {
            if (numeroActual.contains("-")){
                numeroActual = numeroActual.replace("-","");
            resultado.setText(numeroActual);
            }else {
                numeroActual = "-" + numeroActual;
                resultado.setText(numeroActual);
            }
        }
    }

    @javafx.fxml.FXML
    public void clickRestar(ActionEvent actionEvent) {
        if (!numeroActual.equals("")) {
            calculationSetup("-");
        }
    }

    @javafx.fxml.FXML
    public void clickIgual(ActionEvent actionEvent) {
        if (!operador.isEmpty()) {
            double secondOperand = Double.parseDouble(numeroActual);
            res = Double.parseDouble(primernumero);
            switch (operador) {
                case "+":
                    res += secondOperand;
                    break;
                case "-":
                    res -= secondOperand;
                    break;
                case "*":
                    res *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        res /= secondOperand;
                    } else {
                        // Manejar división por cero
                        resultado.setText("Error: División por cero");
                        return;
                    }
                    break;
            }
            if((res-(int)res)!=0){
                resultado.setText(Double.toString(res));
                memoria.setText(Double.toString(res));
            }
            else{
                int trunc = (int)Math.round(res);
                resultado.setText(Integer.toString(trunc));
                memoria.setText(Integer.toString(trunc));
            }

            numeroActual = Double.toString(res);
            operador = "";
            mem = Double.toString(res);
        }
    }

    @javafx.fxml.FXML
    public void clickMultiplicar(ActionEvent actionEvent) {
        if (!numeroActual.equals("")) {
            calculationSetup("*");
        }
    }

    @javafx.fxml.FXML
    public void clickSumar(ActionEvent actionEvent) {
        if (!numeroActual.equals("")) {
            calculationSetup("+");
        }
    }


    @javafx.fxml.FXML
    public void clickBasica(ActionEvent actionEvent) throws IOException {
        data.setMem(mem);
        data.setNumeroActual(numeroActual);
        data.setOperador(operador);
        data.setPrimernumero(primernumero);
        data.setRes(res);
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/calc.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clickCientifica(ActionEvent actionEvent) throws IOException {
        data.setMem(mem);
        data.setNumeroActual(numeroActual);
        data.setOperador(operador);
        data.setPrimernumero(primernumero);
        data.setRes(res);
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/calculadoraCientifica.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void sumarMemoria(ActionEvent actionEvent) {
        if (!memoria.getText().isEmpty()){

            double memo = Double.parseDouble(memoria.getText());
            memo += Double.parseDouble(mem);
            memoria.setText(Double.toString(memo));
            numeroActual = Double.toString(memo);
        }
    }

    @javafx.fxml.FXML
    public void clickConversion(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Vista/calculadoraConversion.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void restarMemoria(ActionEvent actionEvent) {

        if (!memoria.getText().isEmpty()){

        double memo = Double.parseDouble(memoria.getText());
        memo -= Double.parseDouble(mem);
        memoria.setText(Double.toString(memo));
        numeroActual = Double.toString(memo);
        }
    }
}
