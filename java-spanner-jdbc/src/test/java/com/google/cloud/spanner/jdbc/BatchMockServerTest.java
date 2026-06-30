/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static com.google.cloud.spanner.jdbc.FallbackToPartitionedDMLMockServerTest.createTransactionMutationLimitExceededException;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.TransactionMutationLimitExceededException;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BatchMockServerTest extends AbstractMockServerTest {
  private static final String NON_PARAMETERIZED_INSERT =
      "insert into foo (id, value) values (1, 'One')";
  private static final String NON_PARAMETERIZED_UPDATE = "update foo set value='Zero' where id=0";
  private static final String LARGE_UPDATE = "update foo set value='Zero' where true";

  @BeforeClass
  public static void setup() {
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.of(NON_PARAMETERIZED_INSERT), 1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.of(NON_PARAMETERIZED_UPDATE), 1L));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            com.google.cloud.spanner.Statement.of(LARGE_UPDATE),
            createTransactionMutationLimitExceededException()));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testStatementBatch() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(NON_PARAMETERIZED_INSERT);
        statement.addBatch(NON_PARAMETERIZED_UPDATE);
        assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testStatementBatchFailsDueToMutationLimit() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(NON_PARAMETERIZED_INSERT);
        statement.addBatch(LARGE_UPDATE);

        BatchUpdateException batchUpdateException =
            assertThrows(BatchUpdateException.class, statement::executeBatch);
        assertNotNull(batchUpdateException.getCause());
        assertEquals(SpannerBatchUpdateException.class, batchUpdateException.getCause().getClass());
        assertNotNull(batchUpdateException.getCause().getCause());
        assertEquals(
            TransactionMutationLimitExceededException.class,
            batchUpdateException.getCause().getCause().getClass());
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }
}
