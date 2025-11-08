package week10;
import java.util.ArrayList;
import java.util.Scanner;
public class Week10Program1 {

    static double convertToCelcius(String from, double temp) {
        double answer = temp;
        if (from.charAt(0) == 'f') {
            answer = (5.0 / 9) * (answer - 32);
        }
        if (from.charAt(0) == 'r') {
            answer = (5.0 / 9) * (answer - 492);
        }
        if (from.charAt(0) == 'k') {
            answer = answer - 273;
        }
        return answer;
    }

    static double convertFromCelcius(String to, double temp) {
        double answer = temp;
        if (to.charAt(0) == 'f') {
            answer = (9.0 / 5) * answer + 32;
        }
        if (to.charAt(0) == 'r') {
            answer = (9.0 / 5) * answer + 492;
        }
        if (to.charAt(0) == 'k') {
            answer = answer + 273;
        }
        return answer;
    }

    static class Metal {
        String name;
        double density;
        double meltC;
        double boilC;
        double hardness;

        Metal(String name, double density, double meltC, double boilC, double hardness) {
            this.name = name;
            this.density = density;
            this.meltC = meltC;
            this.boilC = boilC;
            this.hardness = hardness;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Metal> metals = new ArrayList<>();

        System.out.println("=== Metal Information Entry Program ===");
        System.out.println("Enter information about metals. Temperatures will be displayed in Fahrenheit.");

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("\nEnter metal name: ");
            String name = input.nextLine();

            System.out.print("Enter density (g/cm^3): ");
            double density = input.nextDouble();

            System.out.print("Enter melting point (°C): ");
            double melt = input.nextDouble();

            System.out.print("Enter boiling point (°C): ");
            double boil = input.nextDouble();

            System.out.print("Enter hardness (0–10): ");
            double hardness = input.nextDouble();

            input.nextLine(); 
            metals.add(new Metal(name, density, melt, boil, hardness));

            System.out.print("\nAdd another metal? (y/n): ");
            choice = input.nextLine();
        }

        System.out.println("\n=== Metal Properties (Temperatures in °F) ===");
        System.out.printf("%-15s %-12s %-15s %-15s %-10s%n", "Name", "Density", "Melting (°F)", "Boiling (°F)", "Hardness");
        System.out.println("--------------------------------------------------------------------------");

        for (Metal m : metals) {
            double meltF = convertFromCelcius("f", m.meltC);
            double boilF = convertFromCelcius("f", m.boilC);
            System.out.printf("%-15s %-12.2f %-15.2f %-15.2f %-10.1f%n",
                    m.name, m.density, meltF, boilF, m.hardness);
        }

        System.out.println("\nThanks for using the Metal Info program!");
        input.close();
    }


	

}
