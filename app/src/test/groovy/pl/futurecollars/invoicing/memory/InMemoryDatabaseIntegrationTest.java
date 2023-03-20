package pl.futurecollars.invoicing.memory;

import pl.futurecollars.invoicing.db.AbstractDatabaseTest;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.InMemoryDatabaseTest;

class InMemoryDatabaseIntegrationTest extends InMemoryDatabaseTest.AbstractDatabaseTest {

  @Override
  Database getDatabaseInstance() {
    return new InMemoryDatabase();
  }
}
