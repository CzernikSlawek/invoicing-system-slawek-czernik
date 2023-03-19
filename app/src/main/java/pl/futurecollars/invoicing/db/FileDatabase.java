package pl.futurecollars.invoicing.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import pl.futurecollars.invoicing.configuration.Configuration;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.service.FileService;

public class FileDatabase implements Database {

  private FileService fileService;

  public FileDatabase() {
    this.fileService = new FileService();
  }

  @Override
  public int save(Invoice invoice) {
    String uuid = UUID.randomUUID().toString();
    invoice.setId(uuid);
    fileService.writeDataToFile(Configuration.DB_FILE_NAME, invoice);
    return 0;
  }

  @Override
  public Optional<Invoice> getById(int id) {
    Object invoiceObj = fileService.getDataFromFiles(Configuration.DB_FILE_NAME, Invoice.class);
    return (Optional<Invoice>) invoiceObj;
  }

  @Override
  public List<Invoice> getAll() {
    return null;
  }

  @Override
  public void update(int id, Invoice updatedInvoice) {

  }

  @Override
  public void delete(int id) {

  }
}
