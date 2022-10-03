package io.github.usbharu.jma4j.model.entity;

public abstract class AbstractArea {

  private final String name;
  private final String enName;

  public AbstractArea(String name, String enName) {
    this.name = name;
    this.enName = enName;
  }

  public String getName() {
    return name;
  }

  public String getEnName() {
    return enName;
  }

  @Override
  public String toString() {
    return "AbstractArea{" +
        "name='" + name + '\'' +
        ", enName='" + enName + '\'' +
        '}';
  }
}
