import javafx.animation.AnimationTimer;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class gameLoop extends  AnimationTimer{

    private Snake Snake;
    private Mela Mela;
    private long Velocità;
    private long tempoIniziale = 0;

    public  gameLoop() {
        this.Snake = new Snake();
        this.Mela = new Mela();
        this.Velocità = 100_000_000;
    }

    @Override
    public void handle(long tempoCorrente ) {

        // Stampo il fondo nero
        Main.Pennello.setFill(Color.BLACK);
        Main.Pennello.fillRect( 0 ,0 ,700, 500);

        if ( tempoIniziale == 0) {
            tempoIniziale = tempoCorrente;
        }


        if(  tempoCorrente - tempoIniziale >= Velocità ){

            Snake.startSnake( Mela, this  );
            tempoIniziale = tempoCorrente;
        }

        Snake.stampaSnake();
        Mela.startMela();

    }

    public void addVelocità() {
        this.Velocità =  Velocità - 5_000_000;
    }

}
