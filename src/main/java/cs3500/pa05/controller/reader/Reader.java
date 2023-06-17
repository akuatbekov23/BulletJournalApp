package cs3500.pa05.controller.reader;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;

public interface Reader {
  JsonNode read(File file);
}
