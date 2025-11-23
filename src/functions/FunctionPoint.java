package functions;

public class FunctionPoint {
    private double x;
    private double y;

    public FunctionPoint(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double value) {
        this.x = value;
    }
    public void setY(double value){
        this.y=value;
    }

    public FunctionPoint(FunctionPoint point){
        this(point.getX(), point.getY());
    }

    public FunctionPoint(){
        this(0,0);
    }
}
