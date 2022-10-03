package io.github.usbharu.jma4j.model.entity;

import io.github.usbharu.jma4j.model.dto.Area.Class10;
import java.util.List;

public interface HaveChildren {
  public List<? extends AbstractArea> getChildren();
}
