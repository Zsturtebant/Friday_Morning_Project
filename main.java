 class main1{
 public static void main(String[] args) {
        // Program logic goes here
  Scanner input = new Scanner(System.in);
        WizardTracker tracker = new WizardTracker();

        System.out.println("===== Wizard Watch Input Center =====");

        // 
        // Get user location input
        // 
        System.out.print("Enter your current location (latitude,longitude): ");
        String userLocationInput = input.nextLine();

        System.out.println("You entered: " + userLocationInput);
        System.out.print("Is this correct? (yes/no): ");
        String confirm = input.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Please restart and enter correct location.");
            return;
        }

        // 
        //  Ask for max search distance
        // 
        System.out.print("Enter the maximum distance (in miles): ");
        double maxDistance = input.nextDouble();

        System.out.println("\nSearching within " + maxDistance + " miles...");

        // 
        // 3. Call teammate code
        // 
        
        tracker.fakeSearch();

        // 
        // 4. Display results
        // 
        System.out.println("\n===== Dark Wizard Activity =====");
        tracker.display();

        System.out.println("===== End of Report =====");
    }
}
  
  
    }
}
