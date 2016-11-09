package weatherData.impl;

import java.util.ArrayList;

import observer.Observer;
import weatherData.Subject;

public class WeatherData implements Subject{

	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0 ){
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humditity, float pressure){
		this.temperature = temperature;
		this.humidity = humditity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
