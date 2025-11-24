import functions.*;

class lab_3 {
    static public void main(String[] args) throws InappropriateFunctionPointException {
        ArrayTabulatedFunction ATF = new ArrayTabulatedFunction(0,10,5);
        System.out.println("ПРОВЕРКА ArrayTabulatedFunction:");
        TestTabulatedFunction(ATF);

        LinkedListTabulatedFunction LLTF = new LinkedListTabulatedFunction(0,10,5);
        double[] values = new double[5];
        for (int i = 0; i<5;i++){
            values[i]=Math.sqrt(LLTF.getPointX(i));
        }
        LinkedListTabulatedFunction LLTF1 = new LinkedListTabulatedFunction(0,10,values);
        System.out.println("ПРОВЕРКА LinkedListTabulatedFunction:");
        System.out.println("Проверка конструктора с values[]: ");
        for (int i = 0; i<5;i++){
            System.out.printf("f%d = (%.3f, %.3f)%n", i, LLTF1.getPointX(i),LLTF1.getPointY(i));
        }
        TestTabulatedFunction(LLTF);
    }
    static void TestTabulatedFunction(TabulatedFunction function) throws InappropriateFunctionPointException {
        System.out.println("Функция root(x)");
        System.out.println("Область определения: [" + function.getLeftDomainBorder() + "; " + function.getRightDomainBorder() + "]");
        System.out.println("Количество точек: " + function.getPointsCount());

        System.out.println("\nТочки функции:");
        for (int i = 0; i < 5; i++) {
            function.setPointY(i, Math.sqrt(function.getPointX(i)));
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nЗначения f(x)  разных точках: ");
        double[] test = {1, 2.1, 11, -35, 632, 453.1, 5, 6, 7, 0};
        for (double x : test) {
            if (Double.isNaN(function.getFunctionValue(x))) {
                System.out.printf("f(%.3f): не определенно%n", x);
            } else {
                System.out.printf("f(%.3f) = %.3f%n", x, function.getFunctionValue(x));
            }
        }

        System.out.println("\nДобавление точки (5.55, sqrt(5.55)): ");
        FunctionPoint test_point = new FunctionPoint(5.55, Math.sqrt(5.55));
        function.addPoint(test_point);
        System.out.println("Точки функции:");
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nДобавление точки (9, sqrt(9)):");
        test_point = new FunctionPoint(9, Math.sqrt(9));
        function.addPoint(test_point);
        System.out.println("Точки функции:");
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nУдаление точки с номером 5:");
        System.out.printf("Точка f5 = (%.3f, %.3f)%n", function.getPointX(4), function.getPointY(4));
        function.deletePoint(4);
        System.out.println("Точки функции:");
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nУдаление точки с индексом 0:");
        System.out.printf("Точка f1 = (%.3f, %.3f)%n", function.getPointX(0), function.getPointY(0));
        function.deletePoint(0);
        System.out.println("Точки функции:");
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nЗамена точки с номером 2 на точку f = (4,sqrt(4))");
        test_point = new FunctionPoint(4, Math.sqrt(4));
        System.out.printf("Исходная точка: f2= (%.3f; %.3f)%n", function.getPointX(1), function.getPointY(1));
        function.setPoint(1, test_point);
        System.out.printf("Измененная точка: f2= (%.3f; %.3f)%n", function.getPointX(1), function.getPointY(1));
        System.out.println("Точки функции:");
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nЗамена точки с номером 5 по значению x = 9,5");
        System.out.printf("Исходная точка: f5= (%.3f; %.3f)%n", function.getPointX(4), function.getPointY(4));
        function.setPointX(4, 9.5);
        function.setPointY(4, Math.sqrt(9.5));
        System.out.printf("Измененная точка: f5= (%.3f; %.3f)%n", function.getPointX(4), function.getPointY(4));
        System.out.println("Точки функции:");
        for (int i = 0; i < function.getPointsCount(); i++) {
            System.out.printf("f%d: (%.3f; %.3f)%n", i + 1, function.getPointX(i), function.getPointY(i));
        }

        System.out.println("\nПроверка исключений:");
        try{
            System.out.println("   Проверка метода getPoint:\n" +
                    "       Попытка получить элемент с индексом "+function.getPointsCount());
            function.getPoint(function.getPointsCount());
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода setPoint:\n" +
                    "       Попытка внести элемент с индексом "+function.getPointsCount());
            function.setPoint(function.getPointsCount(), new FunctionPoint(0,0));
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n       Попытка внести точку F = (1, 1)");
            function.setPoint(3, new FunctionPoint(1,1));
            System.out.println("    Метод успешно сработал");
        }
        catch (InappropriateFunctionPointException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода getPointX:\n" +
                    "       Попытка вывести значение х точки с индексом "+function.getPointsCount());
            function.getPointX(function.getPointsCount());
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода setPointX:\n" +
                    "       Попытка внести значение х элемента с индексом "+function.getPointsCount());
            function.setPointX(function.getPointsCount(), 0);
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n       Попытка внести значение х = 1000 ");
            function.setPointX(3,1000);
            System.out.println("    Метод успешно сработал");
        }
        catch (InappropriateFunctionPointException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода getPointY:\n" +
                    "       Попытка вывести значение y точки с индексом "+function.getPointsCount());
            function.getPointY(function.getPointsCount());
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода setPointY:\n" +
                    "       Попытка внести значение Y элемента с индексом "+function.getPointsCount());
            function.setPointY(function.getPointsCount(), 0);
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода deletePoint:\n" +
                    "       Попытка удалить точку с индексом "+function.getPointsCount());
            function.deletePoint(function.getPointsCount());
            System.out.println("Метод успешно сработал");
        }
        catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }

        try{
            System.out.println("\n   Проверка метода addPoint:\n");
            System.out.printf("       Попытка добавить точку F (%.3f, %.3f):%n", function.getPointX(1),function.getPointY(1));
            function.addPoint(new FunctionPoint(function.getPointX(1),function.getPointY(1)));
            System.out.println("Метод успешно сработал");
        }
        catch (InappropriateFunctionPointException e){
            System.out.println("       Метод выдал ошибку: "+ e.getMessage());
        }
    }
}