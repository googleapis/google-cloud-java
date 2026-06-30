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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.MockServerHelper;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.common.base.Strings;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MultiplexedSessionsTest extends AbstractMockServerTest {
  private static final String PROCESS_ENVIRONMENT = "java.lang.ProcessEnvironment";
  private static final String ENVIRONMENT = "theUnmodifiableEnvironment";
  private static final String SOURCE_MAP = "m";
  private static final Object STATIC_METHOD = null;
  private static final Class<?> UMODIFIABLE_MAP_CLASS =
      Collections.unmodifiableMap(Collections.emptyMap()).getClass();
  private static final Class<?> MAP_CLASS = Map.class;

  private static boolean setEnvVar = false;

  private String query;
  private String dml;
  private String dmlReturning;

  @SuppressWarnings("unchecked")
  private static Map<String, String> getModifiableEnvironment() throws Exception {
    Class<?> environmentClass = Class.forName(PROCESS_ENVIRONMENT);
    java.lang.reflect.Field environmentField = environmentClass.getDeclaredField(ENVIRONMENT);
    assertNotNull(environmentField);
    environmentField.setAccessible(true);

    Object unmodifiableEnvironmentMap = environmentField.get(STATIC_METHOD);
    assertNotNull(unmodifiableEnvironmentMap);
    assertTrue(UMODIFIABLE_MAP_CLASS.isAssignableFrom(unmodifiableEnvironmentMap.getClass()));

    java.lang.reflect.Field underlyingMapField =
        unmodifiableEnvironmentMap.getClass().getDeclaredField(SOURCE_MAP);
    underlyingMapField.setAccessible(true);
    Object underlyingMap = underlyingMapField.get(unmodifiableEnvironmentMap);
    assertNotNull(underlyingMap);
    assertTrue(MAP_CLASS.isAssignableFrom(underlyingMap.getClass()));

    return (Map<String, String>) underlyingMap;
  }

  @BeforeClass
  public static void setEnvVars() throws Exception {
    // Java versions 8 and lower start with 1. (1.8, 1.7 etc.).
    // Higher versions start with the major version number.
    // So this effectively verifies that the test is running on Java 8.
    assumeTrue(System.getProperty("java.version", "undefined").startsWith("1."));
    assumeFalse(System.getProperty("os.name", "").toLowerCase().startsWith("windows"));

    if (Strings.isNullOrEmpty(System.getenv("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW"))) {
      Map<String, String> env = getModifiableEnvironment();
      env.put("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW", "true");
      setEnvVar = true;
    }
  }

  @AfterClass
  public static void clearEnvVars() throws Exception {
    if (setEnvVar) {
      Map<String, String> env = getModifiableEnvironment();
      env.remove("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW");
    }
  }

  @Before
  public void setupResults() {
    query = "select * from my_table";
    dml = "insert into my_table (id, value) values (1, 'One')";
    String DML_THEN_RETURN_ID = dml + "\nTHEN RETURN `id`";
    dmlReturning = "insert into my_table (id, value) values (1, 'One') THEN RETURN *";

    super.setupResults();

    com.google.spanner.v1.ResultSet resultSet =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setRowType(
                        StructType.newBuilder()
                            .addFields(
                                Field.newBuilder()
                                    .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                    .setName("id")
                                    .build())
                            .addFields(
                                Field.newBuilder()
                                    .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                    .setName("value")
                                    .build())
                            .build())
                    .build())
            .addRows(
                ListValue.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("1").build())
                    .addValues(Value.newBuilder().setStringValue("One").build())
                    .build())
            .build();
    com.google.spanner.v1.ResultSet returnIdResultSet =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setRowType(
                        StructType.newBuilder()
                            .addFields(
                                Field.newBuilder()
                                    .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                    .setName("id")
                                    .build())
                            .build())
                    .build())
            .addRows(
                ListValue.newBuilder()
                    .addValues(Value.newBuilder().setStringValue("1").build())
                    .build())
            .build();
    mockSpanner.putStatementResult(
        StatementResult.query(com.google.cloud.spanner.Statement.of(query), resultSet));
    mockSpanner.putStatementResult(
        StatementResult.update(com.google.cloud.spanner.Statement.of(dml), 1L));
    mockSpanner.putStatementResult(
        StatementResult.query(
            com.google.cloud.spanner.Statement.of(dmlReturning),
            resultSet.toBuilder()
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    mockSpanner.putStatementResult(
        StatementResult.query(
            com.google.cloud.spanner.Statement.of(DML_THEN_RETURN_ID),
            returnIdResultSet.toBuilder()
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true",
        getPort(), "proj", "inst", "db");
  }

  @Override
  protected Connection createJdbcConnection() throws SQLException {
    return DriverManager.getConnection(createUrl());
  }

  @Test
  public void testStatementExecuteQuery() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(query)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {}
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(MockServerHelper.getSession(mockSpanner, request.getSession()).getMultiplexed());
  }

  @Test
  public void testStatementExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      assertEquals(1, statement.executeUpdate(dml));
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(MockServerHelper.getSession(mockSpanner, request.getSession()).getMultiplexed());
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
  }

  @Test
  public void testStatementExecuteQueryDmlReturning() throws SQLException {
    try (Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(dmlReturning)) {
        //noinspection StatementWithEmptyBody
        while (resultSet.next()) {}
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertTrue(MockServerHelper.getSession(mockSpanner, request.getSession()).getMultiplexed());
    assertTrue(request.hasTransaction());
    assertTrue(request.getTransaction().hasBegin());
    assertTrue(request.getTransaction().getBegin().hasReadWrite());
  }
}
