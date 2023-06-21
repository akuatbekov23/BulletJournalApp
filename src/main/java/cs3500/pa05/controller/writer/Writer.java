package cs3500.pa05.controller.writer;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;

public interface Writer {
  void write(File file, JsonNode jsonNode);
}
