package io.github.usbharu.jma4j.model.entity;

import java.util.List;
import java.util.Map;

public class Area {

  private final Map<String, Center> centers;

  public Area(Map<String, Center> centers) {
    this.centers = centers;
  }

  public Map<String, Center> getCenters() {
    return centers;
  }

  public static class Center extends AbstractArea
      implements HaveChildren, io.github.usbharu.jma4j.model.entity.Office {

    private final List<Office> children;

    private final String officeName;

    public Center(String name, String enName, List<Office> children, String officeName) {
      super(name, enName);
      this.children = children;
      this.officeName = officeName;
    }

    @Override
    public List<Office> getChildren() {
      return children;
    }

    @Override
    public String getOfficeName() {
      return officeName;
    }
  }

  public static class Office extends AbstractArea
      implements HaveChildren, HaveParent, io.github.usbharu.jma4j.model.entity.Office {
    private final List<Class10> children;
    private final Center parent;
    private final String officeName;

    public Office(String name, String enName, List<Class10> children, Center parent,
        String officeName) {
      super(name, enName);
      this.children = children;
      this.parent = parent;
      this.officeName = officeName;
    }

    @Override
    public List<Class10> getChildren() {
      return children;
    }

    @Override
    public AbstractArea getParent() {
      return parent;
    }

    @Override
    public String getOfficeName() {
      return officeName;
    }
  }

  public static class Class10 extends AbstractArea implements HaveParent,HaveChildren{
    private final List<Class15> children;
    private final Office parent;

    public Class10(String name, String enName, List<Class15> children, Office parent) {
      super(name, enName);
      this.children = children;
      this.parent = parent;
    }

    @Override
    public List<Class15> getChildren() {
      return children;
    }

    @Override
    public Office getParent() {
      return parent;
    }
  }

  public static class Class15 extends AbstractArea implements HaveParent,HaveChildren{
    private final List<Class20> children;
    private final Class10 parent;

    public Class15(String name, String enName, List<Class20> children, Class10 parent) {
      super(name, enName);
      this.children = children;
      this.parent = parent;
    }

    @Override
    public List<Class20> getChildren() {
      return children;
    }

    @Override
    public Class10 getParent() {
      return parent;
    }
  }

  public static class Class20 extends AbstractArea implements HaveParent{
    private final Class15 parent;
    private final String kana;

    public Class20(String name, String enName, Class15 parent, String kana) {
      super(name, enName);
      this.parent = parent;
      this.kana = kana;
    }


    public String getKana() {
      return kana;
    }

    @Override
    public AbstractArea getParent() {
      return parent;
    }
  }
}
