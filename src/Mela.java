import javafx.scene.paint.Color;

import java.util.Random;

public class Mela extends Quadrato{

    private boolean Mangiata;

    public Mela() {
        super();
        this.Mangiata = true;
    }
    private void randomizzaPosizione(){

        Random rand = new Random();

        int minimoX = 2;
        int massimoX = 68;

        double X = ( rand.nextInt((massimoX - minimoX) + 1) + minimoX ) * 10.0;

        int minimoY = 2;
        int massimoY = 48;

        double Y = ( rand.nextInt((massimoY - minimoY) + 1) + minimoY ) * 10.0;

        super.setX( X );
        super.setY( Y );

        Mangiata = false;

    }
    private void stampaMela () {

        if( Mangiata ){
            randomizzaPosizione();
        }

        super.stampaQuadrato( Color.RED );
    }


    public void startMela() {
        stampaMela();
    }
    public void setMangiata(boolean mangiata) {
        Mangiata = mangiata;
    }

}
