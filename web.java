import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Scanner;
import java.util.Random;

public class Web  { // Main Class

    // -----------------------------
    // Embedded JSON data structures
    // -----------------------------
    static class OffenderResponse {
        Offender[] offenders; // List/array of offenders
    }

    static class Offender {
        String name;
        String firstName;
        String lastName;

        @SerializedName("offenderUrl")
        String profileUrl; // Public link (safe)
    }

    // -----------------------------
    // Fields
    // -----------------------------
    private static final HttpClient client = HttpClient.newBuilder().build();
    private final Gson gson = new Gson();

    // -----------------------------
    // API Search Method
    // -----------------------------
    public OffenderResponse search(String firstName, String zipcode, String apiKey)
            throws IOException, InterruptedException {

        if (firstName == null || firstName.isEmpty()) {
            System.out.println("First name is missing.");
            return null;
        }

        if (zipcode == null || zipcode.length() != 5) {
            System.out.println("Zipcode is not valid.");
            return null;
        }

        // Build the URL by adding the name, zip code, and API Key        
       String url = "https://api.offenders.io/sexoffender"
            + "?firstName=" + firstName
            + "&zipcode=" + zipcode
            + "&key=" + apiKey;

        // Create the HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Error: " + response.statusCode());
            return null;
        }

        return gson.fromJson(response.body(), OffenderResponse.class);
    }

    // -----------------------------
    // Generate One Random Fake Offender
    // -----------------------------
    public Offender getRandomOffender(int id) {

        Random random = new Random();

        String[] firstNames = {"John", "Mark", "Chris", "Alex", "Ryan", "James", "David"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Davis", "Moore", "Taylor"};

        Offender o = new Offender();

        o.firstName = firstNames[random.nextInt(firstNames.length)];
        o.lastName = lastNames[random.nextInt(lastNames.length)];
        o.name = o.firstName + " " + o.lastName;

        //Random Fake Profile Link
        o.profileUrl = "https://example.com/profile" + id;

        return o;
    }

     // -----------------------------
    //  Fake API Simulation
    // -----------------------------
    public OffenderResponse fakeSearch() {

        // Generate 1-5 random offenders
        Random random = new Random();
        int count = random.nextInt(5) + 1;

        Offender[] fakeList = new Offender[count];

        for (int i = 0; i < count; i++) {
            fakeList[i] = getRandomOffender(i + 1);
        }

        OffenderResponse response = new OffenderResponse();
        response.offenders = fakeList;
        return response;
    }
        

    // -----------------------------
    // Main Method (Safe Output)
    // -----------------------------
    public static void main(String[] args) {
        Web app = new Web();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Use Real API");
        System.out.println("2. Use Fake API");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        OffenderResponse result = null;
        

        try {

            if (choice == 1) {
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter Zipcode: ");
                String zipcode = scanner.nextLine();

                System.out.print("Enter API key: ");
                String apiKey = scanner.nextLine();

                result = app.search(firstName, zipcode, apiKey);

            } else {
                System.out.println("Using Random Fake API");
                result = app.fakeSearch();
            }
            
            // Print results
            if (result != null && result.offenders != null) {
                System.out.println("Offenders found: " + result.offenders.length);

                for (Offender o : result.offenders) {
                    // SAFE OUTPUT ONLY
                    System.out.println("Name: " + o.name);
                    System.out.println("Public Profile: " + o.profileUrl);
                    System.out.println("----------------------");
                }
            } else {
                System.out.println("No results.");
            }

        } catch (Exception e) {
            // If something goes wrong, print the error
            e.printStackTrace();
        }
    }
}
