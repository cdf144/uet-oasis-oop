import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(5.0, 8.0);
        Square s1 = new Square(point, 4.0, "RED", true);
        System.out.println(s1.toString());
        s1.setWidth(1.5);
        System.out.println(s1.toString());
    }
}
