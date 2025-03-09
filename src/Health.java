import java.util.Scanner;

class Health {

    public static void main(String[] a) {
        store(); // Calls the method doing the work
    }

    //stores data about a new river
    public static River new_river(String place, Scanner scanner){
        River river = new River();
        System.out.println("Name the " + place + " river:");
        river.name = scanner.nextLine();
        river.chemicals = chemicals(scanner);
        river.bacteria = bacteria(scanner);
        // Update quality based on water quality
        river.quality = water_quality(river.chemicals,river.bacteria);
        return river;
    }

    //check if inputs are numbers
    // Method to check if the input is numeric
    public static boolean isNumeric(String str) {
        boolean number = false;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                number = true;
            } else {
                return false;
            }
        }
        return number;
    }

    //get amount of chemicals
    public static int chemicals(Scanner scanner) {
        String chemical_parts = "";
        int forever_chemicals = -1;

        while (forever_chemicals < 0) {
            System.out.println("What level of forever chemicals were found (in parts per trillion)?");
            chemical_parts = scanner.nextLine();

            while (!isNumeric(chemical_parts)) {
                System.out.println("Invalid input. Please enter a numeric value:");
                chemical_parts = scanner.nextLine();
            }
            forever_chemicals = Integer.parseInt(chemical_parts);
        }
        return forever_chemicals;
    }

    //get amount of bacteria
    public static int bacteria(Scanner scanner) {
        String contamination_CFU = "";
        int bacterial_contamination = -1;

        while (bacterial_contamination < 0) {
            System.out.println("What level of bacterial contamination was found (in CFU per 100 ml)?");
            contamination_CFU = scanner.nextLine();

            while (!isNumeric(contamination_CFU)) {
                System.out.println("Invalid input. Please enter a numeric value:");
                contamination_CFU = scanner.nextLine();
            }
            bacterial_contamination = Integer.parseInt(contamination_CFU);
        }
        return bacterial_contamination;
    }

    //give the river and its water quality
    public static void printRiverDetails(River river) {
        String quality;
        if (river.quality) {
            quality = "good";
        } else {
            quality = "poor";
        }
        System.out.println("The water quality in the river " + river.name + " is " + quality + ".");
    }

    //check water quality
    public static boolean water_quality(int chemical, int bacteria) {
        return (chemical < 5 && bacteria < 200);
    }

    //run program
    public static void store() {
        Scanner scanner = new Scanner(System.in);
        River river1 = new_river("first", scanner);
        River river2 = new_river("second", scanner);
        River river3 = new_river("third", scanner);

        printRiverDetails(river1);
        printRiverDetails(river2);
        printRiverDetails(river3);

        scanner.close();
    }
}