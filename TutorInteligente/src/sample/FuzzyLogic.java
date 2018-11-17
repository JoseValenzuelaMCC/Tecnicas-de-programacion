package sample;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;
public class FuzzyLogic {
    private Variable dificultad;

    public FuzzyLogic(){

    }

    public double getDifusa(int errores, int tiempo, int ayudas, int nivelActual){

        String tutor = "tipper.fcl";
        FIS fis = FIS.load(tutor,true);
        if(fis == null){
            System.out.println("No se cargo el archivo .fcl");
        }else{
            fis.setVariable("errores", errores);
            fis.setVariable("tiempo", tiempo);
            fis.setVariable("ayudas", ayudas);
            fis.setVariable("nivelActual", nivelActual);


            fis.evaluate();
            dificultad = fis.getVariable("nivel");

        }

        return dificultad.getValue();
    }
}
