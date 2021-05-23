package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
  public String date;
  public int code;
  public Double temperature;
  public int windSpeed;
  public int windDirection;
  public int pressure;
  
  public Reading(String date, int code, double temperature, int windSpeed, int windDirection,  int pressure)
  {
    this.date = date;
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;

  }

}
