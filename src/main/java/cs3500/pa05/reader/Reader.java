package cs3500.pa05.reader;

import com.fasterxml.jackson.databind.JsonNode;

public interface Reader {
  JsonNode read();
}
