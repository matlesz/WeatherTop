package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public int latitude;
  public int longitude;

  public Station(String name, int latitude, int longitude)
  {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}