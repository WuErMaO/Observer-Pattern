package display;

import java.util.Observable;
import java.util.Observer;

import displayElement.DisplayElement;
import weatherData.WeatherData2;

public class CurrentConditionDisplay2 implements Observer, DisplayElement {

	Observable observable;
	private float temperature;
	private float humifity;
	private float pressure;
	
	public CurrentConditionDisplay2(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature +"F degrees and " + humifity + "% humifity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData2){
			WeatherData2 weatherData = (WeatherData2) o;
			this.temperature = weatherData.getTemperature();
			this.humifity = weatherData.getHumidity();
			display();
		}
	}

}
