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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ForwardingResultSet;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSetsHelper;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MergedResultSetTest {

  private static final class MockedResults {
    final Connection connection;
    final List<String> partitions;
    final List<Struct> allRows;
    final int minErrorIndex;

    MockedResults(
        Connection connection, List<String> partitions, List<Struct> allRows, int minErrorIndex) {
      this.connection = connection;
      this.partitions = partitions;
      this.allRows = allRows;
      this.minErrorIndex = minErrorIndex;
    }
  }

  private static final class ResultSetWithError extends ForwardingResultSet {
    private final int errorIndex;
    private int currentIndex = 0;

    ResultSetWithError(ResultSet delegate, int errorIndex) {
      super(delegate);
      this.errorIndex = errorIndex;
    }

    @Override
    public boolean next() {
      if (currentIndex == errorIndex) {
        throw SpannerExceptionFactory.newSpannerException(ErrorCode.INTERNAL, "test error");
      }
      currentIndex++;
      return super.next();
    }
  }

  @Parameter(0)
  public int numPartitions;

  @Parameter(1)
  public int maxRowsPerPartition;

  @Parameter(2)
  public int maxParallelism;

  @Parameters(name = "numPartitions = {0}, maxRowsPerPartition = {1}, maxParallelism = {2}")
  public static Collection<Object[]> parameters() {
    List<Object[]> params = new ArrayList<>();
    for (int numPartitions : new int[] {0, 1, 2, 5, 8}) {
      for (int maxRowsPerPartition : new int[] {0, 1, 5, 10, 100}) {
        for (int maxParallelism : new int[] {0, 1, 2, 4, 8}) {
          params.add(new Object[] {numPartitions, maxRowsPerPartition, maxParallelism});
        }
      }
    }
    return params;
  }

  private MockedResults setupResults(boolean withErrors, boolean withEmptyResults) {
    Random random = new Random();
    Connection connection = mock(Connection.class);
    List<String> partitions = new ArrayList<>();
    List<Struct> allRows = new ArrayList<>();
    int minErrorIndex = Integer.MAX_VALUE;
    for (int index = 0; index < numPartitions; index++) {
      String partition = String.valueOf(index);
      partitions.add(partition);
      int numRows = maxRowsPerPartition == 0 ? 0 : random.nextInt(maxRowsPerPartition) + 1;
      RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
      com.google.spanner.v1.ResultSet proto = generator.generate();
      if (withErrors) {
        // Add a random error somewhere in the result.
        int errorIndex = numRows == 0 ? 0 : random.nextInt(numRows);
        minErrorIndex = Math.min(minErrorIndex, errorIndex);
        when(connection.runPartition(partition))
            .thenReturn(new ResultSetWithError(ResultSetsHelper.fromProto(proto), errorIndex));
      } else {
        if (withEmptyResults && numPartitions > 1 && index == 0) {
          when(connection.runPartition(partition))
              .thenReturn(
                  ResultSetsHelper.fromProto(
                      com.google.spanner.v1.ResultSet.newBuilder()
                          .setMetadata(
                              ResultSetMetadata.newBuilder()
                                  .setRowType(StructType.newBuilder().build())
                                  .build())
                          .build()));
        } else {
          when(connection.runPartition(partition)).thenReturn(ResultSetsHelper.fromProto(proto));
          try (ResultSet resultSet = ResultSetsHelper.fromProto(proto)) {
            while (resultSet.next()) {
              allRows.add(resultSet.getCurrentRowAsStruct());
            }
          }
        }
      }
    }
    return new MockedResults(connection, partitions, allRows, minErrorIndex);
  }

  @Test
  public void testAllResultsAreReturned() {
    MockedResults results = setupResults(/* withErrors= */ false, /* withEmptyResults= */ false);
    BitSet rowsFound = new BitSet(results.allRows.size());
    try (MergedResultSet resultSet =
        new MergedResultSet(results.connection, results.partitions, maxParallelism)) {
      while (resultSet.next()) {
        assertRowExists(results.allRows, resultSet.getCurrentRowAsStruct(), rowsFound);
      }
      // Verify that we can get the metadata after having gotten all rows.
      // This failed in the initial release of this feature for result sets that were empty. The
      // reason for that was that the initial implementation would do a call to currentRowAsStruct,
      // which would always be null for result sets that never returned any data.
      assertNotNull(resultSet.getMetadata());
      if (numPartitions == 0) {
        assertEquals(0, resultSet.getColumnCount());
      } else {
        assertEquals(26, resultSet.getColumnCount());
        assertEquals(Type.bool(), resultSet.getColumnType(0));
        assertEquals(Type.bool(), resultSet.getColumnType("COL0"));
        assertEquals(10, resultSet.getColumnIndex("COL10"));
      }
      // Check that all rows were found.
      assertEquals(results.allRows.size(), rowsFound.nextClearBit(0));
      // Check extended metadata.
      assertEquals(numPartitions, resultSet.getNumPartitions());
      if (maxParallelism > 0) {
        assertEquals(Math.min(numPartitions, maxParallelism), resultSet.getParallelism());
      } else {
        int processors = Runtime.getRuntime().availableProcessors();
        assertEquals(Math.min(numPartitions, processors), resultSet.getParallelism());
      }
    }
  }

  @Test
  public void testResultSetStopsAfterFirstError() {
    MockedResults results = setupResults(/* withErrors= */ true, /* withEmptyResults= */ false);
    try (MergedResultSet resultSet =
        new MergedResultSet(results.connection, results.partitions, maxParallelism)) {
      if (numPartitions > 0) {
        AtomicInteger rowCount = new AtomicInteger();
        SpannerException exception =
            assertThrows(
                SpannerException.class,
                () -> {
                  while (resultSet.next()) {
                    rowCount.getAndIncrement();
                  }
                });
        assertEquals(ErrorCode.INTERNAL, exception.getErrorCode());
        assertTrue(exception.getMessage(), exception.getMessage().contains("test error"));
        // The result set should continue to throw the same error if we continue to call next().
        SpannerException nextException = assertThrows(SpannerException.class, resultSet::next);
        assertEquals(exception, nextException);
        // We should see at least minErrorIndex rows before an error.
        assertTrue(rowCount.get() >= results.minErrorIndex);
      }
    }
  }

  @Test
  public void testResultSetReturnsNonEmptyMetadata() {
    MockedResults results = setupResults(/* withErrors= */ false, /* withEmptyResults= */ true);
    BitSet rowsFound = new BitSet(results.allRows.size());
    try (MergedResultSet resultSet =
        new MergedResultSet(results.connection, results.partitions, maxParallelism)) {
      if (numPartitions > 0) {
        assertNotNull(resultSet.getMetadata());
        assertEquals(26, resultSet.getMetadata().getRowType().getFieldsCount());
      }
      while (resultSet.next()) {
        assertRowExists(results.allRows, resultSet.getCurrentRowAsStruct(), rowsFound);
      }
      if (numPartitions == 0) {
        assertEquals(0, resultSet.getColumnCount());
      } else {
        assertEquals(26, resultSet.getColumnCount());
        assertEquals(Type.bool(), resultSet.getColumnType(0));
        assertEquals(Type.bool(), resultSet.getColumnType("COL0"));
        assertEquals(10, resultSet.getColumnIndex("COL10"));
      }
      // Check that all rows were found.
      assertEquals(results.allRows.size(), rowsFound.nextClearBit(0));
      // Check extended metadata.
      assertEquals(numPartitions, resultSet.getNumPartitions());
      if (maxParallelism > 0) {
        assertEquals(Math.min(numPartitions, maxParallelism), resultSet.getParallelism());
      } else {
        int processors = Runtime.getRuntime().availableProcessors();
        assertEquals(Math.min(numPartitions, processors), resultSet.getParallelism());
      }
    }
  }

  private void assertRowExists(List<Struct> expectedRows, Struct row, BitSet rowsFound) {
    for (int i = 0; i < expectedRows.size(); i++) {
      if (row.equals(expectedRows.get(i))) {
        rowsFound.set(i);
        return;
      }
    }
    fail("row not found: " + row);
  }
}
