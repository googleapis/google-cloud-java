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

package com.google.cloud.spanner.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
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
import java.util.UUID;
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

/**
 * Class for running integration tests for UUID data type. It tests read and write operations
 * involving UUID as key and non-key columns.
 */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITUuidTest {

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
            + "  UuidValue           UUID,"
            + "  UuidArrayValue      ARRAY<UUID>,"
            + ") PRIMARY KEY (Key)",
        "CREATE TABLE UK (" + "  Key UUID NOT NULL," + ") PRIMARY KEY (Key)",
      };

  private static final String[] POSTGRESQL_SCHEMA =
      new String[] {
        "CREATE TABLE T ("
            + "  Key              VARCHAR PRIMARY KEY,"
            + "  UuidValue        UUID,"
            + "  UuidArrayValue   UUID[]"
            + ")",
        "CREATE TABLE UK (" + "  Key UUID PRIMARY KEY" + ")",
      };

  private static DatabaseClient client;

  private UUID uuid1 = UUID.fromString("aac68fbe-6847-48b1-8373-110950aeaf3a");
  ;
  private UUID uuid2 = UUID.fromString("f5868be9-7983-4cfa-adf3-2e9f13f2019d");

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

  private Timestamp deleteAllRows(String table) {
    return write(Mutation.delete(table, KeySet.all()));
  }

  @Test
  public void writeUuid() {
    UUID uuid = UUID.randomUUID();
    write(baseInsert().set("UuidValue").to(uuid).build());
    Struct row = readLastRow("UuidValue");
    assertFalse(row.isNull(0));
    assertEquals(uuid, row.getUuid(0));
  }

  @Test
  public void writeUuidNull() {
    write(baseInsert().set("UuidValue").to((UUID) null).build());
    Struct row = readLastRow("UuidValue");
    assertTrue(row.isNull(0));
  }

  @Test
  public void writeUuidArrayNull() {
    write(baseInsert().set("UuidArrayValue").toUuidArray(null).build());
    Struct row = readLastRow("UuidArrayValue");
    assertTrue(row.isNull(0));
  }

  @Test
  public void writeUuidArrayEmpty() {
    write(baseInsert().set("UuidArrayValue").toUuidArray(Collections.emptyList()).build());
    Struct row = readLastRow("UuidArrayValue");
    assertFalse(row.isNull(0));
    assertTrue(row.getUuidList(0).isEmpty());
  }

  @Test
  public void writeUuidArray() {
    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();

    write(
        baseInsert().set("UuidArrayValue").toUuidArray(Arrays.asList(null, uuid1, uuid2)).build());
    Struct row = readLastRow("UuidArrayValue");
    assertFalse(row.isNull(0));
    assertEquals(row.getUuidList(0), Arrays.asList(null, uuid1, uuid2));
  }

  @Test
  public void writeUuidArrayNoNulls() {
    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();

    write(baseInsert().set("UuidArrayValue").toUuidArray(Arrays.asList(uuid1, uuid2)).build());
    Struct row = readLastRow("UuidArrayValue");
    assertFalse(row.isNull(0));
    assertEquals(2, row.getUuidList(0).size());
    assertEquals(uuid1, row.getUuidList(0).get(0));
    assertEquals(uuid2, row.getUuidList(0).get(1));
  }

  private String getInsertStatementWithLiterals() {
    String statement = "INSERT INTO T (Key, UuidValue, UuidArrayValue) VALUES ";

    if (dialect.dialect == Dialect.POSTGRESQL) {
      statement +=
          "('dml1', 'aac68fbe-6847-48b1-8373-110950aeaf3a',"
              + " array['aac68fbe-6847-48b1-8373-110950aeaf3a'::uuid]), ('dml2',"
              + " 'aac68fbe-6847-48b1-8373-110950aeaf3a'::uuid,"
              + " array['aac68fbe-6847-48b1-8373-110950aeaf3a'::uuid]),('dml3', null, null),"
              + " ('dml4', 'aac68fbe-6847-48b1-8373-110950aeaf3a'::uuid,"
              + " array['aac68fbe-6847-48b1-8373-110950aeaf3a'::uuid,"
              + " 'f5868be9-7983-4cfa-adf3-2e9f13f2019d'::uuid, null])";
    } else {
      statement +=
          "('dml1', 'aac68fbe-6847-48b1-8373-110950aeaf3a',"
              + " [CAST('aac68fbe-6847-48b1-8373-110950aeaf3a' AS UUID)]), ('dml2',"
              + " CAST('aac68fbe-6847-48b1-8373-110950aeaf3a' AS UUID),"
              + " [CAST('aac68fbe-6847-48b1-8373-110950aeaf3a' AS UUID)]), ('dml3', null, null),"
              + " ('dml4', 'aac68fbe-6847-48b1-8373-110950aeaf3a',"
              + " [CAST('aac68fbe-6847-48b1-8373-110950aeaf3a' AS UUID),"
              + " CAST('f5868be9-7983-4cfa-adf3-2e9f13f2019d' AS UUID), null])";
    }
    return statement;
  }

  @Test
  public void uuidLiterals() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(Statement.of(getInsertStatementWithLiterals()));
              return null;
            });

    verifyNonKeyContents("dml");
  }

  private String getInsertStatementWithParameters() {
    String statement =
        "INSERT INTO T (Key, UuidValue, UuidArrayValue) VALUES "
            + "('param1', $1, $2), "
            + "('param2', $3, $4), "
            + "('param3', $5, $6), "
            + "('param4', $7, $8)";

    return (dialect.dialect == Dialect.POSTGRESQL) ? statement : statement.replace("$", "@p");
  }

  @Test
  public void uuidParameter() {
    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder(getInsertStatementWithParameters())
                      .bind("p1")
                      .to(Value.uuid(uuid1))
                      .bind("p2")
                      .to(Value.uuidArray(Collections.singletonList(uuid1)))
                      .bind("p3")
                      .to(Value.uuid(uuid1))
                      .bind("p4")
                      .to(Value.uuidArray(Collections.singletonList(uuid1)))
                      .bind("p5")
                      .to(Value.uuid(null))
                      .bind("p6")
                      .to(Value.uuidArray(null))
                      .bind("p7")
                      .to(Value.uuid(uuid1))
                      .bind("p8")
                      .to(Value.uuidArray(Arrays.asList(uuid1, uuid2, null)))
                      .build());
              return null;
            });

    verifyNonKeyContents("param");
  }

  private String getInsertStatementForUntypedParameters() {
    if (dialect.dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO T (key, uuidValue, uuidArrayValue) VALUES "
          + "('untyped1', ($1)::uuid, ($2)::uuid[])";
    }
    return "INSERT INTO T (Key, UuidValue, UuidArrayValue) VALUES "
        + "('untyped1', CAST(@p1 AS UUID), CAST(@p2 AS ARRAY<UUID>))";
  }

  @Test
  public void uuidUntypedParameter() {
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
                                  .setStringValue("aac68fbe-6847-48b1-8373-110950aeaf3a")
                                  .build()))
                      .bind("p2")
                      .to(
                          Value.untyped(
                              com.google.protobuf.Value.newBuilder()
                                  .setListValue(
                                      com.google.protobuf.ListValue.newBuilder()
                                          .addValues(
                                              com.google.protobuf.Value.newBuilder()
                                                  .setStringValue(
                                                      "aac68fbe-6847-48b1-8373-110950aeaf3a")))
                                  .build()))
                      .build());
              return null;
            });

    Struct row = readRow("T", "untyped1", "UuidValue", "UuidArrayValue");
    assertEquals(UUID.fromString("aac68fbe-6847-48b1-8373-110950aeaf3a"), row.getUuid(0));
    assertEquals(
        Collections.singletonList(UUID.fromString("aac68fbe-6847-48b1-8373-110950aeaf3a")),
        row.getUuidList(1));
  }

  private String getInsertStatementWithKeyLiterals(UUID uuid1, UUID uuid2) {
    String statement = "INSERT INTO UK (Key) VALUES ";
    if (dialect.dialect == Dialect.POSTGRESQL) {
      statement += "('" + uuid1.toString() + "')," + "('" + uuid2.toString() + "'::uuid)";
    } else {
      statement += "('" + uuid1.toString() + "')," + "(CAST('" + uuid2.toString() + "' AS UUID))";
    }
    return statement;
  }

  @Test
  public void uuidAsKeyLiteral() {
    deleteAllRows("UK");

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.of(getInsertStatementWithKeyLiterals(uuid1, uuid2)));
              return null;
            });

    verifyKeyContents(Arrays.asList(uuid1, uuid2));
  }

  private String getInsertStatementWithKeyParameters() {
    String statement = "INSERT INTO UK (Key) VALUES " + "($1)," + "($2)";
    return (dialect.dialect == Dialect.POSTGRESQL) ? statement : statement.replace("$", "@p");
  }

  @Test
  public void uuidAsKeyParameter() {
    deleteAllRows("UK");
    UUID uuid1 = UUID.fromString("fb907080-48a4-4615-b2c4-c8ccb5bb66a4");
    UUID uuid2 = UUID.fromString("faee3a78-cc54-42fc-baa2-53197fb89e8a");

    client
        .readWriteTransaction()
        .run(
            transaction -> {
              transaction.executeUpdate(
                  Statement.newBuilder(getInsertStatementWithKeyParameters())
                      .bind("p1")
                      .to(Value.uuid(uuid1))
                      .bind("p2")
                      .to(Value.uuid(uuid2))
                      .build());
              return null;
            });

    verifyKeyContents(Arrays.asList(uuid2, uuid1));
  }

  private void verifyKeyContents(List<UUID> uuids) {
    try (ResultSet resultSet =
        client.singleUse().executeQuery(Statement.of("SELECT Key AS key FROM UK ORDER BY key"))) {

      for (UUID uuid : uuids) {
        assertTrue(resultSet.next());
        assertEquals(uuid, resultSet.getUuid("key"));
        assertEquals(Value.uuid(uuid), resultSet.getValue("key"));
      }
    }
  }

  private void verifyNonKeyContents(String keyPrefix) {
    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT Key AS key, UuidValue AS uuidvalue, UuidArrayValue AS uuidarrayvalue FROM T WHERE Key LIKE '{keyPrefix}%' ORDER BY key"
                        .replace("{keyPrefix}", keyPrefix)))) {

      // Row 1
      assertTrue(resultSet.next());
      assertEquals(uuid1, resultSet.getUuid("uuidvalue"));
      assertEquals(Value.uuid(uuid1), resultSet.getValue("uuidvalue"));
      assertEquals(Collections.singletonList(uuid1), resultSet.getUuidList("uuidarrayvalue"));
      assertEquals(
          Value.uuidArray(Collections.singletonList(uuid1)), resultSet.getValue("uuidarrayvalue"));

      // Row 2
      assertTrue(resultSet.next());
      assertEquals(uuid1, resultSet.getUuid("uuidvalue"));
      assertEquals(Value.uuid(uuid1), resultSet.getValue("uuidvalue"));
      assertEquals(Collections.singletonList(uuid1), resultSet.getUuidList("uuidarrayvalue"));
      assertEquals(
          Value.uuidArray(Collections.singletonList(uuid1)), resultSet.getValue("uuidarrayvalue"));

      // Row 3
      assertTrue(resultSet.next());
      assertTrue(resultSet.isNull("uuidvalue"));
      assertTrue(resultSet.isNull("uuidarrayvalue"));

      // Row 4
      assertTrue(resultSet.next());
      assertEquals(uuid1, resultSet.getUuid("uuidvalue"));
      assertEquals(Value.uuid(uuid1), resultSet.getValue("uuidvalue"));
      assertEquals(Arrays.asList(uuid1, uuid2, null), resultSet.getUuidList("uuidarrayvalue"));
      assertEquals(
          Value.uuidArray(Arrays.asList(uuid1, uuid2, null)), resultSet.getValue("uuidarrayvalue"));
    }
  }
}
