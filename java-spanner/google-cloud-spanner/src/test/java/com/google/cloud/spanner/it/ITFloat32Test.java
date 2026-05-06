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

package com.google.cloud.spanner.it;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.ConnectionOptions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITFloat32Test {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  @Parameterized.Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    return Arrays.asList(
        new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL),
        new DialectTestParameter(Dialect.POSTGRESQL));
  }

  @Parameterized.Parameter() public DialectTestParameter dialect;

  private static DatabaseClient googleStandardSQLClient;
  private static DatabaseClient postgreSQLClient;

  private static final String[] GOOGLE_STANDARD_SQL_SCHEMA =
      new String[] {
        "CREATE TABLE T ("
            + "  Key                 STRING(MAX) NOT NULL,"
            + "  Float32Value        FLOAT32,"
            + "  Float32ArrayValue   ARRAY<FLOAT32>,"
            + ") PRIMARY KEY (Key)"
      };

  private static final String[] POSTGRESQL_SCHEMA =
      new String[] {
        "CREATE TABLE T ("
            + "  Key                 VARCHAR PRIMARY KEY,"
            + "  Float32Value        REAL,"
            + "  Float32ArrayValue   REAL[]"
            + ")"
      };

  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase()
      throws ExecutionException, InterruptedException, TimeoutException {
    Database googleStandardSQLDatabase =
        env.getTestHelper().createTestDatabase(GOOGLE_STANDARD_SQL_SCHEMA);

    googleStandardSQLClient = env.getTestHelper().getDatabaseClient(googleStandardSQLDatabase);

    Database postgreSQLDatabase =
        env.getTestHelper()
            .createTestDatabase(Dialect.POSTGRESQL, Arrays.asList(POSTGRESQL_SCHEMA));
    postgreSQLClient = env.getTestHelper().getDatabaseClient(postgreSQLDatabase);
  }

  @Before
  public void before() {
    client =
        dialect.dialect == Dialect.GOOGLE_STANDARD_SQL ? googleStandardSQLClient : postgreSQLClient;
  }

  @AfterClass
  public static void tearDown() throws Exception {
    ConnectionOptions.closeSpanner();
  }

  /** Sequence used to generate unique keys. */
  private static int seq;

  private static String uniqueString() {
    return String.format("k%04d", seq++);
  }

  private String lastKey;

  private Timestamp write(Mutation m) {
    return client.write(Collections.singletonList(m));
  }

  private Mutation.WriteBuilder baseInsert() {
    return Mutation.newInsertOrUpdateBuilder("T").set("Key").to(lastKey = uniqueString());
  }

  private Struct readRow(String table, String key, String... columns) {
    return client
        .singleUse(TimestampBound.strong())
        .readRow(table, Key.of(key), Arrays.asList(columns));
  }

  private Struct readLastRow(String... columns) {
    return readRow("T", lastKey, columns);
  }

  @Test
  public void writeFloat32() {
    write(baseInsert().set("Float32Value").to(2.0f).build());
    Struct row = readLastRow("Float32Value");
    assertFalse(row.isNull(0));
    assertEquals(2.0f, row.getFloat(0), 0.0f);
  }

  @Test
  public void writeFloat32NonNumbers() {

    write(baseInsert().set("Float32Value").to(Float.NEGATIVE_INFINITY).build());
    Struct row = readLastRow("Float32Value");
    assertFalse(row.isNull(0));
    assertEquals(Float.NEGATIVE_INFINITY, row.getFloat(0), 0.0f);

    write(baseInsert().set("Float32Value").to(Float.POSITIVE_INFINITY).build());
    row = readLastRow("Float32Value");
    assertFalse(row.isNull(0));
    assertEquals(Float.POSITIVE_INFINITY, row.getFloat(0), 0.0);

    write(baseInsert().set("Float32Value").to(Float.NaN).build());
    row = readLastRow("Float32Value");
    assertFalse(row.isNull(0));
    assertTrue(Float.isNaN(row.getFloat(0)));
  }

  @Test
  public void writeFloat32Null() {
    write(baseInsert().set("Float32Value").to((Float) null).build());
    Struct row = readLastRow("Float32Value");
    assertTrue(row.isNull(0));
  }

  @Test
  public void writeFloat32ArrayNull() {
    write(baseInsert().set("Float32ArrayValue").toFloat32Array((float[]) null).build());
    Struct row = readLastRow("Float32ArrayValue");
    assertTrue(row.isNull(0));
  }

  @Test
  public void writeFloat32ArrayEmpty() {
    write(baseInsert().set("Float32ArrayValue").toFloat32Array(new float[] {}).build());
    Struct row = readLastRow("Float32ArrayValue");
    assertFalse(row.isNull(0));
    assertTrue(row.getFloatList(0).isEmpty());
  }

  @Test
  public void writeFloat32Array() {
    write(
        baseInsert()
            .set("Float32ArrayValue")
            .toFloat32Array(Arrays.asList(null, 1.0f, 2.0f))
            .build());
    Struct row = readLastRow("Float32ArrayValue");
    assertFalse(row.isNull(0));
    assertEquals(row.getFloatList(0), Arrays.asList(null, 1.0f, 2.0f));
    assertThrows(NullPointerException.class, () -> row.getFloatArray(0));
  }

  @Test
  public void writeFloat32ArrayNoNulls() {
    write(baseInsert().set("Float32ArrayValue").toFloat32Array(Arrays.asList(1.0f, 2.0f)).build());
    Struct row = readLastRow("Float32ArrayValue");
    assertFalse(row.isNull(0));
    assertEquals(2, row.getFloatArray(0).length);
    assertEquals(1.0f, row.getFloatArray(0)[0], 0.0f);
    assertEquals(2.0f, row.getFloatArray(0)[1], 0.0f);
  }

  private String getInsertStatementWithLiterals() {
    String statement = "INSERT INTO T (Key, Float32Value, Float32ArrayValue) VALUES ";

    if (dialect.dialect == Dialect.POSTGRESQL) {
      statement +=
          "('dml1', 3.14::float8, array[1.1]::float4[]), ('dml2', '3.14'::float4,"
              + " array[3.14::float4, 3.14::float8]::float4[]), ('dml3', 'nan'::real,"
              + " array['inf'::real, (3.14::float8)::float4, 1.2, '-inf']::float4[]), ('dml4',"
              + " 1.175494e-38::real, array[1.175494e-38, 3.4028234e38, -3.4028234e38]::real[]),"
              + " ('dml5', null, null)";
    } else {
      statement +=
          "('dml1', 3.14, [CAST(1.1 AS FLOAT32)]), ('dml2', CAST('3.14' AS FLOAT32),"
              + " array[CAST(3.14 AS FLOAT32), 3.14]), ('dml3', CAST('nan' AS FLOAT32),"
              + " array[CAST('inf' AS FLOAT32), CAST(CAST(3.14 AS FLOAT64) AS FLOAT32), 1.2,"
              + " CAST('-inf' AS FLOAT32)]), ('dml4', 1.175494e-38, [CAST(1.175494e-38 AS FLOAT32),"
              + " 3.4028234e38, -3.4028234e38]), ('dml5', null, null)";
    }
    return statement;
  }

  @Test
  public void float32Literals() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(Statement.of(getInsertStatementWithLiterals()));
              return null;
            });

    verifyContents("dml");
  }

  private String getInsertStatementWithParameters() {
    String pgStatement =
        "INSERT INTO T (Key, Float32Value, Float32ArrayValue) VALUES "
            + "('param1', $1, $2), "
            + "('param2', $3, $4), "
            + "('param3', $5, $6), "
            + "('param4', $7, $8), "
            + "('param5', $9, $10)";

    return (dialect.dialect == Dialect.POSTGRESQL) ? pgStatement : pgStatement.replace("$", "@p");
  }

  @Test
  public void float32Parameter() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder(getInsertStatementWithParameters())
                      .bind("p1")
                      .to(Value.float32(3.14f))
                      .bind("p2")
                      .to(Value.float32Array(Arrays.asList(1.1f)))
                      .bind("p3")
                      .to(Value.float32(3.14f))
                      .bind("p4")
                      .to(Value.float32Array(new float[] {3.14f, 3.14f}))
                      .bind("p5")
                      .to(Value.float32(Float.NaN))
                      .bind("p6")
                      .to(
                          Value.float32Array(
                              Arrays.asList(
                                  Float.POSITIVE_INFINITY, 3.14f, 1.2f, Float.NEGATIVE_INFINITY)))
                      .bind("p7")
                      .to(Value.float32(Float.MIN_NORMAL))
                      .bind("p8")
                      .to(
                          Value.float32Array(
                              Arrays.asList(
                                  Float.MIN_NORMAL, Float.MAX_VALUE, -1 * Float.MAX_VALUE)))
                      .bind("p9")
                      .to(Value.float32(null))
                      .bind("p10")
                      .to(Value.float32Array((float[]) null))
                      .build());
              return null;
            });

    verifyContents("param");
  }

  private String getInsertStatementForUntypedParameters() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO T (key, float32value, float32arrayvalue) VALUES "
          + "('untyped1', ($1)::float4, ($2)::float4[])";
    }
    return "INSERT INTO T (Key, Float32Value, Float32ArrayValue) VALUES "
        + "('untyped1', CAST(@p1 AS FLOAT32), CAST(@p2 AS ARRAY<FLOAT32>))";
  }

  @Test
  public void float32UntypedParameter() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder(getInsertStatementForUntypedParameters())
                      .bind("p1")
                      .to(
                          Value.untyped(
                              com.google.protobuf.Value.newBuilder()
                                  .setNumberValue((double) 3.14f)
                                  .build()))
                      .bind("p2")
                      .to(
                          Value.untyped(
                              com.google.protobuf.Value.newBuilder()
                                  .setListValue(
                                      com.google.protobuf.ListValue.newBuilder()
                                          .addValues(
                                              com.google.protobuf.Value.newBuilder()
                                                  .setNumberValue((double) Float.MIN_NORMAL)))
                                  .build()))
                      .build());
              return null;
            });

    Struct row = readRow("T", "untyped1", "Float32Value", "Float32ArrayValue");
    // Float32Value
    assertFalse(row.isNull(0));
    assertEquals(3.14f, row.getFloat(0), 0.00001f);
    // Float32ArrayValue
    assertFalse(row.isNull(1));
    assertEquals(1, row.getFloatList(1).size());
    assertEquals(Float.MIN_NORMAL, row.getFloatList(1).get(0), 0.00001f);
  }

  private void verifyContents(String keyPrefix) {
    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT Key AS key, Float32Value AS float32value, Float32ArrayValue AS float32arrayvalue FROM T WHERE Key LIKE '{keyPrefix}%' ORDER BY key"
                        .replace("{keyPrefix}", keyPrefix)))) {

      assertTrue(resultSet.next());

      assertEquals(3.14f, resultSet.getFloat("float32value"), 0.00001f);
      assertEquals(Value.float32(3.14f), resultSet.getValue("float32value"));

      assertArrayEquals(new float[] {1.1f}, resultSet.getFloatArray("float32arrayvalue"), 0.00001f);

      assertTrue(resultSet.next());

      assertEquals(3.14f, resultSet.getFloat("float32value"), 0.00001f);
      assertEquals(Arrays.asList(3.14f, 3.14f), resultSet.getFloatList("float32arrayvalue"));
      assertEquals(
          Value.float32Array(new float[] {3.14f, 3.14f}), resultSet.getValue("float32arrayvalue"));

      assertTrue(resultSet.next());
      assertTrue(Float.isNaN(resultSet.getFloat("float32value")));
      assertTrue(Float.isNaN(resultSet.getValue("float32value").getFloat32()));
      assertEquals(
          Arrays.asList(Float.POSITIVE_INFINITY, 3.14f, 1.2f, Float.NEGATIVE_INFINITY),
          resultSet.getFloatList("float32arrayvalue"));
      assertEquals(
          Value.float32Array(
              Arrays.asList(Float.POSITIVE_INFINITY, 3.14f, 1.2f, Float.NEGATIVE_INFINITY)),
          resultSet.getValue("float32arrayvalue"));

      assertTrue(resultSet.next());
      assertEquals(Float.MIN_NORMAL, resultSet.getFloat("float32value"), 0.00001f);
      assertEquals(Float.MIN_NORMAL, resultSet.getValue("float32value").getFloat32(), 0.00001f);
      assertEquals(3, resultSet.getFloatList("float32arrayvalue").size());
      assertEquals(Float.MIN_NORMAL, resultSet.getFloatList("float32arrayvalue").get(0), 0.00001);
      assertEquals(Float.MAX_VALUE, resultSet.getFloatList("float32arrayvalue").get(1), 0.00001f);
      assertEquals(
          -1 * Float.MAX_VALUE, resultSet.getFloatList("float32arrayvalue").get(2), 0.00001f);
      assertEquals(3, resultSet.getValue("float32arrayvalue").getFloat32Array().size());

      assertTrue(resultSet.next());
      assertTrue(resultSet.isNull("float32value"));
      assertTrue(resultSet.isNull("float32arrayvalue"));

      assertFalse(resultSet.next());
    }
  }
}
