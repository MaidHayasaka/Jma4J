package io.github.usbharu.jma4j;
public  enum WeatherGroup {
  CLEAR(100),
  CLOUDY(200),
  RAIN(300),
  SNOW(400),
  ;
  final int group;

  WeatherGroup(int group) {
    this.group = group;
  }
}
