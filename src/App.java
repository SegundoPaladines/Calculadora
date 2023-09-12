import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    private static final String ESTILO_NUMEROS="-fx-background-color:#7ea8ec; -fx-text-fill: white;"
                                            +"-fx-font-family: 'digital display tfb'; -fx-font-size: 2em";

    private static final String ESTILO_BOTONES="-fx-background-color:#486381; -fx-text-fill: white;"
                                    +"-fx-font-family: 'digital display tfb'; -fx-font-size: 2em;"
                                    +"-fx-weight:bold; -fx-border-color:#e8f5e9; -fx-border-radius:5px";

    private static final String ESTILO_MOUSEARRIVA_BOTONES="-fx-background-color:#59798A; -fx-text-fill: white;"
                                    +"-fx-font-family: 'digital display tfb'; -fx-font-size: 2em;"
                                    +"-fx-weight:bold; -fx-border-color:#e8f5e9; -fx-border-radius:5px";

    @Override
    public void start(Stage prymStage) throws Exception {

        VBox vboxPrincipal= new VBox();
        vboxPrincipal.setStyle("-fx-background-color:#628bb7");
        //Contenedor Horizontal
        HBox hventradas= new HBox();
        //display
        VBox display=new VBox();

        //Elementos
        TextField num1= new TextField("");
        num1.setEditable(false);
        num1.setAlignment(Pos.BASELINE_RIGHT);
        num1.setStyle(ESTILO_NUMEROS);
        HBox.setHgrow(num1, Priority.ALWAYS);

        TextField operacion= new TextField("");
        operacion.setEditable(false);
        operacion.setMaxWidth(45);
        operacion.setMinWidth(30);
        operacion.setStyle("-fx-background-color:#7ea8ec; -fx-text-fill: white; -fx-font-family: 'digital display tfb'; -fx-font-size: 2em;");

        TextField num2= new TextField("");
        num2.setEditable(false);
        num2.setAlignment(Pos.TOP_RIGHT);
        num2.setStyle("-fx-background-color:#7ea8ec; -fx-text-fill: white; -fx-font-family: 'digital display tfb'; -fx-font-size: 2em;");
        HBox.setHgrow(num2, Priority.ALWAYS);
        hventradas.getChildren().addAll(num1,operacion,num2);
        hventradas.setSpacing(5);

        //contenedor del resultado
        TextField resultado= new TextField("");
        resultado.setEditable(false);
        resultado.setEditable(false);
        resultado.setAlignment(Pos.TOP_RIGHT);
        resultado.setStyle("-fx-background-color:#7ea8ec; -fx-text-fill: white; -fx-font-family: 'digital display tfb'; -fx-font-size: 2em;");
        HBox.setHgrow(resultado, Priority.ALWAYS);
        //Diseño de la parte de entradas
        display.setSpacing(5);
        display.setPadding(new Insets(5,4,4,5));//insets (arriva,derecha,abajo,izquierda)
        display.getChildren().addAll(hventradas,resultado);

        //Cuadro de botonos
        List <Button> listanumeros = new ArrayList<>();
        for(int i=0; i<11; i++){
            Button boton = new Button(""+i);
            boton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            boton.setText((i==10)?".":boton.getText());
            boton.setStyle(ESTILO_BOTONES);
            boton.setOnMouseEntered(event ->boton.setStyle(ESTILO_MOUSEARRIVA_BOTONES));
            boton.setOnMouseExited(event ->boton.setStyle(ESTILO_BOTONES));

            listanumeros.add(boton);
        }

        Button bClear = new Button("c");
        bClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button bSuma = new Button("+");
        bSuma.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button bResta = new Button("-");
        bResta.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button bMultiplicacion = new Button("x");
        bMultiplicacion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button bDivicion = new Button("÷");
        bDivicion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        Button bIgual = new Button("=");
        bIgual.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        List <Button> operaciones = new ArrayList<>();
        operaciones.add(bSuma);
        operaciones.add(bResta);
        operaciones.add(bMultiplicacion);
        operaciones.add(bDivicion);

        GridPane teclado= new GridPane();

        //Fila 1
        teclado.add(bClear, 0, 0);
        teclado.add(listanumeros.get(9), 1, 0);
        teclado.add(listanumeros.get(8), 2, 0);
        teclado.add(listanumeros.get(7), 3, 0);

        //fila 2
        teclado.add(listanumeros.get(6), 0, 1);
        teclado.add(bMultiplicacion, 1, 1);
        teclado.add(bDivicion, 2, 1);
        teclado.add(listanumeros.get(5), 3, 1);

        //fila 3
        teclado.add(listanumeros.get(0), 0, 2);
        teclado.add(bSuma, 1, 2);
        teclado.add(bResta, 2, 2);
        teclado.add(listanumeros.get(4), 3, 2);

        //fila 4
        teclado.add(listanumeros.get(10), 0, 3);
        teclado.add(listanumeros.get(1), 1, 3);
        teclado.add(listanumeros.get(2), 2, 3);
        teclado.add(listanumeros.get(3), 3, 3);


        //fila 5: solo1 boton (objeto, fila, columna, colspan x en num columnas, colspan y en num filas )
        teclado.add(bIgual, 0, 4, 4, 1);

        for(int i=0; i<listanumeros.size(); i++){
            String tmp=listanumeros.get(i).getText().toString();
            listanumeros.get(i).setOnAction(event ->{

                    if(operacion.getText().toString().equalsIgnoreCase("")){

                        num1.setText(num1.getText()+tmp);
                        resultado.setText("");
    
                    }else{
                        num2.setText(num2.getText()+tmp);
                        resultado.setText(num1.getText().toString()+" "+operacion.getText().toString()+" "+num2.getText().toString());
                    }
            });
        }
        for(int i=0; i<operaciones.size(); i++){
            String tmp=operaciones.get(i).getText().toString();
            operaciones.get(i).setOnAction(event ->{
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setContentText("Debe añadir un valor al operando 1 primero");
                if(num1.getText().toString().equalsIgnoreCase("")){
                    alerta.showAndWait();
                }else{
                    resultado.setText(num1.getText().toString());
                    operacion.setText(tmp);
                }
            });
        }

        bIgual.setOnAction(event -> {
            try{
                double dato1=Double.parseDouble(num1.getText().toString());
                double dato2=Double.parseDouble(num2.getText().toString());
                String oper=operacion.getText().toString();
                switch(oper){
                    case "+":
                    resultado.setText((dato1+dato2)+"");
                    num1.setText("");
                    num2.setText("");
                    operacion.setText("");
                        break;
                    case "-":
                    resultado.setText((dato1-dato2)+"");
                    num1.setText("");
                    num2.setText("");
                    operacion.setText("");
                        break;
                    case "x":
                    resultado.setText((dato1*dato2)+"");
                    num1.setText("");
                    num2.setText("");
                    operacion.setText("");
                        break;
                    case "÷":
                    resultado.setText((dato1/dato2)+"");
                    num1.setText("");
                    num2.setText("");
                    operacion.setText("");
                        break;
                }

            }catch(Exception e){
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Error en los datos");
                alerta.setContentText("los numeros digitados son invalidos");
                alerta.showAndWait();
            }
        });
        bClear.setOnAction(event -> {
            num1.setText("");
            num2.setText("");
            operacion.setText("");
            resultado.setText("");
        });

        vboxPrincipal.getChildren().addAll(display,teclado);
        ColumnConstraints reglaColumnas= new ColumnConstraints(50,50, Double.MAX_VALUE);
        reglaColumnas.setHgrow(Priority.ALWAYS);

        RowConstraints reglaFilas= new RowConstraints(50,50, Double.MAX_VALUE);
        reglaFilas.setVgrow(Priority.ALWAYS);
        VBox.setVgrow(teclado, Priority.ALWAYS);

        teclado.getColumnConstraints().addAll(reglaColumnas,reglaColumnas,reglaColumnas,reglaColumnas);
        teclado.getRowConstraints().addAll(reglaFilas,reglaFilas,reglaFilas,reglaFilas,reglaFilas);

        Scene scene = new Scene(vboxPrincipal);
        prymStage.setTitle("Calculadora Fx Interface");
        prymStage.setScene(scene);
        prymStage.show();
        
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}