import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    public void registerObserver(Observer o) {
        int i = observers.indexOf(o);
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(i);
        }
    }

    // 向觀察者們送以改動的資料
    // 可以看到現在我們是直接註冊Observer介面，如此一來觀察者類別的實作就不用去在意
    // 只要知道要註冊的對象必須要有實作Observer介面就好
    public void notifyObservers() {
        for(int i=0; i<observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    // 執行向觀察者們通知資料
    public void measurementsChanged() {
        notifyObservers();
    }

    // 讀取假資料，可以改動這地方，改為向氣象局網站爬資料
    public void setMeasurements(
            float temperature,
            float humidity,
            float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
