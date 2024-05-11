import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversion {
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("target_code")
    private String targetCode;
    private double amount;
    private double result;

    public Conversion(String baseCode, String targetCode, double amount) {
        if (baseCode == null || baseCode.isEmpty() || targetCode == null || targetCode.isEmpty() || amount <= 0) {
            throw new IllegalArgumentException("Los parámetros deben ser válidos");
        }
        this.baseCode = baseCode.toUpperCase();
        this.targetCode = targetCode.toUpperCase();
        this.amount = amount;
    }

    public double convert() throws IOException, InterruptedException {
        String apiKey = "a6a14c7db58193e60b5fd234";
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCode;

        JsonObject jsonObject = sendRequest(urlStr);
        if (jsonObject != null) {
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double conversionRate = conversionRates.get(targetCode).getAsDouble();
            result = amount * conversionRate;
            return result;
        } else {
            throw new IOException("Error al realizar la solicitud al Servidor");
        }
    }

    private JsonObject sendRequest(String urlStr) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return new Gson().fromJson(response.body(), JsonObject.class);
        } else {
            System.out.println("Código de error: " + response.statusCode());
            return null;
        }
    }
}
