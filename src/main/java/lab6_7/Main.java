package lab6_7;

public class Main {

    public static final double a = 0.0;
    public static final double b = 1.0;

    public static final double[] x_i = {a, (b - a)/2, b};
    public static double[] y_i = new double[3];

    public static double[] a_i = new double[3];

    public static final double n = 20;

    public static double F(double x) {
        return 8.8/Math.sqrt(Math.PI) * (Math.pow(Math.E, (2 * x + 3)/(x * x + 1)));
    }


    public static void ExpTable() {
        y_i[0] = F(x_i[0]);
        y_i[1] = F(x_i[1]);
        y_i[2] = F(x_i[2]);

        System.out.println("ТАБЛИЦА ЗНАЧЕНИЙ ЭКСПИРЕМЕНТАЛЬНОЙ ФУНКЦИИ");

        System.out.println("----------------------------------------------------");
        System.out.printf("| x_i | %12.3f | %12.3f | %12.3f |%n", x_i[0], x_i[1], x_i[2]);
        System.out.printf("| y_i | %12.3f | %12.3f | %12.3f |%n", y_i[0], y_i[1], y_i[2]);
        System.out.println("----------------------------------------------------");

    }

    public static double Newton_I(double t) {
        double[] dy = {y_i[1] - y_i[0], y_i[2] - y_i[1]};
        return y_i[0] + t * dy[0] + t * (t - 1) / 2 * (dy[1] - dy[0]);
    }

    public static double Newton_II(double t) {
        double[] dy = { y_i[1] - y_i[0], y_i[2] - y_i[1] };
        return y_i[2] + t * dy[1] + t * (t + 1) / 2 * (dy[1] - dy[0]);
    }

    public static double Approximation(double x) {
        double[] sum_x = new double[5]; 
        double sum_y, sum_x_y, sum_x_x_y;
        double[] det = new double[4];
        sum_x[1] = x_i[0] + x_i[1] + x_i[2];
        sum_x[2] = (x_i[0] * x_i[0]) + (x_i[1] * x_i[1]) + (x_i[2] * x_i[2]);
        sum_x[3] = (x_i[0] * x_i[0] * x_i[0]) + (x_i[1] * x_i[1] * x_i[1]) + (x_i[2] * x_i[2] * x_i[2]);
        sum_x[4] = (x_i[0] * x_i[0] * x_i[0] * x_i[0]) + (x_i[1] * x_i[1] * x_i[1] * x_i[1]) + (x_i[2] * x_i[2] * x_i[2] * x_i[2]);
        sum_y = y_i[0] + y_i[1] + y_i[2];
        sum_x_y = x_i[0] * y_i[0] + x_i[1] * y_i[1] + x_i[2] * y_i[2];
        sum_x_x_y = x_i[0] * x_i[0] * y_i[0] + x_i[1] * x_i[1] * y_i[1] + x_i[2] * x_i[2] * y_i[2];
        det[0] = 3 * sum_x[2] * sum_x[4] + sum_x[1] * sum_x[3] * sum_x[2] + sum_x[2] * sum_x[1] * sum_x[3] - sum_x[2] * sum_x[2] * sum_x[2] - sum_x[3] * sum_x[3] * 3 - sum_x[4] * sum_x[1] * sum_x[1];
        det[1] = sum_y * sum_x[2] * sum_x[4] + sum_x[1] * sum_x[3] * sum_x_x_y + sum_x[2] * sum_x_y * sum_x[3] - sum_x_x_y * sum_x[2] * sum_x[2] - sum_x[3] * sum_x[3] * sum_y - sum_x[4] * sum_x_y * sum_x[1];
        det[2] = 3 * sum_x_y * sum_x[4] + sum_y * sum_x[3] * sum_x[2] + sum_x[2] * sum_x[1] * sum_x_x_y - sum_x[2] * sum_x_y * sum_x[2] - sum_x_x_y * sum_x[3] * 3 - sum_x[4] * sum_x[1] * sum_y;
        det[3] = 3 * sum_x[2] * sum_x_x_y + sum_x[1] * sum_x_y * sum_x[2] + sum_y * sum_x[1] * sum_x[3] - sum_x[2] * sum_x[2] * sum_y - sum_x[3] * sum_x_y * 3 - sum_x_x_y * sum_x[1] * sum_x[1];
        a_i[0] = det[1] / det[0];
        a_i[1] = det[2] / det[0];
        a_i[2] = det[3] / det[0];

        return a_i[2] * x * x + a_i[1] * x + a_i[0];
    }

    public static double Lagrange(double x) {
        a_i[0] = y_i[0] / ((x_i[0] - x_i[1]) * (x_i[0] - x_i[2]));
        a_i[1] = y_i[1] / ((x_i[1] - x_i[0]) * (x_i[1] - x_i[2]));
        a_i[2] = y_i[2] / ((x_i[2] - x_i[0]) * (x_i[2] - x_i[1]));

        return a_i[0] * (x - x_i[1]) * (x - x_i[2]) + a_i[1] * (x - x_i[0]) * (x - x_i[2]) + a_i[2] * (x - x_i[0]) * (x - x_i[1]);
    }

    public static void ProximaTable() {
        double x = x_i[0];
        double t_1 = 0.0;
        double t_2 = -2.0;

        System.out.println("ТАБЛИЦА ЗНАЧЕНИЙ ПОЛИНОМОВ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|   i   |      xi      |      ti      |      t'i     |     F(xi)    |    L2(xi)    | |(f(xi) - L2(xi))| |    N1(xi)    | |(f(xi) - N1(xi))| |    N2(xi)    | |(f(xi) - N2(xi))| |    P2(xi)    | |(f(xi) - P2(xi))| |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i <= n; i++) {

            System.out.printf("| %5d | %12.5f | %12.5f | %12.5f | %12.5f | %12.5f | %18.5f | %12.5f | %18.5f | %12.5f | %18.5f | %12.5f | %18.5f |%n",
                    i, x, t_1, t_2, F(x), Lagrange(x), Math.abs(F(x) - Lagrange(x)), Newton_I(t_1), Math.abs(F(x) - Newton_I(t_1)), Newton_II(t_2),
                    Math.abs(F(x) - Newton_II(t_2)), Approximation(x), Math.abs(F(x) - Approximation(x)));
            x += (b - a) / n;
            t_1 += 2.0 / n;
            t_2 += 2.0 / n;

        }

    }

    public static void main(String[] args) {

        ExpTable();
        ProximaTable();
    }

    


}
