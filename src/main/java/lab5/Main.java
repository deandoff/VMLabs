package lab5;

public class Main {
    private static final double EPS1 = 0.001;
    private static final double EPS2 = 0.00001;

    private static final double X_0_1 = 1.0;
    private static final double Y_0_1 = 1.0;
    private static final double Z_0_1 = (double) 1 / 3;

    private static final double X_0_2 = -1.0;
    private static final double Y_0_2 = -1.0;
    private static final double Z_0_2 = (double) -1 / 3;

    public static void MPI(double x, double y, double z, double EPS) {
        int k = 0;
        double x_k = x;
        double y_k = y;
        double z_k = z;
        double x_k_1;
        double y_k_1;
        double z_k_1;

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|   k   |     x(k)     |    x(k+1)    | |x(k+1)-x(k)|  |     y(k)     |    y(k+1)    |  |y(k+1)-y(k)| |     z(k)     |    z(k+1)    |  |z(k+1)-z(k)| |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

        while (true) {
            x_k_1 = 1 + (((double) 1 /3) * y_k) - (((double) 1 /3) * z_k);
            y_k_1 = 1 - (((double) 2 /5) * x_k) + (((double) 2 /5) * z_k);
            z_k_1 = ((double) 1 /3) + (((double) 1 /3) * x_k) + (((double) 1 /3) * y_k);

            System.out.printf("| %5d | %12.7f | %12.7f | %14.7f | %12.7f | %12.7f | %14.7f | %12.7f | %12.7f | %14.7f |%n", k, x_k, x_k_1, Math.abs(x_k_1-x_k),
                    y_k, y_k_1, Math.abs(y_k_1-y_k), z_k, z_k_1, Math.abs(z_k_1-z_k));

            if (Math.abs(x_k_1-x_k) <= EPS && Math.abs(y_k_1-y_k) <= EPS && Math.abs(z_k_1-z_k) <= EPS ) {
                break;
            }

            k++;
            x_k = x_k_1;
            y_k = y_k_1;
            z_k = z_k_1;
        }

    }

    public static void Seidel(double x, double y, double z, double EPS) {
        int k = 0;
        double x_k = x;
        double y_k = y;
        double z_k = z;
        double x_k_1;
        double y_k_1;
        double z_k_1;

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|   k   |     x(k)     |    x(k+1)    | |x(k+1)-x(k)|  |     y(k)     |    y(k+1)    |  |y(k+1)-y(k)| |     z(k)     |    z(k+1)    |  |z(k+1)-z(k)| |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

        while (true) {
            x_k_1 = 1 + (((double) 1 /3) * y_k) - (((double) 1 /3) * z_k);
            y_k_1 = 1 - (((double) 2 /5) * x_k_1) + (((double) 2 /5) * z_k);
            z_k_1 = ((double) 1 /3) + (((double) 1 /3) * x_k_1) + (((double) 1 /3) * y_k_1);

            System.out.printf("| %5d | %12.7f | %12.7f | %14.7f | %12.7f | %12.7f | %14.7f | %12.7f | %12.7f | %14.7f |%n", k, x_k, x_k_1, Math.abs(x_k_1-x_k),
                    y_k, y_k_1, Math.abs(y_k_1-y_k), z_k, z_k_1, Math.abs(z_k_1-z_k));

            if (Math.abs(x_k_1-x_k) <= EPS && Math.abs(y_k_1-y_k) <= EPS && Math.abs(z_k_1-z_k) <= EPS ) {
                break;
            }

            k++;
            x_k = x_k_1;
            y_k = y_k_1;
            z_k = z_k_1;
        }
    }

    public static void main(String[] args) {
        System.out.println("МЕТОД ПРОСТЫХ ИТЕРАЦИЙ");
        MPI(X_0_2, Y_0_2, Z_0_2, EPS2);

        System.out.println("\n\n");

        System.out.println("МЕТОД ЗЕЙДЕЛЯ");
        Seidel(X_0_2, Y_0_2, Z_0_2, EPS2);
    }


}
