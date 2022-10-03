package io.github.usbharu.jma4j.model.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class Forecast {

  String publishingOffice;
  OffsetDateTime reportDatetime;


  public static class TimeSeries {

    List<OffsetDateTime> timeDefines;
    List<Area> areas;

    public static class Area {

      WeatherByArea area;
      List<String> weatherCodes;
      List<String> pops;
      List<String> reliabilities;

    }
  }

  public static class TempAverage {

    List<TempByArea> areas;


  }
  public static class PrecipAverage {

    List<TempByArea> areas;

  }
  public static class TempByArea {

    WeatherByArea area;
    String min;
    String max;
  }

  public static class WeatherByArea {

    String name;
    String code;

  }

}
