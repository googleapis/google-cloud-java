/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.connection.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDelayBeginTransactionTest extends ITAbstractSpannerTest {
  @Override
  public void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=false;delayTransactionStartUntilFirstWrite=true");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Before
  public void setupTestData() {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(Mutation.delete("TEST", KeySet.all()));
      connection.commit();

      connection.bufferedWrite(
          ImmutableList.of(
              Mutation.newInsertBuilder("TEST").set("id").to(1L).set("name").to("One").build(),
              Mutation.newInsertBuilder("TEST").set("id").to(2L).set("name").to("Two").build()));
      connection.commit();
    }
  }

  @Test
  public void testReadExistingData() {
    try (ITConnection connection = createConnection()) {
      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select * from test order by id"))) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong("ID"));
        assertEquals("One", resultSet.getString("NAME"));

        assertTrue(resultSet.next());
        assertEquals(2L, resultSet.getLong("ID"));
        assertEquals("Two", resultSet.getString("NAME"));

        assertFalse(resultSet.next());
      }
      // This is effectively a no-op when using delayed-begin-transaction and the transaction has
      // only executed queries.
      connection.commit();
    }
  }

  @Test
  public void testReadThenWrite() {
    try (ITConnection connection = createConnection()) {
      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select * from test order by id"))) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong("ID"));
        assertEquals("One", resultSet.getString("NAME"));

        assertTrue(resultSet.next());
        assertEquals(2L, resultSet.getLong("ID"));
        assertEquals("Two", resultSet.getString("NAME"));

        assertFalse(resultSet.next());
      }
      connection.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(3L)
              .bind("name")
              .to("Three")
              .build());

      connection.commit();

      // Verify that the new row was inserted.
      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select count(*) from test"))) {
        assertTrue(resultSet.next());
        assertEquals(3L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testWriteThenRead() {
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(3L)
              .bind("name")
              .to("Three")
              .build());

      // Verify that we can read both existing data and the row that we just inserted.
      try (ResultSet resultSet =
          connection.executeQuery(
              Statement.of("select * from test where id in (2,3) order by id"))) {
        assertTrue(resultSet.next());
        assertEquals(2L, resultSet.getLong("ID"));
        assertEquals("Two", resultSet.getString("NAME"));

        assertTrue(resultSet.next());
        assertEquals(3L, resultSet.getLong("ID"));
        assertEquals("Three", resultSet.getString("NAME"));

        assertFalse(resultSet.next());
      }

      connection.commit();

      // Verify that the new row was inserted.
      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select count(*) from test"))) {
        assertTrue(resultSet.next());
        assertEquals(3L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testConcurrentReadAndWrites() {
    try (ITConnection connection1 = createConnection();
        ITConnection connection2 = createConnection()) {
      // Scan all the rows in the test table using the first connection.
      int originalRowCount = 0;
      try (ResultSet resultSet =
          connection1.executeQuery(Statement.of("select * from test order by id"))) {
        while (resultSet.next()) {
          originalRowCount++;
        }
      }
      // Insert a new row using the other transaction.
      connection2.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(3L)
              .bind("name")
              .to("Three")
              .build());
      // Rescan the table using the first transaction. This should not return the new row yet, as it
      // has not been committed. It should also not cause any concurrency issues with the other
      // transaction.
      int rowCount = 0;
      try (ResultSet resultSet =
          connection1.executeQuery(Statement.of("select * from test order by id"))) {
        while (resultSet.next()) {
          rowCount++;
        }
      }
      assertEquals(originalRowCount, rowCount);
      // Commit the transaction that inserted a new row.
      connection2.commit();
      // The new row should now be visible to the first transaction.
      rowCount = 0;
      try (ResultSet resultSet =
          connection1.executeQuery(Statement.of("select * from test order by id"))) {
        while (resultSet.next()) {
          rowCount++;
        }
      }
      assertEquals(originalRowCount + 1, rowCount);
      connection1.commit();
    }
  }

  @Test
  public void testConcurrentWrites() {
    assumeFalse(
        "The emulator does not support concurrent transactions",
        EmulatorSpannerHelper.isUsingEmulator());

    try (ITConnection connection1 = createConnection();
        ITConnection connection2 = createConnection()) {
      // Scan all the rows in the test table using the first connection.
      int originalRowCount = 0;
      try (ResultSet resultSet =
          connection1.executeQuery(Statement.of("select * from test order by id"))) {
        while (resultSet.next()) {
          originalRowCount++;
        }
      }
      // Insert new rows using both transactions. These are non-conflicting and should therefore be
      // possible.
      connection2.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(3L)
              .bind("name")
              .to("Three")
              .build());
      connection1.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(4L)
              .bind("name")
              .to("Four")
              .build());
      // Commit the transaction for connection2. This should make the row it inserted visible to
      // connection1, as connection1's transaction started after connection2.
      connection2.commit();

      // Rescan the table using the first transaction. This should now return both the above new
      // rows.
      int rowCount = 0;
      try (ResultSet resultSet =
          connection1.executeQuery(Statement.of("select * from test order by id"))) {
        while (resultSet.next()) {
          rowCount++;
        }
      }
      assertEquals(originalRowCount + 2, rowCount);
      connection1.commit();
    }
  }

  @Test
  public void testConflictingTransactions() {
    assumeFalse(
        "The emulator does not support concurrent transactions",
        EmulatorSpannerHelper.isUsingEmulator());

    try (ITConnection connection1 = createConnection();
        ITConnection connection2 = createConnection()) {
      // Insert new rows using both transactions. These are non-conflicting and should therefore be
      // possible.
      connection2.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(3L)
              .bind("name")
              .to("Three")
              .build());
      connection1.executeUpdate(
          Statement.newBuilder("insert into test (id, name) values (@id, @name)")
              .bind("id")
              .to(4L)
              .bind("name")
              .to("Four")
              .build());
      // Scan all the rows in the test table using the first connection. This will now use the
      // read/write transaction and will conflict with the other transaction.
      try (ResultSet resultSet =
          connection1.executeQuery(Statement.of("select * from test order by id"))) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {
          // ignore and just consume the results
        }
      }
      // Commit the transaction for connection2.
      connection2.commit();
      // The first transaction will be aborted.
      assertThrows(AbortedDueToConcurrentModificationException.class, connection1::commit);
    }
  }
}
