package _00_TEST;

public class Main {
    public static String noDoppie (String parola) {
        for (int i = 0; i < parola.length()-1; i++) {
            if  (parola.charAt(i) == parola.charAt(i+1)){
                String sub = parola.substring(0, i);
                String sub2 = parola.substring(i+1);
                parola = sub + sub2;
            }
        }
        return parola;
    }

    public static void main(String[] args) {
        String parola = "gattomatto";
        System.out.println(noDoppie(parola));
    }
}