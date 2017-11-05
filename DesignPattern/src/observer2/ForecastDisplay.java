package observer2;

import java.util.List;

public class ForecastDisplay extends DisplayElement implements Observer {

    private WeatherData weatherData;

    private List<Float> forecastTemperatures;//δ��������¶�

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("δ�����������");
        int count = forecastTemperatures.size();
        for (int i = 0; i < count; i++) {
            System.out.println("��" + i + "��:" + forecastTemperatures.get(i) + "��");
        }
    }

    @Override
    public void update() {
        this.forecastTemperatures = this.weatherData.getForecastTemperatures();
        display();
    }
}
