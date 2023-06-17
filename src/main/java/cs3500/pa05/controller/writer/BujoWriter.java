package cs3500.pa05.controller.writer;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BujoWriter implements Writer {
  @Override
  public void write(File file, JsonNode jsonNode) {
    Path path = Path.of(file.toPath() + ".bujo");
    byte[] data = jsonNode.toString().getBytes();
    try {
      Files.write(path, data);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
