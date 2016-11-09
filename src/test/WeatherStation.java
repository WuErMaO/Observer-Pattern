package test;

import display.CurrentConditionDisplay;
import weatherData.impl.WeatherData;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData= new WeatherData();
		CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
		
		weatherData.setMeasurements(60, 70, 30.4f);
		weatherData.setMeasurements(45, 30, 40.4f);
		
		weatherData.removeObserver(currentDisplay);
		weatherData.registerObserver(currentDisplay);
		
		weatherData.setMeasurements(60, 70, 30.4f);
	}
}
