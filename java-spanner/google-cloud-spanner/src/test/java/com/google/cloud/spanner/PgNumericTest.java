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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PgNumericTest {

  private static final String PROJECT = "my-project";
  private static final String INSTANCE = "my-instance";
  private static final String DATABASE = "database";
  private static final ResultSetMetadata RESULT_SET_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("PgNumeric")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.NUMERIC)
                                  .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                                  .build()))
                  .addFields(
                      Field.newBuilder()
                          .setName("PgNumericArray")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.ARRAY)
                                  .setArrayElementType(
                                      com.google.spanner.v1.Type.newBuilder()
                                          .setCode(TypeCode.NUMERIC)
                                          .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC))
                                  .build()))
                  .build())
          .build();
  private static MockSpannerServiceImpl mockSpanner;
  private static InetSocketAddress address;
  private static Server server;
  private Spanner spanner;
  private DatabaseClient databaseClient;

  @BeforeClass
  public static void beforeClass() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);

    address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() throws Exception {
    final String endpoint = address.getHostString() + ":" + server.getPort();
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId(PROJECT)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
            .build()
            .getService();
    databaseClient = spanner.getDatabaseClient(DatabaseId.of(PROJECT, INSTANCE, DATABASE));
  }

  @After
  public void tearDown() throws Exception {
    spanner.close();
    mockSpanner.removeAllExecutionTimes();
    mockSpanner.reset();
  }

  @Test
  public void testQueryNoNullsAsStrings() {
    final Statement statement =
        Statement.of("SELECT PgNumeric, PgNumericArray FROM Table WHERE Id = 0");
    final com.google.spanner.v1.ResultSet result =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(RESULT_SET_METADATA)
            .addRows(
                ListValue.newBuilder()
                    .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1.23"))
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("2.34"))
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("3.45"))
                                    .build()))
                    .build())
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, result));

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.of("SELECT PgNumeric, PgNumericArray FROM Table WHERE Id = 0"))) {
      resultSet.next();

      assertEquals("1.23", resultSet.getString("PgNumeric"));
      assertEquals("1.23", resultSet.getString(0));
      assertEquals(Arrays.asList("2.34", "3.45"), resultSet.getStringList("PgNumericArray"));
      assertEquals(Arrays.asList("2.34", "3.45"), resultSet.getStringList(1));
    }
  }

  @Test
  public void testQueryNoNullsAsValues() {
    final Statement statement =
        Statement.of("SELECT PgNumeric, PgNumericArray FROM Table WHERE Id = 0");
    final com.google.spanner.v1.ResultSet result =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(RESULT_SET_METADATA)
            .addRows(
                ListValue.newBuilder()
                    .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1.23"))
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("2.34"))
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("3.45"))
                                    .build()))
                    .build())
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, result));

    try (ResultSet resultSet = databaseClient.singleUse().executeQuery(statement)) {
      resultSet.next();

      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue("PgNumeric"));
      assertEquals(Value.pgNumeric("1.23"), resultSet.getValue(0));
      assertEquals(
          Value.pgNumericArray(Arrays.asList("2.34", "3.45")),
          resultSet.getValue("PgNumericArray"));
      assertEquals(Value.pgNumericArray(Arrays.asList("2.34", "3.45")), resultSet.getValue(1));
    }
  }

  @Test
  public void testQueryNullElements() {
    final Statement statement =
        Statement.of("SELECT PgNumeric, PgNumericArray FROM Table WHERE Id = 3");
    final com.google.spanner.v1.ResultSet result =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(RESULT_SET_METADATA)
            .addRows(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE))
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("1.23"))
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setNullValue(NullValue.NULL_VALUE))
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("2.34"))
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setNullValue(NullValue.NULL_VALUE))
                                    .build()))
                    .build())
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, result));

    try (ResultSet resultSet = databaseClient.singleUse().executeQuery(statement)) {
      resultSet.next();

      assertEquals(
          Value.pgNumericArray(Arrays.asList("1.23", null, "2.34", null)),
          resultSet.getValue("PgNumericArray"));
      assertEquals(
          Value.pgNumericArray(Arrays.asList("1.23", null, "2.34", null)), resultSet.getValue(1));
    }
  }

  @Test
  public void testQueryNaNs() {
    final Statement statement =
        Statement.of("SELECT PgNumeric, PgNumericArray FROM Table WHERE Id = 2");
    final com.google.spanner.v1.ResultSet result =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(RESULT_SET_METADATA)
            .addRows(
                ListValue.newBuilder()
                    .addValues(com.google.protobuf.Value.newBuilder().setStringValue("NaN"))
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("NaN"))
                                    .addValues(
                                        com.google.protobuf.Value.newBuilder()
                                            .setStringValue("NaN"))
                                    .build()))
                    .build())
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, result));

    try (ResultSet resultSet = databaseClient.singleUse().executeQuery(statement)) {
      resultSet.next();

      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue("PgNumeric"));
      assertEquals(Value.pgNumeric("NaN"), resultSet.getValue(0));
      assertEquals(
          Value.pgNumericArray(Arrays.asList("NaN", "NaN")), resultSet.getValue("PgNumericArray"));
      assertEquals(Value.pgNumericArray(Arrays.asList("NaN", "NaN")), resultSet.getValue(1));
    }
  }

  @Test
  public void testQueryNulls() {
    final Statement statement =
        Statement.of("SELECT PgNumeric, PgNumericArray FROM Table WHERE Id = 1");
    final com.google.spanner.v1.ResultSet result =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(RESULT_SET_METADATA)
            .addRows(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE))
                    .addValues(
                        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE))
                    .build())
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, result));

    try (ResultSet resultSet = databaseClient.singleUse().executeQuery(statement)) {
      resultSet.next();

      assertTrue(resultSet.isNull("PgNumeric"));
      assertTrue(resultSet.isNull(0));
      assertTrue(resultSet.isNull("PgNumericArray"));
      assertTrue(resultSet.isNull(1));
    }
  }

  @Test
  public void testMutation() {
    final List<Mutation> mutations =
        Collections.singletonList(
            Mutation.newInsertBuilder("Table")
                .set("PgNumeric")
                .to("1.23")
                .set("PgNumericNull")
                .to((String) null)
                .set("PgNumericNaN")
                .to("NaN")
                .set("PgNumericValue")
                .to(Value.pgNumeric("2.34"))
                .set("PgNumericArray")
                .toStringArray(Arrays.asList("2.34", null, "3.45"))
                .set("PgNumericArrayNull")
                .toStringArray(null)
                .build());
    final List<com.google.spanner.v1.Mutation> expectedMutations = new ArrayList<>();
    Mutation.toProtoAndReturnRandomMutation(mutations, expectedMutations);

    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.buffer(mutations);
              return null;
            });

    final List<CommitRequest> requests = mockSpanner.getRequestsOfType(CommitRequest.class);
    final CommitRequest request = requests.get(0);
    assertEquals(1, requests.size());
    assertEquals(expectedMutations, request.getMutationsList());
  }

  @Test
  public void testParameterizedStatement() {
    final Statement statement =
        Statement.newBuilder("SELECT * FROM Table WHERE PgNumeric IN (@col1, @col2, @col3)")
            .bind("col1")
            .to(Value.pgNumeric("1.23"))
            .bind("col2")
            .to(Value.pgNumeric("NaN"))
            .bind("col3")
            .to(Value.pgNumeric(null))
            .build();
    final com.google.spanner.v1.ResultSet result =
        com.google.spanner.v1.ResultSet.newBuilder()
            .setMetadata(RESULT_SET_METADATA)
            .addRows(ListValue.newBuilder().build())
            .build();
    mockSpanner.putStatementResult(StatementResult.query(statement, result));

    try (ResultSet resultSet = databaseClient.singleUse().executeQuery(statement)) {
      resultSet.next();

      final List<ExecuteSqlRequest> requests =
          mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      final ExecuteSqlRequest request = requests.get(0);

      assertEquals(1, requests.size());
      assertEquals(
          ImmutableMap.of(
              "col1", Type.pgNumeric().toProto(),
              "col2", Type.pgNumeric().toProto(),
              "col3", Type.pgNumeric().toProto()),
          request.getParamTypesMap());
    }
  }
}
