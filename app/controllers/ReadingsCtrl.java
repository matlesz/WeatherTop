package controllers;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;
import java.util.List;

public class ReadingsCtrl extends Controller
{
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    station.latestTemperatureC = StationAnalytics.getLatestTemperatureC(station.readings);
    station.latestTemperatureF = StationAnalytics.getLatestTemperatureF(station.readings);
    station.latestPressure = StationAnalytics.getLatestPressure(station.readings);
    station.latestWindSpeed = StationAnalytics.getLatestWindSpeed(station.readings);
    station.weatherCode = StationAnalytics.getWeatherCode(station.readings);
    Logger.info ("Station id = " + id);
    render("station.html", station);
  }

  public static void deletereading(Long id, Long readingid)
  {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing" + reading.date);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }

  public static void addreading(Long id,String date, int code, int temperature, int windSpeed, int windDirection,  int pressure)
  {
    Reading reading = new Reading(date, code, temperature,  windSpeed,  windDirection,  pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect ("/stations/" + id);
  }

}
