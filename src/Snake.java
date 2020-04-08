import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Snake {

    private ArrayList<Quadrato> Snake;
    public static int Punti;
    private String Direzione;

    public Snake() {
        this.Snake = new ArrayList<Quadrato>();
        Snake.add( new Quadrato( 350, 250 ) );
        Snake.add( new Quadrato(  ) );
        Snake.add( new Quadrato(  ) );
        this.Direzione = "LEFT";
        this.Punti = 0;
    }

    public void stampaSnake() {
        for ( Quadrato elemento : Snake ){
            elemento.stampaQuadrato();
        }
    }
    private void coordinaQuadratiSnake() {
        for ( int i = Snake.size() - 1 ; i >= 1 ; i-- ){
            Snake.get( i ).setX( Snake.get(i -1).getX() );
            Snake.get( i ).setY( Snake.get(i -1).getY() );
        }
    }
    private void leggiTastiera() {

        Main.Scena.setOnKeyPressed(

                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent Tasto ) {

                        switch ( Tasto.getCode().toString()  ){

                            case "RIGHT":
                                if ( Direzione != "LEFT")
                                    Direzione =  "RIGHT";
                                break;

                            case "LEFT":
                                if ( Direzione != "RIGHT")
                                    Direzione = "LEFT";
                                break;

                            case "UP":
                                if ( Direzione != "DOWN")
                                    Direzione = "UP";
                                break;

                            case "DOWN":
                                if ( Direzione != "UP")
                                    Direzione =  "DOWN";
                                break;

                        }
                    }
                }
        );
    }
    private void muoviSnake() {

        Quadrato Testa = Snake.get(0);
        Boolean toccaBordo = Testa.getX() != 690 && Testa.getX() != 0 &&  Testa.getY() != 0  && Testa.getY() != 490;

        if( toccaBordo ){
            switch ( Direzione ){
                case "RIGHT":
                    Testa.setX( Testa.getX() + 10 );
                    break;

                case "LEFT":
                    Testa.setX( Testa.getX() - 10 );
                    break;

                case "UP":
                    Testa.setY( Testa.getY() - 10 );
                    break;

                case "DOWN":
                    Testa.setY( Testa.getY() + 10 );
                    break;
            }
        }else{
            Main.Finestra.close();
        }

        // Controllo che non si sovrapponga la testa al corpo
        for ( int i = 1 ; i <= Snake.size() - 1 ; i++ ){
            if( Testa.getX() == Snake.get(i).getX() && Testa.getY() == Snake.get(i).getY() ){
                Main.Finestra.close();
            }
        }

    }
    private void mangiaMela( Mela Mela, gameLoop Loop ) {

        if ( Snake.get(0).getX() == Mela.getX() && Snake.get(0).getY() == Mela.getY()  ){
            Mela.setMangiata(true);
            Snake.add( new Quadrato() );
            Loop.addVelocità();
            Punti += 1;
        }

    }

    public void startSnake( Mela Mela, gameLoop Loop ) {
        mangiaMela( Mela , Loop );
        leggiTastiera();
        muoviSnake();
        coordinaQuadratiSnake();
    }

    public ArrayList<Quadrato> getSnake() {
        return Snake;
    }
}
