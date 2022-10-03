package io.github.usbharu.jma4j.model.dto;

import java.util.List;
import java.util.Map;

public class Area {

  public Map<String, Center> centers;
  public Map<String, Office> offices;
  public Map<String, Class10> class10s;
  public Map<String, Class15> class15s;
  public Map<String, Class20> class20s;

  @Override
  public String toString() {
    return "Area{" +
        "centers=" + centers +
        ", offices=" + offices +
        ", class10s=" + class10s +
        ", class15s=" + class15s +
        ", class20s=" + class20s +
        '}';
  }

  public static class Center {

    public String name;
    public String enName;
    public String officeName;
    public List<String> children;

    @Override
    public String toString() {
      return "Center{" +
          "name='" + name + '\'' +
          ", enName='" + enName + '\'' +
          ", officeName='" + officeName + '\'' +
          ", children=" + children +
          '}';
    }
  }

  public static class Office {

    public String name;
    public String enName;
    public String officeName;
    public String parent;
    public List<String> children;

    @Override
    public String toString() {
      return "Office{" +
          "name='" + name + '\'' +
          ", enName='" + enName + '\'' +
          ", officeName='" + officeName + '\'' +
          ", parent='" + parent + '\'' +
          ", children=" + children +
          '}';
    }
  }

  public static class Class10 {

    public String name;
    public String enName;
    public String parent;
    public List<String> children;

    @Override
    public String toString() {
      return "Class10{" +
          "name='" + name + '\'' +
          ", enName='" + enName + '\'' +
          ", parent='" + parent + '\'' +
          ", children=" + children +
          '}';
    }
  }

  public static class Class15 {

    public String name;
    public String enName;
    public String parent;
    public List<String> children;

    @Override
    public String toString() {
      return "Class15{" +
          "name='" + name + '\'' +
          ", enName='" + enName + '\'' +
          ", parent='" + parent + '\'' +
          ", children=" + children +
          '}';
    }
  }

  public static class Class20 {

    public String name;
    public String enName;
    public String kana;
    public String parent;

    @Override
    public String toString() {
      return "Class20{" +
          "name='" + name + '\'' +
          ", enName='" + enName + '\'' +
          ", kana='" + kana + '\'' +
          ", parent='" + parent + '\'' +
          '}';
    }
  }
}
