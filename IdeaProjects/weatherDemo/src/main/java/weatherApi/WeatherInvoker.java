package weatherApi;

import com.google.gson.Gson;
import weatherObject.Forecast;
import weatherObject.JsonResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class WeatherInvoker {
    private String location = "mendoza";

    public void testInvoke(){
        try {
            String urlBase = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20";
            String urlCondition = "(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + location + "%22)";
            String urlFormat =  "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
            String urlFull = urlBase + urlCondition + urlFormat;
            String html = getHTML(urlFull);
            JsonResponse object = getObject(html);

            System.out.println("Location: " + object.query.results.getChannel().getLocation().toString());
            for (final Forecast forecast : object.query.results.getChannel().getItem().getForecast()) {
                System.out.println(forecast.toStringWithUnit(object.query.results.getChannel().getUnits().getTemperature()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCityWeather(String city){
        try {
            String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20"+
                            "(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + city + "%22)" +
                            "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
            String html = getHTML(url);
            JsonResponse object = getObject(html);

            System.out.println("Location: " + object.query.results.getChannel().getLocation().toString());
            for (final Forecast forecast : object.query.results.getChannel().getItem().getForecast()) {
                System.out.println(forecast.toStringWithUnit(object.query.results.getChannel().getUnits().getTemperature()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        InputStream inputStream = conn.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    private static JsonResponse getObject(String jsonString) throws Exception {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, JsonResponse.class);
    }
}
