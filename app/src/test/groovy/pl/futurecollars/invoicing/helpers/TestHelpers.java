package pl.futurecollars.invoicing.helpers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;
import pl.futurecollars.invoicing.model.Vat;

  public class TestHelpers {

  void product(int id) {
    new InvoiceEntry("Programming course $id", BigDecimal.valueOf(id * 1000), BigDecimal.valueOf(id * 1000 * 0.08), Vat.VAT_8);
    new InvoiceEntry("Programming course $id", 1, BigDecimal.valueOf(id * 1000), BigDecimal.valueOf(id * 1000 * 0.08), Vat.VAT_8);
  }

  public void invoice(int id) {
    Invoice invoice = new Invoice(LocalDate.now(), company(id), company(id), List.of());
  }

    private Company company(int id) {
      return null;
    }
  }
