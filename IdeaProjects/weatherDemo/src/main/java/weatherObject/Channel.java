package weatherObject;


public class Channel {
    private Units units;
    private String title;
    private String link;
    private String description;
    private String language;
    private String lastBuildDate;
    private Integer ttl;
    private Location location;
    private Wind wind;
    private Atmosphere atmosphere;
    private Astronomy astronomy;
    private Item item;

    public Item getItem() {
        return item;
    }

    public Units getUnits() {
        return units;
    }

    public Location getLocation() {
        return location;
    }
}
