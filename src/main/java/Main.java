import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(5.0, 8.0);
        Shape s1 = new Square(point, 4.0, "", true);
        System.out.println(s1.toString());
        Rectangle s2 = new Square(point, 2.5, "TRUE", true);
        System.out.println(s2.toString());
    }
}
