/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package pl.futurecollars.invoicing;

import java.time.LocalDate;
import java.util.Optional;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.FileDatabase;
import pl.futurecollars.invoicing.model.Invoice;

public class App {

  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {

    System.out.println(new App().getGreeting());

    Database database = new FileDatabase();

    Invoice invoice = Invoice.builder()
        .buyer("buyer comapny etc.")
        .seller("seller company inc.")
        .date(LocalDate.now())
        .build();

    database.save(invoice);

    Optional<Invoice> invoiceFromDb = database.getById(123);

    System.out.println(invoiceFromDb);

  }

}
