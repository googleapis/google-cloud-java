/*
 * Copyright 2022 Google LLC
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

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PgNumericPreparedStatementTest {

  private static final String PROJECT = "my-project";
  private static final String INSTANCE = "my-instance";
  private static final String DATABASE = "my-database";
  private static final String QUERY = "INSERT INTO Table (col1) VALUES (?)";
  private static final String REWRITTEN_QUERY = "INSERT INTO Table (col1) VALUES ($1)";
  private static MockSpannerServiceImpl mockSpanner;
  private static InetSocketAddress address;
  private static Server server;
  private Connection connection;

  @BeforeClass
  public static void beforeClass() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);
    mockSpanner.putStatementResult(StatementResult.detectDialectResult(Dialect.POSTGRESQL));

    address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() throws Exception {
    final String endpoint = address.getHostString() + ":" + server.getPort();
    final String url =
        String.format(
            "jdbc:cloudspanner://%s/projects/%s/instances/%s/databases/%s?usePlainText=true;dialect=POSTGRESQL",
            endpoint, PROJECT, INSTANCE, DATABASE);
    connection = DriverManager.getConnection(url);
    mockSpanner.clearRequests();
  }

  @After
  public void tearDown() throws Exception {
    connection.close();
  }

  @Test
  public void testSetByteAsObject() throws SQLException {
    final Byte param = 1;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetShortAsObject() throws SQLException {
    final Short param = 1;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetIntAsObject() throws SQLException {
    final Integer param = 1;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetLongAsObject() throws SQLException {
    final Long param = 1L;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetFloatAsObject() throws SQLException {
    final Float param = 1F;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetFloatNaNAsObject() throws SQLException {
    final Float param = Float.NaN;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetDoubleAsObject() throws SQLException {
    final Double param = 1D;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetDoubleNaNAsObject() throws SQLException {
    final Double param = Double.NaN;

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetBigDecimalAsObject() throws SQLException {
    final BigDecimal param = new BigDecimal("1.23");

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetBigDecimalAsObjectWithoutExplicitType() throws SQLException {
    final BigDecimal param = new BigDecimal("1.23");

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setObject(1, param);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetBigDecimal() throws SQLException {
    final BigDecimal param = new BigDecimal("1");

    mockScalarUpdateWithParam(param.toString());
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setBigDecimal(1, param);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(param.toString());
  }

  @Test
  public void testSetNull() throws SQLException {
    mockScalarUpdateWithParam(null);
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setNull(1, Types.NUMERIC);
      preparedStatement.executeUpdate();
    }
    assertRequestWithScalar(null);
  }

  @Test
  public void testSetNumericArray() throws SQLException {
    final BigDecimal[] param = {BigDecimal.ONE, null, BigDecimal.TEN};

    mockArrayUpdateWithParam(Arrays.asList("1", null, "10"));
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setArray(1, connection.createArrayOf("numeric", param));
      preparedStatement.executeUpdate();
    }
    assertRequestWithArray(Arrays.asList("1", null, "10"));
  }

  @Test
  public void testSetNullArray() throws SQLException {
    mockArrayUpdateWithParam(null);
    try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
      preparedStatement.setArray(1, connection.createArrayOf("numeric", null));
      preparedStatement.executeUpdate();
    }
    assertRequestWithArray(null);
  }

  private void mockScalarUpdateWithParam(String value) {
    mockSpanner.putStatementResult(
        StatementResult.update(
            Statement.newBuilder(REWRITTEN_QUERY)
                .bind("p1")
                .to(com.google.cloud.spanner.Value.pgNumeric(value))
                .build(),
            1));
  }

  private void mockArrayUpdateWithParam(Iterable<String> value) {
    mockSpanner.putStatementResult(
        StatementResult.update(
            Statement.newBuilder(REWRITTEN_QUERY)
                .bind("p1")
                .to(com.google.cloud.spanner.Value.pgNumericArray(value))
                .build(),
            1));
  }

  private void assertRequestWithScalar(String value) {
    final ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    final String actualSql = request.getSql();
    final Struct actualParams = request.getParams();
    final Map<String, Type> actualParamTypes = request.getParamTypesMap();

    final Value parameterValue = protoValueFromString(value);
    final Struct expectedParams = Struct.newBuilder().putFields("p1", parameterValue).build();
    final ImmutableMap<String, Type> expectedTypes =
        ImmutableMap.of(
            "p1",
            Type.newBuilder()
                .setCode(TypeCode.NUMERIC)
                .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                .build());
    assertEquals(REWRITTEN_QUERY, actualSql);
    assertEquals(expectedParams, actualParams);
    assertEquals(expectedTypes, actualParamTypes);
  }

  private void assertRequestWithArray(Iterable<String> value) {
    final ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    final String actualSql = request.getSql();
    final Struct actualParams = request.getParams();
    final Map<String, Type> actualParamTypes = request.getParamTypesMap();

    Value parameterValue;
    if (value != null) {
      final ListValue.Builder builder = ListValue.newBuilder();
      value.forEach(v -> builder.addValues(protoValueFromString(v)));
      parameterValue = Value.newBuilder().setListValue(builder.build()).build();
    } else {
      parameterValue = Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
    }
    final Struct expectedParams = Struct.newBuilder().putFields("p1", parameterValue).build();
    final ImmutableMap<String, Type> expectedTypes =
        ImmutableMap.of(
            "p1",
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(
                    Type.newBuilder()
                        .setCode(TypeCode.NUMERIC)
                        .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC))
                .build());
    assertEquals(REWRITTEN_QUERY, actualSql);
    assertEquals(expectedParams, actualParams);
    assertEquals(expectedTypes, actualParamTypes);
  }

  private Value protoValueFromString(String value) {
    if (value == null) {
      return Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
    } else {
      return Value.newBuilder().setStringValue(value).build();
    }
  }
}
