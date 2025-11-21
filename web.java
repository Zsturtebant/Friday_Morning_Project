import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class web{
 

    /**
     * Sends an HTTP GET request to the given URL and returns the response body as a string.
     *
     * @param urlString the URL to fetch
     * @return the response body
     * @throws IOException if the request fails
     */
    public String get(String urlString) throws IOException {
        URL url = new URL("https://www.nsopw.gov/search-public-sex-offender-registries");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Configure the request
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        BufferedReader reader;

        // Choose input stream depending on response code
        if (status >= 200 && status < 300) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        // Read response
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line).append("\n");
        }

        reader.close();
        connection.disconnect();
        return response.toString();
    }

    public static void main(String[] args) {
        WebClient client = new WebClient();
        try {
            String data = client.get("https://api.github.com");
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}