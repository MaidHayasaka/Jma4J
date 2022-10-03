package io.github.usbharu.jma4j;

import static org.junit.jupiter.api.Assertions.*;

import io.github.usbharu.jma4j.model.entity.AbstractArea;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Jma4JTest {

  @Test
  void test() throws IOException {
    Jma4J instance = Jma4J.getInstance();
    AbstractArea area = instance.searchArea("大津");
    System.out.println("area = " + area);
  }
}
