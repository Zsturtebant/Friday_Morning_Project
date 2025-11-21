import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class web  {

    // -----------------------------
    // Embedded JSON data structures
    // -----------------------------
    static class OffenderResponse {
        Offender[] offenders;
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
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    // -----------------------------
    // API Search Method
    // -----------------------------
    public OffenderResponse search(String firstName, String zipcode, String apiKey)
            throws IOException, InterruptedException {

        String url = String.format(
                "https://api.offenders.io/sexoffender?firstName=%s&zipcode=%s&key=%s",
                firstName, zipcode, apiKey
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), OffenderResponse.class);
    }

    // -----------------------------
    // Main Method (Safe Output)
    // -----------------------------
    public static void main(String[] args) {
        web client = new web();

        try {
            // Example search — replace API key
            OffenderResponse result =
                    client.search("First", "12345", "YOUR_API_KEY_HERE");

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
            e.printStackTrace();
        }
    }
}