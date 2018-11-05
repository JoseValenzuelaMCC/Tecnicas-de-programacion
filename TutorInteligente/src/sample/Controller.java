package sample;

import javafx.fxml.FXML;
import net.sourceforge.jFuzzyLogic.*;

import javafx.scene.CacheHint;
import javafx.scene.control.*;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Controller {

    @FXML
    Button btnCompile, btnExecute, btnStart, btnAyuda, btnButton;

    @FXML
    TextArea txtArea, txtAreaResults;

    @FXML
    Label desEjercicio, errores;

    private int numCompilaciones = 0, numErrores = 0;


    File root = new File("");

    private File sourceFile = null;

    public Controller() throws IOException {
    }

    public void initialize() throws IOException {
        String textAreaEnunciado = "public class SolucionEjercicio{\n" +
                "    public static void main(String[] args) {\n" +
                "      System.out.println(\"Hola veivis\");\n" +
                "    }\n" +
                "}";
        txtArea.setText(textAreaEnunciado);
        eventButtons();
    }

    private void eventButtons() {

        btnCompile.setOnAction((event) -> {
            System.out.println("compilAciones: " + numCompilaciones);

            btnExecute.setDisable(false);
            try {
                this.createFile();
                this.compile(sourceFile);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });


        btnExecute.setOnAction((event) -> {
            execute();
            System.out.println("Ejecutando");
        });

        btnButton.setOnAction((event) ->{

            try {
                List<String> lolita = muestraContenido("D:\\test\\output.txt");
                txtAreaResults.setText(lolita.get(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        btnStart.setOnAction((event) -> {
            if (btnStart.getText().equals("Iniciar")) {
                btnCompile.setDisable(false);
                btnAyuda.setDisable(false);
                txtAreaResults.setDisable(false);
                txtArea.setDisable(false);
                btnStart.setText("Suiguiente");
            }
        });
    }

    public static List<String> muestraContenido(String archivo) throws IOException {
        List<String> lola = new ArrayList<>();
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            lola.add(cadena);
        }
        b.close();
        return lola;
    }

    private void execute() {
        try {
            // create a process
            ProcessBuilder pb = new ProcessBuilder("cmd");

            // take all commands as input in a text file
            File commands = new File("D:\\test\\commands.txt");

            // File where error logs should be written
            File error = new File("D:\\test\\error.txt");

            // File where output should be written
            File output = new File("D:\\test\\output.txt");
 //           File output = new File("D:\\test\\output.txt");

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
            Iterable<? extends JavaFileObject> compilation =
                    fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sf));
            JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostic, null, null, compilation);
            txtAreaResults.setText("");
            verificaExito(task, diagnostic);
        } catch (Exception ex) {
            System.err.println("Hubo un error interno.");
        }
    }

    private void verificaExito(JavaCompiler.CompilationTask task, DiagnosticCollector<JavaFileObject> diagnostics) throws IOException {
        boolean hayExito = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println("Line " + diagnostic.getLineNumber());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));
            txtAreaResults.setText("");
            txtAreaResults.setText("Resultado:\n" + txtAreaResults.getText() + "\n" + diagnostic.getMessage(null) +
                    "\t Linea: " + diagnostic.getLineNumber());
        }
        if (hayExito) {
            txtAreaResults.setText("Felicidades compila!!");
        } else {
            numCompilaciones++;
            errores.setText("" + numCompilaciones);
        }
        System.out.println("Éxito: " + hayExito);

        if (hayExito) {
            try {
                Class.forName("Ejercicio").getDeclaredMethod("main", new Class[]{String[].class})
                        .invoke(null, new Object[]{null});
            } catch (ClassNotFoundException e) {
                System.err.println("Class not found: " + e);
            } catch (NoSuchMethodException e) {
                System.err.println("No such method: " + e);
            } catch (IllegalAccessException e) {
                System.err.println("Illegal access: " + e);
            } catch (InvocationTargetException e) {
                System.err.println("Invocation target: " + e);
            }
        }
    }


}
