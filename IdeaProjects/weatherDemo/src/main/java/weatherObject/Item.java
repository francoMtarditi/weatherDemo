package weatherObject;

public class Item {
    private String title;
    //TODO public String lat;
    //TODO public String long;
    private String link;
    private String pubDate;
    private Condition condition;
    private Forecast[] forecast;
    private String description;

    public Forecast[] getForecast() {
        return forecast;
    }
}
