package display;

import java.util.Observable;
import java.util.Observer;

import displayElement.DisplayElement;
import weatherData.WeatherData2;

public class ForecastDisplay2 implements Observer, DisplayElement {
	private float currentPressure = 29.92f;
	private float lastPressure;
	
	public ForecastDisplay2(Observable observable) {
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		if(this.currentPressure == this.lastPressure){
			System.out.println("lastPressure" + lastPressure + " currentPressure"+ currentPressure);
			System.out.println("More of the same");
		} else {
			if(this.currentPressure > this.lastPressure){
				System.out.println("lastPressure" + lastPressure + " currentPressure"+ currentPressure);
				System.out.println("Improving weather on the way!");
			} else {
				System.out.println("lastPressure" + lastPressure + " currentPressure"+ currentPressure);
				System.out.println("Watch out for coller,rainy weather");
			}
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData2){
			WeatherData2 weatherData = (WeatherData2) o;
			lastPressure = currentPressure;
			currentPressure = (float) arg;
			display();
		}
	}
}
