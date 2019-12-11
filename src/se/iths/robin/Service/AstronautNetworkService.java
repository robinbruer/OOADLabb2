package se.iths.robin.Service;

import com.google.gson.Gson;
import se.iths.robin.Model.Astronaut;
import se.iths.robin.Model.IAstronaut;
import se.iths.robin.Repository.AstronautDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AstronautNetworkService implements AstronautDataSource {
    private static String mURL = "http://api.open-notify.org/astros.json";
    private static HttpURLConnection connection;
    private IAstronaut astronaut;

    private void fetchAstronauts() {
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL(mURL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            if(responseCode >= 200 && responseCode < 299){
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();

                Gson gson = new Gson();
                astronaut = gson.fromJson(responseContent.toString(), Astronaut.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }

    @Override
    public IAstronaut getAstronauts() {
        fetchAstronauts();
        return astronaut;
    }
}
