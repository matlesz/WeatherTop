package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import utils.StationAnalytics;

@Entity
public class Station extends Model
{
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public float latitude;
  public float longitude;

  public double latestTemperatureC;
  public double latestTemperatureF;
  public Integer latestPressure;
  public Integer latestWindSpeed;
  public String weatherCode;


  public Station(String name, float latitude, float longitude)
  {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}