public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    // Phương thức trả về nghiệm thứ nhất
    public double getRoot1() {
        double delta = getDiscriminant(); // Lấy giá trị delta
        if (delta >= 0) {
            return (-b + Math.pow(delta, 0.5)) / (2 * a);
        } else {
            return 0; // Trả về 0 nếu delta < 0
        }
    }

    // Phương thức trả về nghiệm thứ hai
    public double getRoot2() {
        double delta = getDiscriminant(); // Lấy giá trị delta
        if (delta >= 0) {
            return (-b - Math.pow(delta, 0.5)) / (2 * a);
        } else {
            return 0; // Trả về 0 nếu delta < 0
        }
    }
}