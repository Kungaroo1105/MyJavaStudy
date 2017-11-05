package observer2;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        //向weatherData注册两个观察者类
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        List<Float> forecastTemperatures = new ArrayList<Float>();
        forecastTemperatures.add(22f);
        forecastTemperatures.add(-1f);
//        forecastTemperatures.add(9f);
//        forecastTemperatures.add(23f);
//        forecastTemperatures.add(27f);
//        forecastTemperatures.add(30f);
//        forecastTemperatures.add(10f);
        //改动会主动告知观察者
        weatherData.setMeasurements(22f, 0.8f, 1.2f, forecastTemperatures);
    }

}
