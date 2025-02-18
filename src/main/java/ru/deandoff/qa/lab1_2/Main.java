package ru.deandoff.qa.lab1_2;

import java.util.Scanner;

public class Main {
    private static final double C = 0.04;

    private static final double EPS_1 = 0.001;
    private static final double EPS_2 = 0.0001;

    private static final double D_1 = 0.01;
    private static final double D_2 = 0.001;

    public static double F(double x) {
        return 3 * Math.cos(2 * x) - x + 0.25;
    }

    public static double dF (double x) {
        return -6 * Math.sin(2 * x) - 1;
    }

    public static void MPI(double x, double eps, double d) {
        int n = 0;
        int maxIter = 10000;

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|   n   |     Xn       |     Xn+1     |  |Xn+1 - Xn|   |   |f(Xn+1)|    |");
        System.out.println("--------------------------------------------------------------------------------");

        while (n < maxIter) {
            double z = x;
            double y = z + C * F(z);

            System.out.printf("| %5d | %12.5f | %12.5f | %14.5f | %14.5f |%n", n, z, y, Math.abs(y - z), Math.abs(F(y)));

            if (Math.abs(y - z) <= eps && Math.abs(F(y)) <= d) {
                break;
            }

            x = y;
            n++;
        }

        if (n == maxIter) {
            System.out.println("Достигнуто максимальное количество итераций. Метод не сошелся.");
        }
    }

    public static void NM(double x, double eps, double d) {
        int n = 0;
        int maxIter = 10000;

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|   n   |     Xn       |     Xn+1     |  |Xn+1 - Xn|   |   |f(Xn+1)|    |");
        System.out.println("--------------------------------------------------------------------------------");

        while (n < maxIter) {
            double z = x;
            double y = z - F(z) / dF(z);

            System.out.printf("| %5d | %12.5f | %12.5f | %14.5f | %14.5f |%n", n, z, y, Math.abs(y - z), Math.abs(F(y)));

            if (Math.abs(y - z) <= eps && Math.abs(F(y)) <= d) {
                break;
            }

            x = y;
            n++;
        }

        if (n == maxIter) {
            System.out.println("Достигнуто максимальное количество итераций. Метод не сошелся.");
        }
    }

    public static void MNM(double x, double eps, double d) {
        int n = 0;
        double x0 = x;
        int maxIter = 10000;

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("|   n   |     Xn       |     Xn+1     |  |Xn+1 - Xn|   |   |f(Xn+1)|    |");
        System.out.println("--------------------------------------------------------------------------------");

        while (n < maxIter) {
            double z = x;
            double y = z - F(z) / dF(x0);

            System.out.printf("| %5d | %12.5f | %12.5f | %14.5f | %14.5f |%n", n, z, y, Math.abs(y - z), Math.abs(F(y)));

            if (Math.abs(y - z) <= eps && Math.abs(F(y)) <= d) {
                break;
            }

            x = y;
            n++;
        }

        if (n == maxIter) {
            System.out.println("Достигнуто максимальное количество итераций. Метод не сошелся.");
        }
    }

    public static void main(String[] args) {
        System.out.println("f(x) = 3cos(2x)-x+0.25");
        System.out.println("Введите начальное приближение Х0 [3.2; 3.5]");
        Scanner input = new Scanner(System.in);
        double x = Double.parseDouble(input.nextLine());

        System.out.println("Метод простых итераций");
        System.out.println("Для eps = 0.001 и d = 0.01");
        MPI(x, EPS_1, D_1);
        System.out.println("Для eps = 0.0001 и d = 0.001");
        MPI(x, EPS_2, D_2);
        System.out.println();

        System.out.println("Метод Ньютона");
        System.out.println("Для eps = 0.001 и d = 0.01");
        NM(x, EPS_1, D_1);
        System.out.println("Для eps = 0.0001 и d = 0.001");
        NM(x, EPS_2, D_2);
        System.out.println();

        System.out.println("Модифицированный метод Ньютона");
        System.out.println("Для eps = 0.001 и d = 0.01");
        MNM(x, EPS_1, D_1);
        System.out.println("Для eps = 0.0001 и d = 0.001");
        MNM(x, EPS_2, D_2);
        System.out.println();


    }
}
