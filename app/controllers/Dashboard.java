package controllers;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

import java.util.List;

import static utils.StationAnalytics.*;

public class Dashboard extends Controller
{
  private static String name;

  public static void index() {
    Logger.info("Rendering Dasboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    for (Station station : stations) {
      List<Reading> readings = station.readings;
      if (readings.size() > 0) {
        Reading latestReading = readings.get(readings.size() - 1);
        station.latestTemperatureC = StationAnalytics.getLatestTemperatureC(station.readings);
        station.latestTemperatureF = StationAnalytics.getLatestTemperatureF(station.readings);
        station.latestPressure = StationAnalytics.getLatestPressure(station.readings);
        station.latestWindSpeed = StationAnalytics.getLatestWindSpeed(station.readings);
        station.weatherCode = StationAnalytics.getWeatherCode(station.readings);
      }
    }
    render("dashboard.html", stations);
  }

  public static void deleteStation(Long id)
  {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }

  public static void addStation (String name)
  {
    Logger.info("Adding a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = new Station (name, 0, 0);
    member.stations.add(station);
    member.save();
    redirect ("/dashboard");
  }
}