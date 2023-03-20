package pl.futurecollars.invoicing.service;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class FileService {

  private ObjectMapper objectMapper;

  public FileService() {
    this.objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule() {
      @Override
      public String getModuleName() {
        return null;
      }

      @Override
      public Version version() {
        return null;
      }

      @Override
      public void setupModule(SetupContext context) {

      }
    });
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  public void writeDataToFile(String filename, Object object) {
    try {
      objectMapper.writeValue(new File(filename), object);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Object getDataFromFiles(String filename, Class t) {
    try {
      return objectMapper.readValue(new File(filename), t);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private abstract class JavaTimeModule extends Module {
  }
}
