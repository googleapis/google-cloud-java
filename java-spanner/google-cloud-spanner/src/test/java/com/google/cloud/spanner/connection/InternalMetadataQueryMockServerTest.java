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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.connection.Connection.InternalMetadataQuery;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartitionQueryRequest;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InternalMetadataQueryMockServerTest extends AbstractMockServerTest {
  private static final Statement STATEMENT =
      Statement.of("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES");

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  @BeforeClass
  public static void setupInternalMetadataQueryResults() {
    mockSpanner.putStatementResult(
        StatementResult.query(STATEMENT, SELECT_COUNT_RESULTSET_BEFORE_INSERT));
  }

  @Before
  public void setupDialect() {
    mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testInternalMetadataQueryInAutocommit() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      verifyInternalMetadataQuery(connection);
    }
  }

  @Test
  public void testInternalMetadataQueryWithStaleness() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setReadOnlyStaleness(TimestampBound.ofMaxStaleness(10L, TimeUnit.SECONDS));
      verifyInternalMetadataQuery(connection);
    }
  }

  @Test
  public void testInternalMetadataQueryReadOnlyTransaction() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(true);
      verifyInternalMetadataQuery(connection);
    }
  }

  @Test
  public void testInternalMetadataQueryReadOnlyTransactionWithStaleness() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(true);
      connection.setReadOnlyStaleness(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));
      verifyInternalMetadataQuery(connection);
    }
  }

  @Test
  public void testInternalMetadataQueryReadWriteTransaction() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setReadOnly(false);
      verifyInternalMetadataQuery(connection);
    }
  }

  @Test
  public void testInternalMetadataQueryInDmlBatch() {
    try (Connection connection = createConnection()) {
      connection.startBatchDml();
      verifyInternalMetadataQuery(connection);
      connection.runBatch();
    }
  }

  @Test
  public void testInternalMetadataQueryInDdlBatch() {
    try (Connection connection = createConnection()) {
      connection.startBatchDdl();
      verifyInternalMetadataQuery(connection);
      connection.runBatch();
    }
  }

  @Test
  public void testInternalMetadataQueryInAutoPartitionMode() {
    try (Connection connection = createConnection()) {
      connection.setAutoPartitionMode(true);
      verifyInternalMetadataQuery(connection);
    }
  }

  private void verifyInternalMetadataQuery(Connection connection) {
    try (ResultSet resultSet = connection.executeQuery(STATEMENT, InternalMetadataQuery.INSTANCE)) {
      assertTrue(resultSet.next());
      assertEquals(0L, resultSet.getLong(0));
      assertFalse(resultSet.next());
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasSingleUse());
    assertTrue(request.getTransaction().getSingleUse().hasReadOnly());
    assertTrue(request.getTransaction().getSingleUse().getReadOnly().hasStrong());
    assertEquals(ByteString.EMPTY, request.getPartitionToken());
    assertEquals(0, mockSpanner.countRequestsOfType(PartitionQueryRequest.class));
  }
}
