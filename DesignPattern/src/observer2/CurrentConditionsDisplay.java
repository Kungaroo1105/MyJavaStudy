package observer2;
public class CurrentConditionsDisplay extends DisplayElement implements Observer {

    private WeatherData weatherData;

    private float temperature;//�¶�
    private float humidity;//ʪ��
    private float pressure;//��ѹ

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

  
    public void display() {
        System.out.println("��ǰ�¶�Ϊ��" + this.temperature + "��");
        System.out.println("��ǰʪ��Ϊ��" + this.humidity);
        System.out.println("��ǰ��ѹΪ��" + this.pressure);
    }

    @Override
    public void update() {
        this.temperature = this.weatherData.getTemperature();
        this.humidity = this.weatherData.getHumidity();
        this.pressure = this.weatherData.getPressure();
        display();
    }
}
