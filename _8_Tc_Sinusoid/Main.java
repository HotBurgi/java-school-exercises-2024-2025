package _8_Tc_Sinusoid;

public class Main {
    final static double pi = Math.PI;

    public static void main(String[] args) {

        System.out.print("12 sin(200π*t + π/4)");

        double amplitude = 12;
        double frequencyFactor = 200;
        double phase = pi / 4;

        double frequency = frequencyFactor / (2 * pi);
        double T = 1 / frequency;
        double dT = T / 10 * 1000;

        System.out.print(" and sin(600π*t + π/8)");

        double noiseAmplitude = 1;
        double noiseFrequencyFactor = 600;
        double noisePhase = pi / 8;

        double noiseFrequency = noiseFrequencyFactor / (2 * pi);
        double noiseT = 1 / noiseFrequency;
        double dTNoise = noiseT / 10 * 1000;

        if (dT > dTNoise) {
            dT = dTNoise;
        }

        System.out.println("\nSignal: ");
        System.out.println("T(ms)|  Y  ");

        for (int i = 0; i < 10; i++) {
            double time = dT * i;
            System.out.printf("%.2f", time);
            System.out.print(" | ");
            double ordinate = amplitude * Math.sin(frequencyFactor * time / 1000 + phase);
            System.out.printf("%.2f%n", ordinate);
        }

        System.out.println("\nNoise: ");
        System.out.println("T(ms)|  Y  ");

        for (int i = 0; i < 10; i++) {
            double time = dT * i;
            System.out.printf("%.2f", time);
            System.out.print(" | ");
            double noiseOrdinate = noiseAmplitude * Math.sin(noiseFrequencyFactor * time / 1000 + noisePhase);
            System.out.printf("%.2f%n", noiseOrdinate);
        }
    }
}
// test commit