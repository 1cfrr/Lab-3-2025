package functions;

public interface TabulatedFunction {
    public double getLeftDomainBorder();
    public double getRightDomainBorder();
    public double getFunctionValue(double x);
    public int getPointsCount();
    public functions.FunctionPoint getPoint(int index);
    public void setPoint(int index, functions.FunctionPoint point) throws functions.InappropriateFunctionPointException;
    public double getPointX(int index);
    public void setPointX(int index, double x) throws functions.InappropriateFunctionPointException;
    public double getPointY(int index);
    public void setPointY(int index, double y);
    public void deletePoint(int index);
    public void addPoint(functions.FunctionPoint point) throws functions.InappropriateFunctionPointException;
}
