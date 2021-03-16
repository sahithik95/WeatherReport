package com.example.weather.web;

import com.example.weather.integration.weather.CovidDetails;
import com.example.weather.integration.weather.CovidService;
import com.example.weather.integration.weather.Weather;
import com.example.weather.integration.weather.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

	private final WeatherService weatherService;

	@Autowired
	CovidService covidService;
	///v1/states/{state}/{date}.json
	//
	//Example: https://api.covidtracking.com/v1/states/ca/20200501.json
	//Example: https://api.covidtracking.com/v1/states/{state}/{20200501}	.json

	//JSON format
	///v1/states/{state}/daily.json
	//
	//Example: https://api.covidtracking.com/v1/states/ca/daily.json

	public WeatherApiController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	//TestURL: http:localhost:8080//api/weather/zipCode?zipCode=80130 and response will provide 5 days weather data
	@RequestMapping(value = "/zipCode", produces = "application/json")
	public Weather getWeatherByZip(@RequestParam("zipCode") Integer zipCode) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return this.weatherService.getWeather(zipCode, null);
	}

	@RequestMapping(value = "/States", produces = "application/json")
	public CovidDetails getCovidByState(@RequestParam("state") String state, @RequestParam("date") long date) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return this.covidService.getCovidDetailsByState(state, date);
	}

}

