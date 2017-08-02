package weatherObject;

public class Forecast {
    private Integer code;
    private String date;
    private String day;
    private Integer high;
    private Integer low;
    private String text;

    public String toString(){
        return "The [" + day + "](" + date + ")is going to be " + text + " with a temp between " + low + " - " + high;
    }

    public String toStringWithUnit(String unit){
        return "The [" + day + "](" + date + ")is going to be " + text + " with a temp between " + low + unit + " - " + high + unit;
    }
}
