import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene Scena;
    public static Stage Finestra;
    private Canvas Tela;
    public static GraphicsContext Pennello;

    public void init(){
        Group root = new Group();
        this.Scena = new Scene( root, 700, 500 );
        this.Tela = new Canvas( 700, 500 );
        this.Pennello = Tela.getGraphicsContext2D();

        root.getChildren().add( Tela );
    }

    @Override
    public void start(Stage Finestra) throws Exception {

        // Creo il game loop
        gameLoop gameLoop = new gameLoop();
        gameLoop.handle( System.nanoTime() );
        gameLoop.start();

        Finestra.setTitle("Snake game");
        Finestra.setScene( Scena );
        this.Finestra = Finestra;
        Finestra.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        fineGioco();
    }

    private void fineGioco() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle( "Game Over ");
        alert.setHeaderText( "Hai ottenuto: ");
        alert.setContentText( Snake.Punti + " Punti! ");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch( args );
    }
}
