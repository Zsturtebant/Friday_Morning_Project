 class main1{
 public static void main(String[] args) {
        // Program logic goes here
  Scanner input = new Scanner(System.in);

  System.out.println("===== Wizard Watch Input Center =====");

  // asking the user for their location
  System.out.println("Enter your current location (latitude,longitude): ");
  String userLocationInput = input.nectLine();

 System.out.println("You entered: " + userLocationInput);
  System.out.print("Is this correct? (yes/no): ");
  String comfirm = input.nextLine();

  if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Please restart the program and enter correct location.");
            return;
        }

  // ask user how far to search
 System.out.print("Enter the maximum distance (in miles) to search for offenders: ");
        double maxDistance = input.nextDouble();

  System.out.println("\nSearching within " + maxDistance + " miles...");

  // calls that will be implemented by  teammates ---
  // Oneal will handle  storing user location

  
  
    }
}
