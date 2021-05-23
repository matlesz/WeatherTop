package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

import static utils.StationAnalytics.*;

public class Dashboard extends Controller
{
  private static String name;

  public static void index()
  {
    Logger.info("Rendering Dasboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    //member.stations.latestTemperatureC = getLatestTemperatureC(member.stations.readings);
    render ("dashboard.html", stations);
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