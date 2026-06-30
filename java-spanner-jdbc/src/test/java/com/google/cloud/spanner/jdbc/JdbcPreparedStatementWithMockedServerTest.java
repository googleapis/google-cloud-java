/*
 * Copyright 2021 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlBatchUpdateException;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JdbcPreparedStatementWithMockedServerTest {
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;

  @Parameter public boolean executeLarge;

  @Parameters(name = "executeLarge = {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{false}, {true}});
  }

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);
    InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    server.shutdown();
    server.awaitTermination();
  }

  @After
  public void reset() {
    SpannerPool.closeSpannerPool();
    mockSpanner.removeAllExecutionTimes();
    mockSpanner.reset();
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true",
        server.getPort(), "proj", "inst", "db");
  }

  private Connection createConnection() throws SQLException {
    return DriverManager.getConnection(createUrl());
  }

  @Test
  public void testExecuteBatch() throws SQLException {
    Statement.Builder insertBuilder =
        Statement.newBuilder("INSERT INTO Test (Col1, Col2) VALUES (@p1, @p2)");
    mockSpanner.putStatementResult(
        StatementResult.update(
            insertBuilder.bind("p1").to(1L).bind("p2").to("test 1").build(), 1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            insertBuilder.bind("p1").to(2L).bind("p2").to("test 2").build(), 1L));
    try (Connection connection = createConnection()) {
      try (PreparedStatement statement =
          connection.prepareStatement("INSERT INTO Test (Col1, Col2) VALUES (?, ?)")) {
        statement.setLong(1, 1L);
        statement.setString(2, "test 1");
        statement.addBatch();
        statement.setLong(1, 2L);
        statement.setString(2, "test 2");
        statement.addBatch();
        if (executeLarge) {
          assertThat(statement.executeLargeBatch()).asList().containsExactly(1L, 1L);
        } else {
          assertThat(statement.executeBatch()).asList().containsExactly(1, 1);
        }
      }
    }
  }

  @Test
  public void testExecuteBatch_withOverflow() throws SQLException {
    Statement.Builder insertBuilder =
        Statement.newBuilder("INSERT INTO Test (Col1, Col2) VALUES (@p1, @p2)");
    mockSpanner.putStatementResult(
        StatementResult.update(
            insertBuilder.bind("p1").to(1L).bind("p2").to("test 1").build(), 1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            insertBuilder.bind("p1").to(2L).bind("p2").to("test 2").build(),
            Integer.MAX_VALUE + 1L));
    try (Connection connection = createConnection()) {
      try (PreparedStatement statement =
          connection.prepareStatement("INSERT INTO Test (Col1, Col2) VALUES (?, ?)")) {
        statement.setLong(1, 1L);
        statement.setString(2, "test 1");
        statement.addBatch();
        statement.setLong(1, 2L);
        statement.setString(2, "test 2");
        statement.addBatch();
        if (executeLarge) {
          assertThat(statement.executeLargeBatch())
              .asList()
              .containsExactly(1L, Integer.MAX_VALUE + 1L);
        } else {
          try {
            statement.executeBatch();
            fail("missing expected OutOfRange exception");
          } catch (SQLException e) {
            assertTrue(e instanceof JdbcSqlException);
            JdbcSqlException sqlException = (JdbcSqlException) e;
            assertEquals(
                ErrorCode.OUT_OF_RANGE.getGrpcStatusCode().value(), sqlException.getErrorCode());
          }
        }
      }
    }
  }

  @Test
  public void testExecuteBatch_withException() throws SQLException {
    Statement.Builder insertBuilder =
        Statement.newBuilder("INSERT INTO Test (Col1, Col2) VALUES (@p1, @p2)");
    mockSpanner.putStatementResult(
        StatementResult.update(
            insertBuilder.bind("p1").to(1L).bind("p2").to("test 1").build(), 1L));
    mockSpanner.putStatementResult(
        StatementResult.exception(
            insertBuilder.bind("p1").to(2L).bind("p2").to("test 2").build(),
            Status.ALREADY_EXISTS.asRuntimeException()));
    try (Connection connection = createConnection()) {
      try (PreparedStatement statement =
          connection.prepareStatement("INSERT INTO Test (Col1, Col2) VALUES (?, ?)")) {
        statement.setLong(1, 1L);
        statement.setString(2, "test 1");
        statement.addBatch();
        statement.setLong(1, 2L);
        statement.setString(2, "test 2");
        statement.addBatch();
        try {
          if (executeLarge) {
            statement.executeLargeBatch();
          } else {
            statement.executeBatch();
          }
        } catch (JdbcSqlBatchUpdateException e) {
          if (executeLarge) {
            assertThat(e.getLargeUpdateCounts()).asList().containsExactly(1L);
          } else {
            assertThat(e.getUpdateCounts()).asList().containsExactly(1);
          }
        }
      }
    }
  }

  @Test
  public void testInsertUntypedNullValues() throws SQLException {
    String sql =
        "insert into all_nullable_types (ColInt64, ColFloat64, ColBool, ColString, ColBytes, ColDate, ColTimestamp, ColNumeric, ColJson, ColInt64Array, ColFloat64Array, ColBoolArray, ColStringArray, ColBytesArray, ColDateArray, ColTimestampArray, ColNumericArray, ColJsonArray) "
            + "values (@p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18)";
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(sql),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setUndeclaredParameters(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p1")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p2")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.FLOAT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p3")
                                        .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p4")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p5")
                                        .setType(Type.newBuilder().setCode(TypeCode.BYTES).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p6")
                                        .setType(Type.newBuilder().setCode(TypeCode.DATE).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p7")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p8")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.NUMERIC).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p9")
                                        .setType(Type.newBuilder().setCode(TypeCode.JSON).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p10")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.INT64)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p11")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.FLOAT64)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p12")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.BOOL)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p13")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.STRING)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p14")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.BYTES)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p15")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.DATE)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p16")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.TIMESTAMP)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p17")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.NUMERIC)
                                                        .build())
                                                .build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("p18")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.ARRAY)
                                                .setArrayElementType(
                                                    Type.newBuilder()
                                                        .setCode(TypeCode.JSON)
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .setStats(ResultSetStats.newBuilder().build())
                .build()));
    mockSpanner.putStatementResult(
        StatementResult.update(
            Statement.newBuilder(sql)
                .bind("p1")
                .to((Value) null)
                .bind("p2")
                .to((Value) null)
                .bind("p3")
                .to((Value) null)
                .bind("p4")
                .to((Value) null)
                .bind("p5")
                .to((Value) null)
                .bind("p6")
                .to((Value) null)
                .bind("p7")
                .to((Value) null)
                .bind("p8")
                .to((Value) null)
                .bind("p9")
                .to((Value) null)
                .bind("p10")
                .to((Value) null)
                .bind("p11")
                .to((Value) null)
                .bind("p12")
                .to((Value) null)
                .bind("p13")
                .to((Value) null)
                .bind("p14")
                .to((Value) null)
                .bind("p15")
                .to((Value) null)
                .bind("p16")
                .to((Value) null)
                .bind("p17")
                .to((Value) null)
                .bind("p18")
                .to((Value) null)
                .build(),
            1L));
    try (Connection connection = createConnection()) {
      for (int type : new int[] {Types.OTHER, Types.NULL}) {
        try (PreparedStatement statement =
            connection.prepareStatement(
                "insert into all_nullable_types ("
                    + "ColInt64, ColFloat64, ColBool, ColString, ColBytes, ColDate, ColTimestamp, ColNumeric, ColJson, "
                    + "ColInt64Array, ColFloat64Array, ColBoolArray, ColStringArray, ColBytesArray, ColDateArray, ColTimestampArray, ColNumericArray, ColJsonArray) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
          for (int param = 1;
              param <= statement.getParameterMetaData().getParameterCount();
              param++) {
            statement.setNull(param, type);
          }
          assertEquals(1, statement.executeUpdate());
        }
        mockSpanner.clearRequests();
      }
    }
  }
}
