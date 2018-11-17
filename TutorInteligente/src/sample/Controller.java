package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import javax.tools.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Timer;

public class Controller {

    @FXML
    Button btnCompile, btnExecute, btnStart, btnAyuda;

    @FXML
    TextArea txtArea, txtAreaResults;

    @FXML
    Label desEjercicio, errores,lblTiempo;

    private int numErrores, numAyudas, nivel;
    private long tiempo=0;
    private Ejercicio ejercicios = new Ejercicio();
    private EjercicioModel ejercicioModel;
    private Nivel nivelActual = Nivel.PRINCIPIANTE;
    private Timeline timeline;

    private String textAreaEnunciado = "public class SolucionEjercicio{\n" +
            "    public static void main(String[] args) {\n" +
            "      \n" +
            "    }\n" +
            "}";
    File root = new File("");

    private File sourceFile = null;

    public Controller() throws FileNotFoundException {
    }

    public void initialize() {
        eventButtons();
    }

    private void eventButtons() {

        btnCompile.setOnAction((event) -> {
            btnExecute.setDisable(true);
            try {
                this.createFile();
                this.compile(sourceFile);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        btnAyuda.setOnAction((event) ->{
                this.txtAreaResults.setText(this.ejercicioModel.getAyuda());

            numAyudas++;
        } );

        btnExecute.setOnAction((event) -> {
            try {
                List<String> list = muestraContenido("D:\\test\\output.txt");
                txtAreaResults.setText(list.get(10));
                validar(list.get(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnStart.setOnAction((event) -> {
            if (btnStart.getText().equals("Iniciar")) {
                generarTiempo();
                txtArea.setText(textAreaEnunciado);
                this.ejercicioModel = this.ejercicios.getEjercicio(nivelActual);
                desEjercicio.setText(this.ejercicioModel.getDescripcion_problema());
                btnCompile.setDisable(false);
                btnAyuda.setDisable(false);
                txtAreaResults.setDisable(false);
                txtArea.setDisable(false);
                btnStart.setText("Siguiente");
            }else if(btnStart.getText().equals("Siguiente")){
                //desEjercicio.setText(ejercicioModel.getDescripcion_problema());
                lblTiempo.setText("00:00");
                System.out.println(tiempo);
                desEjercicio.setText("");
                txtArea.setText("");
                numAyudas = 0;
                numErrores = 0;
                errores.setText("0");
                txtAreaResults.setText("");
                btnCompile.setDisable(false);
                btnStart.setText("Iniciar");
                txtArea.setDisable(false);
            }
        });
    }

    private void validar(String resultadoUsuario){

        String resultadoEsperado = this.ejercicioModel.getSolucion_esperada();
        System.out.println(resultadoEsperado);
        if(resultadoEsperado.equals(resultadoUsuario)){
            this.timeline.stop();

            String a = txtAreaResults.getText();
            txtAreaResults.setText(a + "\nEl resultado es correcto");
            btnStart.setDisable(false);
            btnAyuda.setDisable(true);
            btnCompile.setDisable(true);
            btnExecute.setDisable(true);

            txtArea.setDisable(true);

            FuzzyLogic fl = new FuzzyLogic();
            System.out.println(numErrores);
            System.out.println((int)tiempo/1000);
            System.out.println(numAyudas);
            System.out.println(nivel);

            double output = fl.getDifusa(numErrores,(int)tiempo/1000,numAyudas,nivel);
            nivel = (int)output;
            System.out.println(output);
            if(output <= 10){
                this.nivelActual = Nivel.PRINCIPIANTE;
            }else if(output <= 20){
                this.nivelActual = Nivel.INTERMEDIO;
            }else{
                this.nivelActual = Nivel.AVANZADO;
            }
        }
    }


    public static List<String> muestraContenido(String archivo) throws IOException {
        List<String> lola = new ArrayList<>();
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        try{Thread.sleep(2000);}catch(Exception ex){}
        while((cadena = b.readLine())!=null) {
            lola.add(cadena);
        }
        b.close();
        return lola;
    }

    public void generarTiempo(){
        long endTime = System.currentTimeMillis();
        DateFormat timeFormat = new SimpleDateFormat( "mm:ss" );
        //int tiempoActual = 0;
        timeline = new Timeline(
                new KeyFrame(
                        Duration.millis( 500 ),
                        event -> {
                            final long diff = System.currentTimeMillis();
                            //final long diff =  System.currentTimeMillis();
                            if ( diff < 0 ) {
                                lblTiempo.setText( "00:00" );
                                lblTiempo.setText( timeFormat.format( 0 ) );
                            } else {
                                this.tiempo = diff - endTime;
                               lblTiempo.setText( timeFormat.format( diff - endTime ) );
                            }
                        }
                )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }

    private void proceso() {
        try {
            // create a process
            ProcessBuilder pb = new ProcessBuilder("cmd");

            // take all commands as input in a text file
            File commands = new File("D:\\test\\commands.txt");

            // File where error logs should be written
            File error = new File("D:\\test\\error.txt");

            // File where output should be written
            File output = new File("D:\\test\\output.txt");

            // redirect all the files
            pb.redirectInput(commands);
            pb.redirectOutput(output);
            pb.redirectError(error);

            pb.start();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    private void createFile() throws IOException {

        sourceFile = new File("D:\\Test", "\\SolucionEjercicio.java");
        Writer writer = new FileWriter(sourceFile);
        writer.write(this.txtArea.getText());
        writer.close();

    }

    private void compile(File sf) {
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostic = new DiagnosticCollector<>();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> compilation = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sf));
            JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostic, null, null, compilation);
            txtAreaResults.setText("");
            verificaExito(task, diagnostic);
        } catch (Exception ex) {
            System.err.println("Hubo un error interno.");
        }
    }

    private void verificaExito(JavaCompiler.CompilationTask task, DiagnosticCollector<JavaFileObject> diagnostics) throws IOException {
        if( task.call() ){
            txtAreaResults.setText("Compila correctamente.");

            this.proceso();

            btnExecute.setDisable(false);
        }
        else{

            this.numErrores++;

            errores.setText( Integer.toString(numErrores) );

            txtAreaResults.setText("Resultado:\n");

            // Recorremos el diagnostico
            for (Diagnostic diag : diagnostics.getDiagnostics()) {
                txtAreaResults.setText(txtAreaResults.getText() + "\n" + diag.getMessage(null) + "\t Linea: " + diag.getLineNumber() + "\n");
            }
        }
    }
}
