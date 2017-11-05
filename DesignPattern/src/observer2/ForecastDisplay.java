package observer2;

import java.util.List;

public class ForecastDisplay extends DisplayElement implements Observer {

    private WeatherData weatherData;

    private List<Float> forecastTemperatures;//未来几天的温度

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("未来几天的气温");
        int count = forecastTemperatures.size();
        for (int i = 0; i < count; i++) {
            System.out.println("第" + i + "天:" + forecastTemperatures.get(i) + "℃");
        }
    }

    @Override
    public void update() {
        this.forecastTemperatures = this.weatherData.getForecastTemperatures();
        display();
    }
}
