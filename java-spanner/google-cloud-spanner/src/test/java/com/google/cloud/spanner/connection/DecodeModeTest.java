/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.DecodeMode;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DecodeModeTest extends AbstractMockServerTest {

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testAllDecodeModes() throws Exception {
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    String sql = "select * from random";
    Statement statement = Statement.of(sql);
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(statement, generator.generate()));

    try (Connection connection = createConnection()) {
      for (boolean multiThreaded : new boolean[] {true, false}) {
        for (boolean readonly : new boolean[] {true, false}) {
          for (boolean autocommit : new boolean[] {true, false}) {
            connection.setReadOnly(readonly);
            connection.setAutocommit(autocommit);

            int receivedRows = 0;
            // DecodeMode#DIRECT is not supported in read/write transactions, as the protobuf value
            // is
            // used for checksum calculation.
            try (ResultSet direct =
                    connection.executeQuery(
                        statement,
                        !readonly && !autocommit
                            ? Options.decodeMode(DecodeMode.LAZY_PER_ROW)
                            : Options.decodeMode(DecodeMode.DIRECT));
                ResultSet lazyPerRow =
                    connection.executeQuery(
                        statement, Options.decodeMode(DecodeMode.LAZY_PER_ROW));
                ResultSet lazyPerCol =
                    connection.executeQuery(
                        statement, Options.decodeMode(DecodeMode.LAZY_PER_COL))) {
              while (direct.next() && lazyPerRow.next() && lazyPerCol.next()) {
                assertEquals(direct.getColumnCount(), lazyPerRow.getColumnCount());
                assertEquals(direct.getColumnCount(), lazyPerCol.getColumnCount());
                if (multiThreaded) {
                  ExecutorService service = Executors.newFixedThreadPool(direct.getColumnCount());
                  List<Future<?>> futures = new ArrayList<>(direct.getColumnCount());
                  for (int col = 0; col < direct.getColumnCount(); col++) {
                    final int colNumber = col;
                    futures.add(
                        service.submit(
                            () -> checkRowValues(colNumber, direct, lazyPerRow, lazyPerCol)));
                  }
                  service.shutdown();
                  for (Future<?> future : futures) {
                    future.get();
                  }
                } else {
                  for (int col = 0; col < direct.getColumnCount(); col++) {
                    checkRowValues(col, direct, lazyPerRow, lazyPerCol);
                  }
                }
                receivedRows++;
              }
              assertEquals(numRows, receivedRows);
            }
            if (!autocommit) {
              connection.commit();
            }
          }
        }
      }
    }
  }

  private void checkRowValues(
      int col, ResultSet direct, ResultSet lazyPerRow, ResultSet lazyPerCol) {
    // Randomly decode and get a column to trigger parallel decoding of one column.
    lazyPerCol.getValue(ThreadLocalRandom.current().nextInt(lazyPerCol.getColumnCount()));

    // Test getting the entire row as a struct both as the first thing we do, and as the
    // last thing we do. This ensures that the method works as expected both when a row
    // is lazily decoded by this method, and when it has already been decoded by another
    // method.
    if (col % 2 == 0) {
      assertEquals(direct.getCurrentRowAsStruct(), lazyPerRow.getCurrentRowAsStruct());
      assertEquals(direct.getCurrentRowAsStruct(), lazyPerCol.getCurrentRowAsStruct());
    }
    assertEquals(direct.isNull(col), lazyPerRow.isNull(col));
    assertEquals(direct.isNull(col), lazyPerCol.isNull(col));
    assertEquals(direct.getValue(col), lazyPerRow.getValue(col));
    assertEquals(direct.getValue(col), lazyPerCol.getValue(col));
    if (col % 2 == 1) {
      assertEquals(direct.getCurrentRowAsStruct(), lazyPerRow.getCurrentRowAsStruct());
      assertEquals(direct.getCurrentRowAsStruct(), lazyPerCol.getCurrentRowAsStruct());
    }
  }

  @Test
  public void testDecodeModeDirect_failsInReadWriteTransaction() {
    int numRows = 1;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    String sql = "select * from random";
    Statement statement = Statement.of(sql);
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(statement, generator.generate()));

    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      try (ResultSet resultSet =
          connection.executeQuery(statement, Options.decodeMode(DecodeMode.DIRECT))) {
        SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
        assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        assertTrue(
            exception.getMessage(),
            exception
                .getMessage()
                .contains(
                    "Executing queries with DecodeMode#DIRECT is not supported in read/write"
                        + " transactions."));
      }
    }
  }
}
