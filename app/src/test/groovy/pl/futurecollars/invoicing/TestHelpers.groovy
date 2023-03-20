package pl.futurecollars.invoicing

import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.InvoiceEntry
import pl.futurecollars.invoicing.model.Vat

class TestHelpers {

    static void company(int id) {
        new Company(("$id").repeat(10),
                "ul. Bukowińska 24d/$id 02-703 Warszawa, Polska",
                "iCode Trust $id Sp. z o.o");
    }

    static void product(int id) {
        new InvoiceEntry("Programming course $id", BigDecimal.valueOf(id * 1000), BigDecimal.valueOf(id * 1000 * 0.08), Vat.VAT_8);
    }

}
