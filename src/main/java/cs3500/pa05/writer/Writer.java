package cs3500.pa05.writer;

import com.fasterxml.jackson.databind.JsonNode;

public interface Writer {
  void write(JsonNode jsonNode);
}
