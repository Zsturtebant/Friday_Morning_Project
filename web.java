import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class web{
	{
 
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    /**
     * Fetches the raw HTML from the NSOPW search page.
     *
     * @return HTML content of the page
     * @throws IOException
     * @throws InterruptedException
     */
    public String fetchSearchPage() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.nsopw.gov/search-public-sex-offender-registries"))
                .header("User-Agent", "JavaHttpClient/1.0") // polite UA
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static void main(String[] args) {
        NSOPWClient client = new NSOPWClient();
        try {
            String html = client.fetchSearchPage();
            System.out.println(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}