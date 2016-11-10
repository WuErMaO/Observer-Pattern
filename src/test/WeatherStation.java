package test;

import display.CurrentConditionDisplay;
import display.CurrentConditionDisplay2;
import display.ForecastDisplay2;
import weatherData.WeatherData2;
import weatherData.impl.WeatherData;

public class WeatherStation {
	public static void main(String[] args) {
		
		System.out.println("<<<====WeatherData:====>>>");
		WeatherData weatherData= new WeatherData();
		CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(60, 70, 30.4f);
		weatherData.setMeasurements(45, 30, 40.4f);
		weatherData.removeObserver(currentDisplay);
		weatherData.registerObserver(currentDisplay);
		weatherData.setMeasurements(60, 70, 30.4f);
		
		System.out.println("<<<====WeatherData2:====>>>");
		WeatherData2 weatherData2 = new WeatherData2();
		ForecastDisplay2 forecastDisplay2 = new ForecastDisplay2(weatherData2);
		CurrentConditionDisplay2 currentDisplay2 = new CurrentConditionDisplay2(weatherData2);
		weatherData2.setMeasurements(60, 70, 30.4f);
		weatherData2.setMeasurements(45, 30, 40.4f);
		weatherData2.setMeasurements(60, 70, 30.4f);
		
	}
}
