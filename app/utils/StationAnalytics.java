package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import models.Reading;
import play.mvc.Controller;



public class StationAnalytics extends Controller {
  public static Double getLatestTemperatureC(List<Reading> readings) {
    Double latestTemperatureC = null;
    if (readings.size() > 0) {
      latestTemperatureC = readings.get(readings.size() - 1).temperature;
    }
    return latestTemperatureC;
  }

  public static Double getLatestTemperatureF(List<Reading> readings) {
    Double latestTemperatureF = null;
    if (readings.size() > 0) {
      latestTemperatureF = ((readings.get(readings.size() - 1).temperature) * 9 / 5 + 32);
    }
    return latestTemperatureF;
  }

  public static Integer getLatestPressure(List<Reading> readings) {
    Integer latestPressure = null;
    if (readings.size() > 0) {
      latestPressure = readings.get(readings.size() - 1).pressure;//readings - 1, last reading
    }
    return latestPressure;
  }

  public static Integer getLatestWindSpeed(List<Reading> readings) {
    Integer latestWindSpeed = null;
    if (readings.size() > 0) {
      latestWindSpeed = readings.get(readings.size() - 1).windSpeed;
    }
    return latestWindSpeed;
  }

  public static String getWeatherCode(List<Reading> readings) {
    String weatherCode = null;
    if (readings.size() > 0)
      if (readings.get(readings.size() - 1).code == 100) {
        return "Clear";
      } else if (readings.get(readings.size() - 1).code == 200) {
        return "Partial Clouds";
      } else if (readings.get(readings.size() - 1).code == 300) {
        return "Cloudy";
      } else if (readings.get(readings.size() - 1).code == 400) {
        return "Light Showers";
      } else if (readings.get(readings.size() - 1).code == 500) {
        return "Heavy Showers";
      } else if (readings.get(readings.size() - 1).code == 600) {
        return "Rain";
      } else if (readings.get(readings.size() - 1).code == 700) {
        return "Snow";
      } else {
        return "Thunder";
      }
    return weatherCode;
  }
}




