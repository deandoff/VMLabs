package lab3_4;

public class Main {
    private static final double EPS = 0.001;
    private static final int x_0 = 3;
    private static final int y_0 = 2;

    public static double F1 (double x, double y) {
        return x * x + y * y - 4;
    }

    public static double F2 (double x, double y) {
        return x - y - 2;
    }

    public static void MPI(double x, double y) {
        int k = 0;
        double x_k = x;
        double y_k = y;
        double x_k_1;
        double y_k_1;

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("|   k   |     x(k)     |    x(k+1)    | |x(k+1)-x(k)|  |     y(k)     |    y(k+1)    |  |y(k+1)-y(k)| |");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        while (true) {
            x_k_1 = x_k - 0.1 * F1(x_k, y_k) - 0.4 * F2(x_k, y_k);
            y_k_1 = y_k - 0.1 * F1(x_k, y_k) + 0.6 * F2(x_k, y_k);

            System.out.printf("| %5d | %12.7f | %12.7f | %14.7f | %12.7f | %12.7f | %14.7f |%n", k, x_k, x_k_1, Math.abs(x_k_1-x_k), y_k, y_k_1, Math.abs(y_k_1-y_k));

            if (Math.abs(x_k_1-x_k) <= EPS && Math.abs(y_k_1-y_k) <= EPS) {
                break;
            }

            k++;
            x_k = x_k_1;
            y_k = y_k_1;

        }
    }

    public static void MN(double x, double y) {
        int k = 0;
        double x_k = x;
        double y_k = y;
        double x_k_1;
        double y_k_1;

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("|   k   |     x(k)     |    x(k+1)    | |x(k+1)-x(k)|  |     y(k)     |    y(k+1)    |  |y(k+1)-y(k)| |");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        while (true) {
            x_k_1 = x_k - (x_k * x_k - y_k * y_k - 4 + 2 * x_k * y_k - 4 * y_k) / (2 * x_k + 2 * y_k);
            y_k_1 = y_k - (-(x_k * x_k) + y_k * y_k - 4 + 2 * x_k * y_k + 4 * x_k) / (2 * x_k + 2 * y_k);

            System.out.printf("| %5d | %12.7f | %12.7f | %14.7f | %12.7f | %12.7f | %14.7f |%n", k, x_k, x_k_1, Math.abs(x_k_1-x_k), y_k, y_k_1, Math.abs(y_k_1-y_k));

            if (Math.abs(x_k_1-x_k) <= EPS && Math.abs(y_k_1-y_k) <= EPS) {
                break;
            }

            k++;
            x_k = x_k_1;
            y_k = y_k_1;

        }
    }

    public static void main(String[] args) {
        System.out.println("МЕТОД ПРОСТЫХ ИТЕРАЦИЙ");
        MPI(x_0, y_0);

        System.out.println("\n\n");

        System.out.println("МЕТОД НЬЮТОНА");
        MN(x_0, y_0);
    }
}