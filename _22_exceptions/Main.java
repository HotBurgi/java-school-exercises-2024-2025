package _22_exceptions;

public class Main {
    public static void main(String[] args) {
        // index out of bounds exception
        try {
            int[] arr = new int[5];
            System.out.println(arr[6]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // null pointer exception
        try {
            String str = null;
            System.out.println(str.length());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // arithmetic exception
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // number format exception
        try {
            int num = Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}