import javafx.scene.paint.Color;

public class Quadrato {

    public static final double DIMENSIONE_QUADRATO = 10;
    private double Y;
    private double X;


    public Quadrato(){}
    public Quadrato( double X, double Y ) {
        this.X = X;
        this.Y = Y;
    }

    public  void stampaQuadrato( ) {
        Main.Pennello.setFill( Color.WHITE);
        Main.Pennello.fillRect( X , Y , Quadrato.DIMENSIONE_QUADRATO, Quadrato.DIMENSIONE_QUADRATO );
    }
    public  void stampaQuadrato( Color color  ) {
        Main.Pennello.setFill( color );
        Main.Pennello.fillRect( X , Y , Quadrato.DIMENSIONE_QUADRATO, Quadrato.DIMENSIONE_QUADRATO );
    }

    public double getX() {
        return X;
    }
    public double getY() {
        return Y;
    }
    public void setX(double x) {
        X = x;
    }
    public void setY(double y) {
        Y = y;
    }

}
