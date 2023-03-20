package pl.futurecollars.invoicing.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pl.futurecollars.invoicing.model.Invoice;

public class InMemoryDatabase implements Database {

  private final Map<Integer, Invoice> invoices = new HashMap<>();
  private int nextId = 1;

  @Override
  public String save(Invoice invoice) {
    invoice.setId(String.valueOf(nextId));
    invoices.put(nextId, invoice);

    return nextId++;
  }

  @Override
  public Optional<Invoice> getById(int id) {
    return Optional.ofNullable(invoices.get(id));
  }

  @Override
  public List<Invoice> getAll() {
    return new ArrayList<>(invoices.values());
  }

  @Override
  public void update(int id, Invoice updatedInvoice) {
    if (!invoices.containsKey(id)) {
      throw new IllegalArgumentException("Id " + id + " does not exist");
    }

    updatedInvoice.setId(String.valueOf(id));
    invoices.put(id, updatedInvoice);
  }

  @Override
  public void delete(int id) {
    invoices.remove(id);
  }
}
