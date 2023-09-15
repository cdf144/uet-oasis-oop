import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce your name, average grade and age");

        String userName = sc.nextLine();
        Double averageGrade = sc.nextDouble();
        Integer age = sc.nextInt();

        System.out.printf("%-25s%-5.2f %-5d", userName, averageGrade, age);
    }
}
