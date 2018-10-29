package sample;

import javafx.fxml.FXML;

import javafx.scene.CacheHint;
import javafx.scene.control.*;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Controller {

    @FXML
    Button btnCompile, btnExecute;

    @FXML
    TextArea txtArea, txtAreaResults;

    File root = new File("");

    File sourceFile = null;

    public void initialize(){
        String textAreaEnunciado = "public class Ejercicio{\n" +
                "    public static void main(String[] args) {\n" +
                "        //Empieza a codificar la solución\n" +
                "    }\n" +
                "}";
        txtArea.setText(textAreaEnunciado);
        eventButtons();
    }

    /*aprivate void leerArchivo(){
        try{
            Scanner archivo = new Scanner(new File("Ejercicios"));
            ArrayList<String> contenido =
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }*/

    private void eventButtons(){
        btnCompile.setOnAction((event) -> {

           try{
               this.createFile();
               this.compile(sourceFile);

           } catch (IOException ex){
               System.err.println(ex.getMessage());
           }
        });

        btnExecute.setOnAction((event) -> {
        try {
            this.execute();
        } catch (Exception ex){
            System.out.println("Exeption: " + ex);
        }

        });

    }
    private void execute(){
        try{
            ProcessBuilder pb = new ProcessBuilder("java.exe", "Resolutiion.java");
            pb.start();
            System.out.println("Executing");
        }catch (Exception ex){
            System.out.println("Exception: " + ex);
        }
    }

    private void createFile() throws IOException {

        sourceFile = new File(root.getAbsolutePath()+"\\Solutions","\\Resolutiion.java");
        Writer writer = new FileWriter(sourceFile);
        writer.write(this.txtArea.getText());
        writer.close();
    }

    private void compile(File sf){
        try{
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector<JavaFileObject> diagnostic = new DiagnosticCollector<>();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
            Iterable<? extends JavaFileObject> compilation =
                    fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sf));
            JavaCompiler.CompilationTask task = compiler.getTask(null,null,diagnostic,null,null,compilation);
            txtAreaResults.setText("");
            verificaExito(task,diagnostic);
        }catch (Exception ex){
            System.err.println("Hubo un error interno.");
        }
    }

    private void verificaExito(JavaCompiler.CompilationTask task, DiagnosticCollector<JavaFileObject> diagnostics) {
        boolean hayExito = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println("Line "+diagnostic.getLineNumber());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));
            txtAreaResults.setText("");
            txtAreaResults.setText("Resultado:\n"+txtAreaResults.getText()+"\n"+diagnostic.getMessage(null)+
                    "\t Linea: "+diagnostic.getLineNumber());
        }
        if(hayExito){
            txtAreaResults.setText("Felicidades compila!!");
        }
        System.out.println("Éxito: " + hayExito);

        if (hayExito) {
            try {
                Class.forName("Ejercicio").getDeclaredMethod("main", new Class[] { String[].class })
                        .invoke(null, new Object[] { null });
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
