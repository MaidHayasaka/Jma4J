package io.github.usbharu.jma4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.usbharu.jma4j.model.entity.AbstractArea;
import io.github.usbharu.jma4j.model.entity.Area;
import io.github.usbharu.jma4j.model.entity.Area.Center;
import io.github.usbharu.jma4j.model.entity.Area.Class10;
import io.github.usbharu.jma4j.model.entity.Area.Class15;
import io.github.usbharu.jma4j.model.entity.Area.Class20;
import io.github.usbharu.jma4j.model.entity.Area.Office;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jma4JService {

  private final io.github.usbharu.jma4j.model.dto.Area area;

  public Jma4JService() throws IOException {
    area = new ObjectMapper().readValue(new URL("https://www.jma.go.jp/bosai/common/const/area.json"), io.github.usbharu.jma4j.model.dto.Area.class);
  }

  public Area toEntity(io.github.usbharu.jma4j.model.dto.Area area) {
    Map<String, Center> centers = new HashMap<>();
    Area entity = new Area(centers);
    for (String key : area.centers.keySet()) {
      io.github.usbharu.jma4j.model.dto.Area.Center center = area.centers.get(key);
      List<Office> offices = new ArrayList<>();
      Center centerEntity = new Center(center.name, center.enName, offices, center.officeName);
      for (String officesKey : center.children) {
        io.github.usbharu.jma4j.model.dto.Area.Office office = area.offices.get(officesKey);
        List<Class10> class10s = new ArrayList<>();
        Office officeEntity =
            new Office(office.name, office.enName, class10s, centerEntity, office.officeName);
        for (String class10sKey : office.children) {
          io.github.usbharu.jma4j.model.dto.Area.Class10 class10 = area.class10s.get(class10sKey);
          List<Class15> class15s = new ArrayList<>();
          Class10 class10Entity = new Class10(class10.name, class10.enName, class15s, officeEntity);
          for (String class15Key : class10.children) {
            io.github.usbharu.jma4j.model.dto.Area.Class15 class15 = area.class15s.get(class15Key);
            List<Class20> class20s = new ArrayList<>();
            Class15 class15Entity =
                new Class15(class15.name, class15.enName, class20s, class10Entity);
            for (String class20sKey : class15.children) {
              io.github.usbharu.jma4j.model.dto.Area.Class20 class20 =
                  area.class20s.get(class20sKey);
              class20s.add(new Class20(class20.name, class20.enName, class15Entity, class20.kana));
            }
            class15s.add(class15Entity);
          }
          class10s.add(class10Entity);
        }
        offices.add(officeEntity);
      }
      centers.put(key, centerEntity);
    }
    return entity;
  }

  public AbstractArea searchArea(String name,Area area){
    for (String centerKey : area.getCenters().keySet()) {
      Center center = area.getCenters().get(centerKey);
      if (center.getName().contains(name)) {
        return center;
      }
      for (Office office : center.getChildren()) {
        if (office.getName().contains(name)) {
          return office;
        }
        for (Class10 class10 : office.getChildren()) {
          if (class10.getName().contains(name)) {
            return class10;
          }
          for (Class15 class15 : class10.getChildren()) {
            if (class15.getName().contains(name)) {
              return class15;
            }
            for (Class20 class20 : class15.getChildren()) {
              if (class20.getName().contains(name)) {
                return class20;
              }
            }
          }
        }
      }
    }
    return null;
  }

  public WeatherCode getWeather(AbstractArea area){
    if (area instanceof Center) {

    }else if (area instanceof Office){

    }else if (area instanceof Class10){

    }else if (area instanceof Class15){

    }else if (area instanceof Class20){

    }else {
      throw new IllegalStateException("Unknown Area Unit :"+area);
    }
  }
}
