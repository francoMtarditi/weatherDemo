import org.junit.Test;
import weatherApi.WeatherInvoker;

public class WeatherTester {
    private WeatherInvoker weather = new WeatherInvoker();

    @Test public void test1(){
        weather.getCityWeather("buenosaires");
    }
}
