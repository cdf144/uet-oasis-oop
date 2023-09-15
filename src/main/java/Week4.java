public class Week4 {
    public static int max2Int(int a, int b) {
        // Tim gia tri lon nhat cua hai so nguyen
        return Math.max(a, b);
    }

    public static int minArray (int[] array) {
        // Tim gia tri nho nhat cua 1 mang so nguyen
        if (array.length == 0)
            return 0;

        int minVal = array[0];

        for (int i=1; i<array.length; ++i)
            if (array[i] < minVal)
                minVal = array[i];

        return minVal;
    }

    public static String calculateBMI(double weight, double height){
        // Tinh BMI
        double BMI = weight / (height*height);

        int precision = 1;
        int scale = (int) Math.pow(10, precision);
        BMI = (double) Math.round(BMI * scale) / scale;

        if (BMI < 18.5)
            return "Thiếu cân";
        else if (BMI <= 22.9)
            return "Bình thường";
        else if (BMI <= 24.9)
            return "Thừa cân";
        else
            return "Béo phì";
    }
}