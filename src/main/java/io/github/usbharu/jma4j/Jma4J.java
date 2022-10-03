package io.github.usbharu.jma4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.usbharu.jma4j.model.dto.Area;
import io.github.usbharu.jma4j.model.entity.AbstractArea;
import java.io.IOException;
import java.net.URL;

public class Jma4J {

  private static final Jma4J singleton = new Jma4J();
  private Jma4JService jma4JService;

  private Jma4J() {
  }

  public static Jma4J getInstance() {
    return singleton;
  }

  public AbstractArea searchArea(String name) throws IOException {
    Area areas =
        new ObjectMapper().readValue(new URL("https://www.jma.go.jp/bosai/common/const/area.json"),
            Area.class);
    this.jma4JService = new Jma4JService();

    io.github.usbharu.jma4j.model.entity.Area area = jma4JService.toEntity(areas);
    return jma4JService.searchArea(name, area);
  }
}
