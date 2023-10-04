package Week3.JUnit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Week4Test {
    @Test
    public void testMax2Int1(){
        int a = 2;
        int b = 3;
        int expected = 3;
        int actual = Week4.max2Int(a, b);

        assertEquals(expected, actual);
    }

    @Test
    public void testMax2Int2(){
        int a = -2;
        int b = 0;
        int expected = 0;
        int actual = Week4.max2Int(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testMax2Int3(){
        int a = -2;
        int b = 0;
        int expected = 0;
        int actual = Week4.max2Int(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testMax2Int4(){
        int a = -18475342;
        int b = -3845734;
        int expected = -3845734;
        int actual = Week4.max2Int(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testMax2Int5(){
        int a = 2147483647;
        int b = 12;
        int expected = Integer.MAX_VALUE;
        int actual = Week4.max2Int(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinArray1(){
        int[] array = {1};
        int expected = 1;
        int actual = Week4.minArray(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinArray2(){
        int[] array = {1, 2, 3, 4, 5};
        int expected = 1;
        int actual = Week4.minArray(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinArray3(){
        int[] array = {-1, 2, -3, -4, 5};
        int expected = -4;
        int actual = Week4.minArray(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinArray4(){
        int[] array = {1, 2, 1, 3, 4, 1};
        int expected = 1;
        int actual = Week4.minArray(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinArray5(){
        int[] array = {};
        int expected = 0;
        int actual = Week4.minArray(array);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateBMI1(){
        double weight = 50;
        double height = 1.7;
        String expected = "Thiếu cân";
        String actual = Week4.calculateBMI(weight, height);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateBMI2(){
        double weight = 65;
        double height = 1.7;
        String expected = "Bình thường";
        String actual = Week4.calculateBMI(weight, height);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateBMI3(){
        double weight = 70;
        double height = 1.7;
        String expected = "Thừa cân";
        String actual = Week4.calculateBMI(weight, height);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateBMI4(){
        double weight = 90;
        double height = 1.7;
        String expected = "Béo phì";
        String actual = Week4.calculateBMI(weight, height);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateBMI5(){
        // Test BMI of 18.5 edge case
        double weight = 53.465;
        double height = 1.7;
        String expected = "Bình thường";
        String actual = Week4.calculateBMI(weight, height);
        assertEquals(expected, actual);
    }
}
